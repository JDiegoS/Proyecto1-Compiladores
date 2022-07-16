grammar Parser;
import Scanner;

program:	(newClass)+ EOF ;
newClass: CLASS TYPE (INHERITS TYPE)? LBRACE (feature SEMICOLON)* RBRACE;
feature: ID LPAREN (param (COMMA param)*)* RPAREN COLON TYPE LBRACE expr RBRACE
    |   ID COLON TYPE (ASSIGN expr)?
    ;

param: ID COLON TYPE;

expr: ID ASSIGN expr
    | ID LPAREN (expr (COMMA expr)*)* RPAREN
    | expr (AT TYPE)? PERIOD ID LPAREN (expr (COMMA expr)*)* RPAREN
    | IF expr THEN expr ELSE expr FI
    | WHILE expr LOOP expr POOL
    | LET ID COLON TYPE (ASSIGN expr)? (COMMA ID COLON TYPE (ASSIGN expr)?)* IN expr
    | CASE expr OF (ID COLON TYPE DARROW expr SEMICOLON)+ ESAC
    | NEW TYPE
    | NEG expr
    | ISVOID expr
    | LPAREN expr RPAREN
    | LBRACE (expr SEMICOLON)+ RBRACE
    | expr MUL expr
    | expr DIV expr
    | expr ADD expr
    | expr MINUS expr
    | expr LEQUALS expr
    | expr LT expr
    | expr EQUALS expr
    | NOT expr
    | ID
    | INT
    | STRING
    | TRUE
    | FALSE
    ;
