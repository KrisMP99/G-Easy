grammar GEasy;

// Parser rules
prog: (dcl | stmt | func_call )* EOF ;
dcl : (assign | var_dcl | func_dcl) SEMICOLON ;

var_dcl : (num_dcl | pos_dcl | array_dcl) ;

num_dcl : TYPE ID ASSIGN_OP (expr | func_call) ;

pos_dcl : POS ID ASSIGN_OP pos_assign ;

array_dcl : TYPE ID L_BRACKET R_BRACKET ASSIGN_OP L_BRACE (val (COMMA val)*) R_BRACE ;

assign : (ID | array_access) ASSIGN_OP (expr | func_call | pos_assign) ;

pos_assign : (L_BRACE XCOORD (MINUS)? val COMMA YCOORD (MINUS)? val R_BRACE) ;

array_access : ID L_BRACKET expr R_BRACKET ;

expr : (MINUS)? (val | array_access) (ARITHMETIC_OP (val | array_access) (ARITHMETIC_OP expr)? )? ;

func_call : ID LP actual_param RP ;

actual_param : (ID COLON expr ( COMMA actual_param)*)? ;

stmt : assign SEMICOLON
     | expr SEMICOLON
     | func_call SEMICOLON
     | selection
     | iterative
     | comment
     ;

/*

selection : IF LP (logical_expr | BOOL) RP block (ELSE block)? ;
logical_expr : (expr | BOOL) (COMPARER_OP | AND | OR) (expr | BOOL) ((AND | OR ) logical_expr)? ;

*/

selection : IF LP logical_expr RP block (ELSE block)? ;

iterative : FOR (MINUS)? val TO (MINUS)? val block ;

logical_expr : BOOL | ((expr | BOOL) (COMPARER_OP | AND | OR) (expr | BOOL) ((AND | OR) logical_expr)?) ;

func_dcl : (TYPE | VOID | BOOL_T) ID LP (formal_param)? RP block ;

formal_param : TYPE ID (COMMA TYPE ID)* ;

block : L_BRACE (dcl | stmt | return_expr)+ R_BRACE ;

return_expr : RETURN (expr | BOOL) SEMICOLON ;

val : ID
    | NUMBER
    ;

comment : LINE_COMMENT ;

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

BOOL : TRUE
     | FALSE
     ;

TRUE : 'true' ;
FALSE : 'false' ;

COMPARER_OP : LESS_THAN
            | GREATER_THAN
            | LESS_THAN_EQ
            | GREATER_THAN_EQ
            | NOT_EQ
            | IS_EQ
            ;

LESS_THAN : '<' ;
GREATER_THAN : '>' ;
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