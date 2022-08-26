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
    os.system('grun Parser program test2.cl -gui -tokens')

    # Tabla
    #printer = ParserListener()
    printer = MyListener()
    walker = ParseTreeWalker()
    walker.walk(printer, tree)

    # Errores semanticos
    print("\n\n")
    visitor = MyVisitor()
    visitor.visit(tree)
    
class MyListener(ParserListener):   
    def __init__(self):
        print('hola')
        self.symbol_table = SymbolTable()

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
        print(str(self.symbol_table))

    # Enter a parse tree produced by ParserParser#class.
    def enterClass(self, ctx: ParserParser.ClassContext):
        self.insert_class(ctx)
        self.symbol_table.push_scope(ctx.children[1].getText())
        self.insert_self(ctx.children[0].symbol.line)

    # Exit a parse tree produced by ParserParser#class.
    def exitClass(self, ctx: ParserParser.ClassContext):
        self.symbol_table.pop_scope()

    # Enter a parse tree produced by ParserParser#feature.
    def enterFeature(self, ctx: ParserParser.FeatureContext):
        self.insert_feature(ctx)

    # Exit a parse tree produced by ParserParser#feature.
    def exitFeature(self, ctx: ParserParser.FeatureContext):
        if ctx.children[1].getText() != ':':
            self.symbol_table.pop_scope()

    # Enter a parse tree produced by ParserParser#Param.
    def enterParam(self, ctx: ParserParser.ParamContext):
        self.insert_Param(ctx)

    # Exit a parse tree produced by ParserParser#Param.
    def exitParam(self, ctx: ParserParser.ParamContext):
        pass

    # Enter a parse tree produced by ParserParser#expr.
    def enterExpr(self, ctx: ParserParser.ExprContext):
        children = list(map(lambda x: x.getText(), ctx.children))
        if '<-' in children:
            self.assign_value(ctx)

class MyVisitor(ParserVisitor):    
    def visitAssignExpr(self, ctx:ParserParser.AssignExprContext):
        return self.visitChildren(ctx)

    def visitIdExpr(self, ctx:ParserParser.IdExprContext):
        return 'ID'

    def visitIntExpr(self, ctx:ParserParser.IntExprContext):
        return 'INT'
    
    def visitStringExpr(self, ctx:ParserParser.StringExprContext):
        if (len(ctx.getText()) > 10):
            print("ERROR: Longitud de string excedida\n\tLinea [%s:%s] %s" % (ctx.start.line, ctx.start.column, ctx.getText()))

        return 'STRING'
    
    def visitTrueExpr(self, ctx:ParserParser.TrueExprContext):
        return 'TRUE'
    
    def visitFalseExpr(self, ctx:ParserParser.TrueExprContext):
        return 'FALSE'
    
    def visitAddExpr(self, ctx):
        l = self.visit(ctx.left)
        r = self.visit(ctx.right)

        if ctx.right.getText() == 'true' or ctx.right.getText() == 'false':
            r = 'BOOL'

        if (l != "INT" or r != "INT"):
            if l != "ID" and r != "ID":
                print("ERROR: No corresponden los tipos de la suma\n\tLinea [%s:%s] %s" % (ctx.start.line, ctx.start.column, ctx.getText()))


        #print(l)
        #print(r)
        #print(ctx.right.getText())
        #print(ctx.left.start)
        #print(ctx.right.start.type)
        return self.visitChildren(ctx)
    
    def visitMulExpr(self, ctx):
        l = self.visit(ctx.left)
        r = self.visit(ctx.right)

        if ctx.right.getText() == 'true' or ctx.right.getText() == 'false':
            r = 'BOOL'

        if (l != "INT" or r != "INT"):
            if l != "ID" and r != "ID":
                print("ERROR: No corresponden los tipos de la multiplicacion\n\tLinea [%s:%s] %s" % (ctx.start.line, ctx.start.column, ctx.getText()))

        return self.visitChildren(ctx)
    
    def visitMinusExpr(self, ctx):
        l = self.visit(ctx.left)
        r = self.visit(ctx.right)

        if ctx.right.getText() == 'true' or ctx.right.getText() == 'false':
            r = 'BOOL'

        if (l != "INT" or r != "INT"):
            if l != "ID" and r != "ID":
                print("ERROR: No corresponden los tipos de la resta\n\tLinea [%s:%s] %s" % (ctx.start.line, ctx.start.column, ctx.getText()))

        return self.visitChildren(ctx)
    
    def visitDivExpr(self, ctx):
        l = self.visit(ctx.left)
        r = self.visit(ctx.right)

        if ctx.right.getText() == 'true' or ctx.right.getText() == 'false':
            r = 'BOOL'


        if (l != "INT" or r != "INT"):
            if l != "ID" and r != "ID":
                print("ERROR: No corresponden los tipos de la division\n\tLinea [%s:%s] %s" % (ctx.start.line, ctx.start.column, ctx.getText()))

        return self.visitChildren(ctx)
    
    def visitEqualsExpr(self, ctx:ParserParser.EqualsExprContext):
        l = self.visit(ctx.left)
        r = self.visit(ctx.right)

        if (l != r):
            if l != "ID" and r != "ID":
                print("ERROR: No corresponden los tipos de la comparacion <\n\tLinea [%s:%s] %s" % (ctx.start.line, ctx.start.column, ctx.getText()))

        return self.visitChildren(ctx)
    
    def visitLequalExpr(self, ctx:ParserParser.EqualsExprContext):
        l = self.visit(ctx.left)
        r = self.visit(ctx.right)

        if (l != r):
            if l != "ID" and r != "ID":
                print("ERROR: No corresponden los tipos de la comparacion <=\n\tLinea [%s:%s] %s" % (ctx.start.line, ctx.start.column, ctx.getText()))

        return self.visitChildren(ctx)

    def visitLtExpr(self, ctx:ParserParser.LtExprContext):
        l = self.visit(ctx.left)
        r = self.visit(ctx.right)
        

        if (l != r):
            if l != "ID" and r != "ID":
                print("ERROR: No corresponden los tipos de la comparacion =\n\tLinea [%s:%s] %s" % (ctx.start.line, ctx.start.column, ctx.getText()))

        return self.visitChildren(ctx)

    

if __name__ == "__main__":
    main()