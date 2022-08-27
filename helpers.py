'''
    Helpers

Created By:

Juan Diego Solorzano
Juan Fernando De Leon

'''

GLOBAL = 'Global'

ATTR = 'attr'
METHOD = 'method'
PARAMETER = 'parameter'
CLASS = 'class'

SELF_TYPE = 'SELF_TYPE'

KIND_TABLE_ERROR = {
    ATTR: 'Variable',
    METHOD: 'Método',
    PARAMETER: 'Parámetro',
    CLASS: 'Clase'
}

CLASS = 1
ELSE = 2
FI = 3
IF = 4
IN = 5
INHERITS = 6
ISVOID = 7
LOOP = 8
POOL = 9
THEN = 10
WHILE = 11
NEW = 12
NOT = 13
LET = 14
FALSE = 15
TRUE = 16
SEMICOLON = 17
LCURLY = 18
RCURLY = 19
LSQUARE = 20
RSQUARE = 21
LROUND = 22
RROUND = 23
COMMA = 24
POINT = 25
QUOTES = 26
APOSTROPHE = 27
ADD = 28
SUB = 29
MULTIPLY = 30
DIVIDE = 31
INT_NOT = 32
COLON = 33
ASIGN = 34
ARROBA = 35
LESS_THAN = 36
LESS_EQUAL = 37
EQUAL = 38
LINE_COMMENT = 39
COMMENT = 40
INTEGER = 41
STRING = 42
TYPE = 43
ID = 44
WS = 45

def error(message, line=None):
    '''Error msg'''

    if line is not None:
        print('ERROR: %s\n\tLinea [%s:]' % (message, str(line)))
        return 'ERROR: %s\n\tLinea [%s:]' % (message, str(line))
    else:
        print('ERROR:%s\t\t' % (message))
        return 'ERROR:%s\t\t' % (message)
    
    

def indx(arr: list, element) -> int:
    try:
        return arr.index(element)
    except ValueError:
        return -1
