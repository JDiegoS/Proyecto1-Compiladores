'''
    Printer Class

Created By:

Juan Diego Solorzano
Juan Fernando De Leon

'''

from ParserListener import ParserListener
from SymbolsTable import SymbolsTable

class GrammarPrinter(ParserListener):
    def __init__(self):
        self.root = None
        
        self.STRING = 'char'
        self.INT = 'int'
        self.BOOLEAN = 'boolean'
        self.VOID = 'void'
        self.ERROR = 'error'

        self.data_type = {
            'char': self.STRING,
            'int': self.INT,
            'boolean': self.BOOLEAN,
            'void': self.VOID,
            'error': self.ERROR
        }

        self.ambitos = []
        self.current_scope = None
        
        self.node_type = {}

        super().__init__()
    
    def PopScope(self):
        self.current_scope.to_table()
        self.current_scope = self.ambitos.pop()
    
    def NewScope(self):
        self.ambitos.append(self.current_scope)
        self.current_scope = SymbolsTable()

    def Find(self, var):
        lookup = self.current_scope.lookup(var)
        if lookup == 0:
            ambitos_reverse = self.ambitos.copy()
            ambitos_reverse.reverse()
            for scope in ambitos_reverse:
                lookup2 = scope.lookup(var)
                if lookup2 != 0:
                    return lookup2
            return 0
        else:
            return lookup
    
    def enterProgram(self, ctx: GrammarParser.ProgramContext):
        print('---------- INICIO --------------')
        self.root = ctx
        self.current_scope = SymbolsTable()
    
    def enterStruct_declr(self, cstx: GrammarParser.Struct_declrContext):
        self.NewScope()
    
    