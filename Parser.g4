grammar Parser;
import Scanner;

program:	(newClass)+ EOF ;
newClass: CLASS TYPE (INHERITS TYPE)? LBRACE (feature SEMICOLON)* RBRACE SEMICOLON;
feature: ID LPAREN (param (COMMA param)*)* RPAREN COLON TYPE LBRACE expr RBRACE
    |   ID COLON TYPE (ASSIGN expr)?
    ;

param: ID COLON TYPE;

expr: ID ASSIGN expr        # AssignExpr
    | ID LPAREN (expr (COMMA expr)*)* RPAREN        # IdParenExpr
    | expr (AT TYPE)? PERIOD ID LPAREN (expr (COMMA expr)*)* RPAREN        # DotExpr
    | IF expr THEN expr ELSE expr FI        # IfThenExpr
    | WHILE expr LOOP expr POOL        # WhileExpr
    | LBRACE (expr SEMICOLON)+ RBRACE        # BraceExpr
    | LET ID COLON TYPE (ASSIGN expr)? (COMMA ID COLON TYPE (ASSIGN expr)?)* IN expr        # LetExpr
    | NEW TYPE        # NewExpr
    | NEG expr        # NegExpr
    | ISVOID expr        # IsvoidExpr
    | LPAREN expr RPAREN        # ParenExpr
    | expr MUL expr        # MulExpr
    | expr DIV expr        # DivExpr
    | expr ADD expr        # AddExpr
    | expr MINUS expr        # MinusExpr
    | expr LEQUALS expr        # LequalExpr
    | expr LT expr        # LtExpr
    | expr EQUALS expr        # EqualsExpr
    | NOT expr        # NotExpr
    | ID        # IdExpr
    | INT        # IntExpr
    | STRING        # StringExpr
    | TRUE        # TrueExpr
    | FALSE        # FalseExpr
    ;
