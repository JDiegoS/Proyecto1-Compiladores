grammar scanner;	


NEWLINE: '\r'? '\n' -> skip;
WS: [ \n\t\r]+ -> skip;
SINGLECOMMENT: '--' ~[\r\n]* -> skip;
MULTICOMMENT: '(*' .*? '*)' -> skip;

INHERITS: 'inherits' | 'INHERITS';
CLASS: 'class' | 'CLASS';
TYPE: [A-Z_][_A-Za-z0-9]*;
ID: [a-z_][_A-Za-z0-9]*;
INT: [0-9]+;
SEMICOLON: ';';
TRUE: 'true';
FALSE: 'false';
FI: 'fi';
IF: 'if';
IN: 'in';
ISVOID: 'isvoid';
LET: 'let';
LOOP: 'loop';
POOL: 'pool';
THEN: 'then';
ELSE: 'else';
WHILE: 'while';
CASE: 'case';
ESAC: 'esac';
NEW: 'new';
OF: 'of';
NOT: 'not';

LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
COLON: ':';
ASSIGN: '<-';
DARROW: '=>';
NEG: '~';
COMMA: ',';
PERIOD: '.';
AT: '@';
MUL: '*';
ADD: '+';
MINUS: '-';
DIV: '/';
LT: '<';
LEQUALS: '<=';
EQUALS: '=';
ERROR: . ;
STRING: '"' ( ESC | .)*? '"'{
    String text = getText();
    int len = text.length();

    for (int i = 1; i < len - 1; ) {
        if (text.charAt(i) == '\\' && i + 1 < len && text.charAt(i+1) == '\u0000'){
            setText("Caracter de nueva linea no escapado");
            setType(ERROR);
            return;
        }
        i++;
    }
    if (len > 1000){
        setText("Tamanio de string excedido");
        setType(ERROR);
        return;
    }
};

fragment ESC: '\\"' | '\\\\';
