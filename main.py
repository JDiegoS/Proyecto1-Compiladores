import os
from antlr4 import *
from ParserLexer import ParserLexer
from ParserListener import ParserListener
from ParserParser import ParserParser
from ParserVisitor import ParserVisitor

from SymbolsTable import SymbolTable
from helpers import *

def main():
    data = FileStream("test2.cl")
    lexer = ParserLexer(data)
    stream = CommonTokenStream(lexer)
    parser = ParserParser(stream)
    tree = parser.program()

    #Arbol
    #os.system('grun Parser program test2.cl -gui -tokens')

    # Tabla
    printer = MyListener()
    walker = ParseTreeWalker()
    walker.walk(printer, tree)
    
    table = printer.getTable()

    # Errores semanticos
    print("\n\n")
    visitor = MyVisitor(table)
    visitor.visit(tree)

    finalTable = SymbolTable()
    finalTable.table = visitor.table
    print("\n TABLA DE SIMBOLOS\n")
    print(str(finalTable) + "\n")

    
class MyListener(ParserListener):   
    def __init__(self):
        self.symbol_table = SymbolTable()

    def getTable(self):
        return self.symbol_table.getTable()

    def assign_value(self, ctx: ParserParser.ExprContext):
        self.symbol_table.set(ctx.children[0].getText(), ctx.children[0].symbol.line, ctx.children[2].getText())

    def insert_self(self, line: int):
        name = 'self'
        kind = ATTR
        typ = SELF_TYPE
        scope = self.symbol_table.get_scope()
        self.symbol_table.insert(name, typ, kind, scope, line)

    def insert_class(self, ctx: ParserParser.ClassContext):
        children = list(map(lambda x: x.getText(), ctx.children))
        name = children[1]
        kind = CLASS
        ind = indx(children, 'inherits')
        typ = children[ind + 1] if ind != -1 else 'Object'
        line = ctx.children[0].symbol.line
        scope = self.symbol_table.get_scope()
        self.symbol_table.insert(name, typ, kind, scope, line)

    def insert_feature(self, ctx: ParserParser.FeatureContext):
        children = list(map(lambda x: x.getText(), ctx.children))
        name = children[0]
        kind = METHOD if children[1] != ':' else ATTR
        ind = indx(children, ':')
        typ = children[ind + 1]
        line = ctx.children[0].symbol.line
        value = None
        scope = self.symbol_table.get_scope()

        if kind == 'method':
            self.symbol_table.push_scope(children[0])
        else:
            index = indx(children, '<-')
            if index != -1:
                value = children[index + 1]

        self.symbol_table.insert(name, typ, kind, scope, line, value)
    
    def insert_param(self, ctx: ParserParser.ParamContext):
        children = list(map(lambda x: x.getText(), ctx.children))
        name = children[0]
        kind = PARAMETER
        typ = children[2]
        line = ctx.children[0].symbol.line
        scope = self.symbol_table.get_scope()
        self.symbol_table.insert(name, typ, kind, scope, line)

    def exitProgram(self, ctx: ParserParser.ProgramContext):
        #print(str(self.symbol_table))
        pass

    # Enter a parse tree produced by ParserParser#class.
    def enterClass(self, ctx: ParserParser.ClassContext):
        self.insert_class(ctx)
        self.symbol_table.push_scope(ctx.children[1].getText())
        self.insert_self(ctx.children[0].symbol.line)

    # Exit a parse tree produced by ParserParser#class.
    def exitClass(self, ctx: ParserParser.ClassContext):
        self.symbol_table.pop_scope()

    # Enter a parse tree produced by ParserParser#feature.
    def enterMethodFeature(self, ctx: ParserParser.MethodFeatureContext):
        self.insert_feature(ctx)
    
    def enterAssignFeature(self, ctx: ParserParser.AssignFeatureContext):
        self.insert_feature(ctx)

    # Exit a parse tree produced by ParserParser#feature.
    def exitFeature(self, ctx: ParserParser.FeatureContext):
        if ctx.children[1].getText() != ':':
            self.symbol_table.pop_scope()

    # Enter a parse tree produced by ParserParser#Param.
    def enterParam(self, ctx: ParserParser.ParamContext):
        self.insert_Param(ctx)

    # Enter a parse tree produced by ParserParser#expr.
    def enterExpr(self, ctx: ParserParser.ExprContext):
        children = list(map(lambda x: x.getText(), ctx.children))
        if '<-' in children:
            self.assign_value(ctx)



