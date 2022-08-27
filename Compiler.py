import os
from antlr4 import *
from ParserLexer import ParserLexer
from ParserListener import ParserListener
from ParserParser import ParserParser
from ParserVisitor import ParserVisitor
from MyErrorListener import MyErrorListener

from SymbolsTable import SymbolTable
from helpers import *

class Compiler(object):
    def __init__(self):
        
        self.errors = []

    def compile(self, file):
        data = FileStream(file)
        lexer = ParserLexer(data)
        stream = CommonTokenStream(lexer)
        parser = ParserParser(stream)
        parser.removeErrorListeners()
        myErrorListener = MyErrorListener()
        parser.addErrorListener(myErrorListener)
        tree = parser.program()

        syntaxErrors = myErrorListener.getErrors()
        self.errors += syntaxErrors
        if len(syntaxErrors) > 0:
            return

        #Arbol
        #os.system('grun Parser program test2.cl -gui -tokens')

        print("\n\n")

        # Tabla
        printer = MyListener()
        walker = ParseTreeWalker()

        # Predefinir clases IO, Int, Bool, String
        predefined = [
            {
                'name': 'IO',
                'type': 'Object',
                'kind': 'class',
                'scope': 'Global',
                'line': 0,
                'value': ''
            },
            {
                'name': 'Bool',
                'type': 'Object',
                'kind': 'class',
                'scope': 'Global',
                'line': 0,
                'value': ''
            },
            {
                'name': 'Int',
                'type': 'Object',
                'kind': 'class',
                'scope': 'Global',
                'line': 0,
                'value': ''
            },
            {
                'name': 'String',
                'type': 'Object',
                'kind': 'class',
                'scope': 'Global',
                'line': 0,
                'value': ''
            },
            {
                'name': 'out_string',
                'type': 'SELF_TYPE',
                'kind': 'method',
                'scope': 'IO',
                'line': 0,
                'value': ''
            },
            {
                'name': 'string',
                'type': 'String',
                'kind': 'parameter',
                'scope': 'out_string',
                'line': 0,
                'value': ''
            },
            {
                'name': 'in_string',
                'type': 'String',
                'kind': 'method',
                'scope': 'IO',
                'line': 0,
                'value': ''
            },
            {
                'name': 'out_int',
                'type': 'SELF_TYPE',
                'kind': 'method',
                'scope': 'IO',
                'line': 0,
                'value': ''
            },
            {
                'name': 'number',
                'type': 'Int',
                'kind': 'parameter',
                'scope': 'out_int',
                'line': 0,
                'value': ''
            },
            {
                'name': 'in_int',
                'type': 'Int',
                'kind': 'method',
                'scope': 'IO',
                'line': 0,
                'value': ''
            },
            {
                'name': 'length',
                'type': 'Int',
                'kind': 'method',
                'scope': 'String',
                'line': 0,
                'value': ''
            },
            {
                'name': 'concat',
                'type': 'String',
                'kind': 'method',
                'scope': 'String',
                'line': 0,
                'value': ''
            },
            {
                'name': 's',
                'type': 'String',
                'kind': 'parameter',
                'scope': 'concat',
                'line': 0,
                'value': ''
            },
            {
                'name': 'substr',
                'type': 'String',
                'kind': 'method',
                'scope': 'String',
                'line': 0,
                'value': ''
            },
            {
                'name': 'i',
                'type': 'Int',
                'kind': 'parameter',
                'scope': 'substr',
                'line': 0,
                'value': ''
            },
            {
                'name': 'l',
                'type': 'Int',
                'kind': 'parameter',
                'scope': 'substr',
                'line': 0,
                'value': ''
            },
        ]
        printer.symbol_table.table = predefined

        walker.walk(printer, tree)
        
        table = printer.getTable()
        self.errors += printer.symbol_table.errors

        # Errores semanticos
        visitor = MyVisitor(table)
        visitor.visit(tree)
        self.errors += visitor.errors

        if visitor.hasMain == False:
            self.errors.append("ERROR: No se encontro la clase Main\n")
            print("ERROR: No se encontro la clase Main\n")

        if visitor.hasMainMethod == False:
            self.errors.append("ERROR: No se encontro el metodo main\n")
            print("ERROR: No se encontro el metodo main\n")

        if len(self.errors) == 0:
            self.errors.append("Analizado sin errores!")
            print("Analizado sin errores!")

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
        kind = 'class'
        ind = indx(children, 'inherits')
        typ = children[ind + 1] if ind != -1 and (children[ind + 1], 'class') in map(lambda x: (x['name'], x['kind']), self.symbol_table.table) else 'Object'
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

    # Enter a parse tree produced by ParserParser#class.
    def enterClassDec(self, ctx):
        self.insert_class(ctx)
        self.symbol_table.push_scope(ctx.children[1].getText())
        self.insert_self(ctx.children[0].symbol.line)

    # Exit a parse tree produced by ParserParser#class.
    def exitClassDec(self, ctx):
        self.symbol_table.pop_scope()

    # Enter a parse tree produced by ParserParser#feature.
    def enterMethodFeature(self, ctx: ParserParser.MethodFeatureContext):
        self.insert_feature(ctx)
    
    def enterAssignFeature(self, ctx: ParserParser.AssignFeatureContext):
        self.insert_feature(ctx)

    
    # Exit a parse tree produced by ParserParser#feature.
    def exitMethodFeature(self, ctx):
        if ctx.children[1].getText() != ':':
            self.symbol_table.pop_scope()

    def exitAssignFeature(self, ctx):
        if ctx.children[1].getText() != ':':
            self.symbol_table.pop_scope()

    # Enter a parse tree produced by ParserParser#Param.
    def enterParam(self, ctx: ParserParser.ParamContext):
        self.insert_param(ctx)

    # Enter a parse tree produced by ParserParser#expr.
    def enterExpr(self, ctx: ParserParser.ExprContext):
        children = list(map(lambda x: x.getText(), ctx.children))
        if '<-' in children:
            self.assign_value(ctx)



