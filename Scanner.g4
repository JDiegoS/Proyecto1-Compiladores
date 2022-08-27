grammar scanner;	


NEWLINE: '\r'? '\n' -> skip;
WS: [ \n\t\r]+ -> skip;
SINGLECOMMENT: '--' ~[\r\n]* -> skip;
MULTICOMMENT: '(*' .*? '*)' -> skip;

INHERITS: 'inherits' | 'INHERITS';
CLASS: 'class' | 'CLASS';
TYPE: [A-Z_][_A-Za-z0-9]*;
INT: [0-9]+;
SEMICOLON: ';';
TRUE: 'true' | 'TRUE';
FALSE: 'false' | 'FALSE';
FI: 'fi' | 'FI';
IF: 'if' | 'IF';
IN: 'in' | 'IN';
ISVOID: 'isvoid' | 'ISVOID';
LET: 'let' | 'LET';
LOOP: 'loop' | 'LOOP';
POOL: 'pool' | 'POOL';
THEN: 'then' | 'THEN';
ELSE: 'else' | 'ELSE';
WHILE: 'while' | 'WHILE';
CASE: 'case' | 'CASE';
ESAC: 'esac' | 'ESAC';
NEW: 'new' | 'NEW';
OF: 'of' | 'OF';
NOT: 'not' | 'NOT';
ID: [a-z_][_A-Za-z0-9]*;

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
STRING: '"' ( ESC | .)*? '"';

fragment ESC: '\\"' | '\\\\';