class MyVisitor(ParserVisitor):   
    def __init__(self, table):
        self.table = table
    
    def getTable(self):
        print(str(self.table))
    
    def getAttribute(self, name):
        for i in self.table:
            if i['name'] == name:
                return i
        return None

    def checkDifferentType(self, l, r, rightText, leftText):
        if (l != r):
            if l != "ID" and r != "ID":
                return True
            else:
                if r == "ID":
                    id = self.getAttribute(rightText)
                    r = id['type']
                else:
                    leftSide = leftText.split('<-')
                    if (len(leftSide) == 1):
                        id = self.getAttribute(leftSide[0])
                    else:
                        id = self.getAttribute(leftSide[1])
                    l = id['type']

                if (l != r):
                    return True
                else:
                    return False
    
    def checkIntOperation(self, ctx, bypass=False):
        if '<-' in ctx.getText() and bypass == False:
            self.visitAssignExpr(ctx, True)
            return
        if '<-' in ctx.left.getText():

            leftSide = ctx.left.getText().split('<-')
            id = self.getAttribute(leftSide[1])
            if id != None:
                l = id['type']
            elif leftSide[1].isdigit():
                l = 'Int'
            else: 
                l = 'Error'
        else:
            l = self.visit(ctx.left)

        r = self.visit(ctx.right)

        if ctx.right.getText() == 'true' or ctx.right.getText() == 'false':
            r = 'Bool'

        if (l != "Int" or r != "Int"):
            if l != "ID" and r != "ID":
                return True
            else:
                if r == "ID":
                    id = self.getAttribute(ctx.right.getText())
                    r = id['type']
                if l == "ID":
                    leftSide = ctx.left.getText().split('<-')
                    if (len(leftSide) == 1):
                        id = self.getAttribute(leftSide[0])
                    else:
                        id = self.getAttribute(leftSide[1])
                    l = id['type']
                    

                if (l != 'Int' or r != 'Int'):
                    return True
                else:
                    return False

    def visitIdExpr(self, ctx:ParserParser.IdExprContext):
        return 'ID'

    def visitIntExpr(self, ctx:ParserParser.IntExprContext):
        return 'Int'
    
    def visitStringExpr(self, ctx:ParserParser.StringExprContext):
        if (len(ctx.getText()) > 30):
            print("ERROR: Longitud de string excedida\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

        return 'String'
    
    def visitTrueExpr(self, ctx:ParserParser.TrueExprContext):
        return 'Bool'
    
    def visitFalseExpr(self, ctx:ParserParser.TrueExprContext):
        return 'Bool'
    
    def visitAddExpr(self, ctx):
        if (self.checkIntOperation(ctx)):
            print("ERROR: No corresponden los tipos de la suma\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
        
    
        #print(l)
        #print(r)
        #print(ctx.right.getText())
        #print(ctx.left.start)
        #print(ctx.right.start.type)
            return 'Error'
        return 'Int'
    
    def visitMulExpr(self, ctx):
        if (self.checkIntOperation(ctx)):
            print("ERROR: No corresponden los tipos de la multiplicacion\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

            return 'Error'
        return 'Int'

    def visitNegExpr(self, ctx):
        r = self.visit(ctx.right)
        if r == 'ID':
            id = self.getAttribute(ctx.right.getText())
            r = id['type']
        if (r != 'Int'):
            print("ERROR: No corresponden los tipos de la negacion\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

            return 'Error'
        return 'Int'

    def visitNotExpr(self, ctx):
        r = self.visit(ctx.right)
        if r == 'ID':
            id = self.getAttribute(ctx.right.getText())
            r = id['type']
        if (r != 'Bool'):
            print("ERROR: No corresponden los tipos del not\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText().replace('not', 'not ')))

            return 'Error'
        return 'Bool'
    
    def visitMinusExpr(self, ctx):
        if (self.checkIntOperation(ctx)):
            print("ERROR: No corresponden los tipos de la resta\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

            return 'Error'
        return 'Int'
    
    def visitDivExpr(self, ctx):
        if (self.checkIntOperation(ctx)):
            print("ERROR: No corresponden los tipos de la division\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

            return 'Error'
        return 'Int'
    
    def visitEqualsExpr(self, ctx:ParserParser.EqualsExprContext):
        l = self.visit(ctx.left)
        r = self.visit(ctx.right)

        if (self.checkDifferentType(l, r, ctx.right.getText(), ctx.left.getText())):
            print("ERROR: No corresponden los tipos de la comparacion =\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

            return 'Error'
        return 'Bool'
    
    def visitLequalExpr(self, ctx):
        l = self.visit(ctx.left)
        r = self.visit(ctx.right)

        if (self.checkDifferentType(l, r, ctx.right.getText(), ctx.left.getText())):
            print("ERROR: No corresponden los tipos de la comparacion <=\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

            return 'Error'
        return 'Bool'

    def visitLtExpr(self, ctx:ParserParser.LtExprContext):
        l = self.visit(ctx.left)
        r = self.visit(ctx.right)
        

        if (self.checkDifferentType(l, r, ctx.right.getText(), ctx.left.getText())):
            print("ERROR: No corresponden los tipos de la comparacion <\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

            return 'Error'
        return 'Bool'


    def visitAssignExpr(self, ctx:ParserParser.AssignExprContext, fromOp=False):
        operaciones = ['-', '+', '*', '/', '~']
        if fromOp:
            expression = ctx.getText().split('<-')
            left = expression[0]
            right = expression[1]

            id = self.getAttribute(left)
            l = id['type']

            if any(op in right for op in operaciones):
                r = 'Int'
                if self.checkIntOperation(ctx, True):
                    print("ERROR: No corresponden los tipos de la operacion\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
            elif '<' in right or '<=' in right:
                r = 'Bool'
            elif self.getAttribute(right) != None:
                r = 'ID'
            elif right.count('"') == 2:
                r = 'String'
            else:
                r = 'Error'
        else:
            r = self.visit(ctx.right)

            id = self.getAttribute(ctx.left.text)
            l = id['type']

            if any(op in ctx.right.getText() for op in operaciones):
                r = 'Int'
            elif '<' in ctx.right.getText() or '<=' in ctx.right.getText():
                r = 'Bool'

        if r == 'ID':
            id = self.getAttribute(ctx.right.getText())
            r = id['type']

        if (l != r):
                print("ERROR: No corresponden los tipos de la asignacion\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
        
        index = [ x['name'] for x in self.table ].index(ctx.left.text)
        self.table[index]['value'] = ctx.right.getText()


    def visitAssignFeature(self, ctx:ParserParser.AssignFeatureContext):
        if (len(ctx.right.getText()) > 0):

            l = ctx.left.text
            r = self.visit(ctx.right)

            if (l != r):
                    print("ERROR: No corresponden los tipos de la asignacion\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

    

if __name__ == "__main__":
    main()