class MyVisitor(ParserVisitor):   
    def __init__(self, table):
        self.table = table
        self.errors = []
        self.hasMain = False
        self.hasMainMethod = False
        self.current_scope = 'Global'
        self.types = ['Bool', 'Int', 'String', 'IO']

        for i in table:
            if i['kind'] == 'class' and i['name'] not in self.types:
                self.types.append(i['name'])
    
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
        if '<-' in ctx.getText():
            if bypass == False:
                self.visitAssignExpr(ctx, True)
                return

            else:
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


    #Visits
    def visitClassDec(self, ctx):
        if ctx.name.text == 'Main':
            self.hasMain = True
            if ctx.inherits != None:
                self.errors.append("ERROR: La clase Main no puede heredar\n")
                print("ERROR: La clase Main no puede heredar\n")
                return self.visitChildren(ctx)
        if ctx.inherits != None:
            ''' Herencia multiple
            if ',' in ctx.inherits.text or '.' in ctx.inherits.text:
                self.errors.append("ERROR: No se permite la herencia multiple o recursiva\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
                print("ERROR: No se permite la herencia multiple o recursiva\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
                return self.visitChildren(ctx)
                '''
            if ctx.inherits.text not in self.types:
                self.errors.append("ERROR: No se encontro la herencia '%s'\n\tLinea [%s:%s] \n\t\t%s" % (ctx.inherits.text, ctx.start.line, ctx.start.column, 'class ' + ctx.name.text + ' inherits ' + ctx.inherits.text))
                print("ERROR: No se encontro la herencia '%s'\n\tLinea [%s:%s] \n\t\t%s" % (ctx.inherits.text, ctx.start.line, ctx.start.column, 'class ' + ctx.name.text + ' inherits ' + ctx.inherits.text))

        self.current_scope = ctx.name.text
        self.visitChildren(ctx)
        self.current_scope = 'Global'
        return 
            

    def visitMethodFeature(self, ctx):
        if ctx.name.text == 'main':
            self.hasMainMethod = True
            if ctx.parameter != None:
                self.errors.append("ERROR: El metodo main no puede recibir parametros\n")
                print("ERROR: El metodo main no puede recibir parametros\n")
        return self.visitChildren(ctx)

    def visitIdExpr(self, ctx:ParserParser.IdExprContext):
        return 'ID'

    def visitIntExpr(self, ctx:ParserParser.IntExprContext):
        return 'Int'
    
    def visitStringExpr(self, ctx:ParserParser.StringExprContext):
        if (len(ctx.getText()) > 30):
            print("ERROR: Longitud de string excedida\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
            self.errors.append("ERROR: Longitud de string excedida\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
            

        return 'String'
    
    def visitTrueExpr(self, ctx:ParserParser.TrueExprContext):
        return 'Bool'
    
    def visitFalseExpr(self, ctx:ParserParser.TrueExprContext):
        return 'Bool'
    
    def visitAddExpr(self, ctx):
        if (self.checkIntOperation(ctx)):
            print("ERROR: No corresponden los tipos de la suma\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
            self.errors.append("ERROR: No corresponden los tipos de la suma\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
        
    
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
            self.errors.append("ERROR: No corresponden los tipos de la multiplicacion\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

            return 'Error'
        return 'Int'

    def visitNegExpr(self, ctx):
        r = self.visit(ctx.right)
        if r == 'ID':
            id = self.getAttribute(ctx.right.getText())
            r = id['type']
        if (r != 'Int'):
            print("ERROR: No corresponden los tipos de la negacion\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
            self.errors.append("ERROR: No corresponden los tipos de la negacion\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

            return 'Error'
        return 'Int'

    def visitNotExpr(self, ctx):
        r = self.visit(ctx.right)
        if r == 'ID':
            id = self.getAttribute(ctx.right.getText())
            r = id['type']
        if (r != 'Bool'):
            print("ERROR: No corresponden los tipos del not\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText().replace('not', 'not ')))
            self.errors.append("ERROR: No corresponden los tipos del not\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText().replace('not', 'not ')))

            return 'Error'
        return 'Bool'
    
    def visitMinusExpr(self, ctx):
        if (self.checkIntOperation(ctx)):
            print("ERROR: No corresponden los tipos de la resta\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
            self.errors.append("ERROR: No corresponden los tipos de la resta\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

            return 'Error'
        return 'Int'
    
    def visitDivExpr(self, ctx):
        if (self.checkIntOperation(ctx)):
            print("ERROR: No corresponden los tipos de la division\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
            self.errors.append("ERROR: No corresponden los tipos de la division\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

            return 'Error'
        return 'Int'
    
    def visitEqualsExpr(self, ctx:ParserParser.EqualsExprContext):
        l = self.visit(ctx.left)
        r = self.visit(ctx.right)

        if (self.checkDifferentType(l, r, ctx.right.getText(), ctx.left.getText())):
            print("ERROR: No corresponden los tipos de la comparacion =\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
            self.errors.append("ERROR: No corresponden los tipos de la comparacion =\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

            return 'Error'
        return 'Bool'
    
    def visitLequalExpr(self, ctx):
        l = self.visit(ctx.left)
        r = self.visit(ctx.right)

        if (self.checkDifferentType(l, r, ctx.right.getText(), ctx.left.getText())):
            print("ERROR: No corresponden los tipos de la comparacion <=\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
            self.errors.append("ERROR: No corresponden los tipos de la comparacion <=\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

            return 'Error'
        return 'Bool'

    def visitLtExpr(self, ctx:ParserParser.LtExprContext):
        l = self.visit(ctx.left)
        r = self.visit(ctx.right)
        

        if (self.checkDifferentType(l, r, ctx.right.getText(), ctx.left.getText())):
            print("ERROR: No corresponden los tipos de la comparacion <\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
            self.errors.append("ERROR: No corresponden los tipos de la comparacion <\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))

            return 'Error'
        return 'Bool'


    def visitAssignExpr(self, ctx:ParserParser.AssignExprContext, fromOp=False):
        operaciones = ['-', '+', '*', '/', '~']
        if fromOp:
            expression = ctx.getText().split('<-')
            left = expression[0]
            right = expression[1]

            id = self.getAttribute(left)
            if id == None:
                print("ERROR: No se declaro la variable '%s'\n\tLinea [%s:%s] \n\t\t%s" % (left, ctx.start.line, ctx.start.column, ctx.getText()))
                self.errors.append("ERROR: No se declaro la variable '%s'\n\tLinea [%s:%s] \n\t\t%s" % (left, ctx.start.line, ctx.start.column, ctx.getText()))
                return
            l = id['type']

            if any(op in right for op in operaciones):
                r = 'Int'
                if self.checkIntOperation(ctx, True):
                    print("ERROR: No corresponden los tipos de la operacion\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
                    self.errors.append("ERROR: No corresponden los tipos de la operacion\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
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
            if r == None and len(ctx.right.children) > 1:
                for i in ctx.right.children:
                    temp = self.visit(i)
                    if temp != None:
                        r = temp

            id = self.getAttribute(ctx.left.text)
            if id == None:
                print("ERROR: No se declaro la variable '%s'\n\tLinea [%s:%s] \n\t\t%s" % (ctx.left.text, ctx.start.line, ctx.start.column, ctx.getText()))
                self.errors.append("ERROR: No se declaro la variable '%s'\n\tLinea [%s:%s] \n\t\t%s" % (ctx.left.text, ctx.start.line, ctx.start.column, ctx.getText()))
                return
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
            self.errors.append("ERROR: No corresponden los tipos de la asignacion\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
        
        index = [ x['name'] for x in self.table ].index(ctx.left.text)
        self.table[index]['value'] = ctx.right.getText()


    def visitAssignFeature(self, ctx:ParserParser.AssignFeatureContext):
        if (ctx.right != None):
            if (len(ctx.right.getText()) > 0):

                l = ctx.left.text
                r = self.visit(ctx.right)

                if (l != r):
                        print("ERROR: No corresponden los tipos de la asignacion\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
                        self.errors.append("ERROR: No corresponden los tipos de la asignacion\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
        return self.visitChildren(ctx)

    def visitNewExpr(self, ctx):
        return ctx.right.text
        
    def visitMethodDotExpr(self, ctx):

        exprType = 'Error'
        
        expr = self.getAttribute(ctx.left.getText())
        if expr != None:
            exprType = expr['type']

        else:
            exprT = self.visit(ctx.left)
            if exprT == None:
                for i in ctx.left.children:
                    temp = self.visit(i)
                    if temp != None:
                        exprType = temp



        attr = self.getAttribute(exprType)
        if attr != None:
            methodType = list(filter(lambda x: (x['name'] == ctx.name.text) and ((x['scope'] == exprType) or x['scope'] == attr['type']), self.table))
        else:
            methodType = list(filter(lambda x: (x['name'] == ctx.name.text) and (x['scope'] == exprType), self.table))
        if len(methodType) > 0: 
            methodType = methodType[0]['type']
            if methodType == 'Object':
                methodType = exprType
        
            if methodType == 'SELF_TYPE':
                methodType = exprType
            return methodType
         

    
    def visitMethodParenExpr(self, ctx):
        attr = self.getAttribute(self.current_scope)
        if attr != None:
            methodType = list(filter(lambda x: (x['name'] == ctx.name.text) and ((x['scope'] == self.current_scope) or x['scope'] == attr['type']), self.table))
        else:
            methodType = list(filter(lambda x: (x['name'] == ctx.name.text) and (x['scope'] == self.current_scope), self.table))
        methodType = methodType[0]['type']
        print(methodType)

        if (ctx.name.text , 'method', self.current_scope) not in map(lambda x: (x['name'], x['kind'], x['scope']), self.table):
            
            if attr != None:
                if (ctx.name.text, 'method', attr['type']) not in map(lambda x: (x['name'], x['kind'], x['scope']), self.table):
                    print("ERROR: No se encontro el metodo '%s'\n\tLinea [%s:%s] \n\t\t%s" % (ctx.name.text, ctx.start.line, ctx.start.column, ctx.getText()))
                    self.errors.append("ERROR: No se encontro el metodo '%s'\n\tLinea [%s:%s] \n\t\t%s" % (ctx.name.text, ctx.start.line, ctx.start.column, ctx.getText()))
                    self.visitChildren(ctx)
                    return methodType

        paramFound = list(filter(lambda x: x['scope'] == ctx.name.text, self.table))
        if len(paramFound) != 0 and ctx.first != None:
            indexStart = ctx.getText().index('(')
            if indexStart != -1:
                params = ctx.getText()[indexStart+1:-1].split(',')
                if len(params) != len(paramFound):
                    
                    print("ERROR: Cantidad de argumentos incorrecta\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
                    self.errors.append("ERROR: Cantidad de argumentos incorrecta\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
                    self.visitChildren(ctx)
                    return methodType
                paramNodes = []
                i = 0
                index = -2
                while i != len(paramFound):
                    paramNodes.append(ctx.children[index])
                    index -= 2
                    i += 1
                paramNodes.reverse()
                paramTypes = []
                for i in paramNodes:
                    val = i.getText()
                    vType = 'Error'
                    if val.isdigit():
                        vType = "Int"
                    elif val == 'true' or val == 'TRUE' or val == 'false' or val == 'FALSE':
                        vType = "Bool"
                    elif val.count('"') == 2:
                        vType = "String"
                    paramTypes.append(vType)

                expectedTypes = list(map(lambda x: x['type'], paramFound))
                if expectedTypes != paramTypes:
                    print("ERROR: Tipo(s) de argumentos no coinciden con la definicion del metodo\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
                    self.errors.append("ERROR: Tipo(s) de argumentos no coinciden con la definicion del metodo\n\tLinea [%s:%s] \n\t\t%s" % (ctx.start.line, ctx.start.column, ctx.getText()))
        self.visitChildren(ctx)
        return methodType
    

main = Compiler()
main.compile('test2.cl')