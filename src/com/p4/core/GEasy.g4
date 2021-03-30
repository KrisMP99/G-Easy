grammar GEasy;

// Parser rules
prog: (dcl | stmt | func | func_call )* EOF ;
dcl : (assign | array_dcl | pos_dcl | var_dcl) SEMICOLON ;

var_dcl : TYPE ID ASSIGN_OP (expr | func_call | array_assign) ;

pos_dcl : POS ID ASSIGN_OP pos_assign ;

array_dcl : TYPE ID L_BRACKET R_BRACKET ASSIGN_OP L_BRACE (val (COMMA val)*) R_BRACE ;

assign : ID ASSIGN_OP ((expr | func_call) | pos_assign) ;

pos_assign : (L_BRACE XCOORD (MINUS)? val COMMA YCOORD (MINUS)? val R_BRACE) ;

array_assign : ID L_BRACKET (NUMBER  | expr) R_BRACKET (expr)? ;

expr : (MINUS)? val (ARITHMETIC_OP val (ARITHMETIC_OP expr)? )? ;

func_call : ID LP (ID COLON expr ( COMMA ID COLON expr)*)? RP ;

stmt : assign SEMICOLON
     | expr SEMICOLON
     | func_call SEMICOLON
     | selection
     | iterative
     | LINE_COMMENT
     ;

selection : IF LP (logical_expr | BOOL) RP blok (ELSE blok)? ;

iterative : FOR (MINUS)? val TO (MINUS)? val blok ;

logical_expr : expr COMPARER_OP expr ((AND | OR ) logical_expr)? ;

func : (TYPE | VOID | BOOL_T) ID LP (param)? RP blok ;

param : TYPE ID (COMMA TYPE ID)* ;

blok : L_BRACE (dcl | stmt | return_expr)+ R_BRACE ;

return_expr : RETURN (expr | BOOL) SEMICOLON ;

val : ID
    | NUMBER
    ;

// Lexer rules - Produces tokens and returns it to the parser
COLON : ':';
COMMA: ',';
SEMICOLON : ';' ;

L_BRACKET : '[' ;
R_BRACKET : ']' ;
L_BRACE : '{' ;
R_BRACE : '}' ;
LP : '(' ;
RP : ')' ;



IF : 'if' ;
ELSE : 'else' ;
FOR : 'for' ;
TO: 'to' ;

POS : 'pos' ;
XCOORD : 'x:';
YCOORD : 'y:';

VOID : 'void' ;
RETURN : 'return' ;

LINE_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN) ;

WHITESPACE
    : [ \t\r\n]+ -> channel(HIDDEN)
;

TYPE : 'int'
     | 'double'
     ;

BOOL_T : 'bool' ;

BOOL : 'true'
     | 'false'
     ;

COMPARER_OP : LESS_THAN
            | GREATHER_THAN
            | LESS_THAN_EQ
            | GREATER_THAN_EQ
            | NOT_EQ
            | IS_EQ
            ;

LESS_THAN : '<' ;
GREATHER_THAN : '>' ;
LESS_THAN_EQ : '<=' ;
GREATER_THAN_EQ : '>=' ;
IS_EQ : '==' ;
NOT_EQ : '!=' ;
OR : '||' ;
AND : '&&' ;
NEGATION : '!' ;
ASSIGN_OP : '=' ;


ARITHMETIC_OP : MOD
              | PLUS
              | MINUS
              | MULTIPLICATION
              | DIVISION
              ;

MINUS : '-';
MOD : '%' ;
PLUS : '+';
MULTIPLICATION : '*' ;
DIVISION : '/' ;

NUMBER : [0-9]+('.'[0-9]+)? ;
ID :  ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')* ;