grammar pool;

behaviour
    : def* EOF
    ;

def : ID '(' (ID (',' ID)*)? ')' '{' stat* '}' ;

stat: ID '=' expr ';'
    | ID DOT ID '=' expr ';'
    | expr ';'
    ;

expr: ID                                   # AtomId
    | INT                                  # AtomInt
    | BOOL                                 # AtomBool
    | 'this'                               # AtomThis
    | func                                 # AtomFunc
    | 'new' ID '(' (expr (',' expr)*)? ')' # NewObj
    | ID DOT ID                            # FieldAccess
    | ID DOT func                          # MethodCall
    | 'this' DOT ID                        # ThisFieldAccess
    | 'this' DOT func                      # ThisMethodCall
    | LPAREN expr RPAREN                   # Paren
    | SUB expr                             # UnaryMinus
    | NOT expr                             # UnaryNot
    | <assoc=right> expr POW expr          # Power
    | expr (MUL | DIV) expr                # MulDiv
    | expr (SUM | SUB) expr                # AddSub
    | expr (LT | GT | LE | GE | EQEQ | NEQ) expr  # Compare
    | expr AND expr                        # LogicAnd
    | expr OR expr                         # LogicOr
    | expr ASK expr COLON expr             # Ternary
    | expr ASK expr                        # Binary
    ;

func : ID '(' (expr (',' expr)*)? ')' ;

AND    : 'and' ;
BOOL : 'true' | 'false' ;
OR     : 'or' ;
NOT    : 'not' ;
EQ     : '=' ;
EQEQ   : '==' ;
NEQ    : '!=' ;
LE     : '<=' ;
GE     : '>=' ;
LT     : '<' ;
GT     : '>' ;
COMMA  : ',' ;
SEMI   : ';' ;
LPAREN : '(' ;
RPAREN : ')' ;
LCURLY : '{' ;
RCURLY : '}' ;
SUM    : '+' ;
SUB    : '-' ;
MUL    : '*' ;
DIV    : '/' ;
POW    : '^' ;
DOT    : '.' ;
COLON  : ':' ;
ASK    : '?' ;
INT    : [0-9]+ ;
ID     : [a-zA-Z_][a-zA-Z_0-9]* ;
WS     : [ \t\n\r\f]+ -> skip ;
