grammar Parser;
import Scanner;

program:	(class)+ EOF ;
class: CLASS TYPE (INHERITS TYPE)? LBRACE (feature SEMICOLON)* RBRACE SEMICOLON;
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
    | left=expr MUL right=expr        # MulExpr
    | left=expr DIV right=expr        # DivExpr
    | left=expr ADD right=expr        # AddExpr
    | left=expr MINUS right=expr        # MinusExpr
    | left=expr LEQUALS right=expr        # LequalExpr
    | left=expr LT right=expr        # LtExpr
    | left=expr EQUALS right=expr        # EqualsExpr
    | NOT expr        # NotExpr
    | INT        # IntExpr
    | STRING        # StringExpr
    | TRUE        # TrueExpr
    | FALSE        # FalseExpr
    | ID        # IdExpr
    ;
