import os
from antlr4 import *
from ParserLexer import ParserLexer
from ParserParser import ParserParser
from ParserVisitor import ParserVisitor

def main():
    data = FileStream("test.cl")
    lexer = ParserLexer(data)
    stream = CommonTokenStream(lexer)
    parser = ParserParser(stream)
    tree = parser.program()

    # Errores semanticos
    visitor = ParserVisitor()
    output = visitor.visit(tree)
    print(output)

    #Arbol
    #os.system('grun Parser program test.cl -gui -tokens')

if __name__ == "__main__":
    main()