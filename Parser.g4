grammar Parser;
import Scanner;

program:	(class)+ EOF ;
class: CLASS name=TYPE (INHERITS inherits=TYPE)? LBRACE (feature SEMICOLON)* RBRACE SEMICOLON   #ClassDec;  
feature: name=ID LPAREN (parameter=param (COMMA param)*)* RPAREN COLON TYPE LBRACE expr RBRACE #MethodFeature
    |   ID COLON left=TYPE (ASSIGN right=expr)?    #AssignFeature
    ;

param: ID COLON TYPE;

expr: left=ID ASSIGN right=expr        # AssignExpr
    | name=ID LPAREN (first=expr (COMMA second=expr)*)* RPAREN        # MethodParenExpr
    | left=expr (AT TYPE)? PERIOD name=ID LPAREN (first=expr (COMMA second=expr)*)* RPAREN        # MethodDotExpr
    | IF expr THEN expr ELSE expr FI        # IfThenExpr
    | WHILE expr LOOP expr POOL        # WhileExpr
    | LBRACE (expr SEMICOLON)+ RBRACE        # BraceExpr
    | LET ID COLON TYPE (ASSIGN expr)? (COMMA ID COLON TYPE (ASSIGN expr)?)* IN expr        # LetExpr
    | NEW right=TYPE        # NewExpr
    | NEG right=expr        # NegExpr
    | ISVOID expr        # IsvoidExpr
    | LPAREN expr RPAREN        # ParenExpr
    | left=expr MUL right=expr        # MulExpr
    | left=expr DIV right=expr        # DivExpr
    | left=expr ADD right=expr        # AddExpr
    | left=expr MINUS right=expr        # MinusExpr
    | left=expr LEQUALS right=expr        # LequalExpr
    | left=expr LT right=expr        # LtExpr
    | left=expr EQUALS right=expr        # EqualsExpr
    | NOT right=expr        # NotExpr
    | INT        # IntExpr
    | STRING        # StringExpr
    | TRUE        # TrueExpr
    | FALSE        # FalseExpr
    | ID        # IdExpr
    ;
