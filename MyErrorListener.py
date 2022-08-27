import sys


class MyErrorListener(object):
    def __init__(self):
        
        self.errors = []

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        error = 'ERROR sintactico:\n\tLinea [%s:%s] %s' % (str(line), str(column), msg.replace('mismatched input', 'se obtuvo').replace('expecting', 'se esperaba').replace('extraneous input', 'se obtuvo'))
        print(error)
        self.errors.append(error)
    
    def getErrors(self):
        return self.errors

    