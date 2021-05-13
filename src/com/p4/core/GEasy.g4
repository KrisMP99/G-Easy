grammar GEasy;

// Parser rules
prog: (dcl | stmt | func_call )* EOF ;
dcl : (assign | var_dcl | func_dcl) ;

var_dcl : (num_dcl | array_dcl | bool_dcl) SEMICOLON ;

num_dcl : TYPE ID ASSIGN_OP (expr | pos_assign) ;

bool_dcl : BOOL_T ID ASSIGN_OP logical_expr ;

array_dcl : TYPE ID L_BRACKET R_BRACKET ASSIGN_OP L_BRACE (term (COMMA term)*) R_BRACE ;

assign : (ID | array_access) ASSIGN_OP (expr | pos_assign) SEMICOLON;

pos_assign : L_BRACE ID COLON expr COMMA ID COLON expr R_BRACE ;

array_access : ID L_BRACKET expr R_BRACKET ;

logical_expr : comp_expr ((AND | OR) comp_expr)* ;

comp_expr : expr (COMPARER_OP expr)? ;

expr : term_expr ((PLUS | MINUS) term_expr)*;

term_expr : term ((MULT | DIV | MOD) term)*;

term : val_expr | ((MINUS)? LP logical_expr RP);

val_expr : (MINUS)? (val | array_access | func_call);

func_call : ID LP (actual_param (COMMA actual_param)*)? RP ;

actual_param : (ID | TYPE) COLON expr ;

stmt : assign SEMICOLON
     | expr SEMICOLON
     | func_call SEMICOLON
     | selection
     | iterative
     | comment
     ;

selection : IF LP logical_expr RP block (ELSE block)? ;

iterative : FOR LP (MINUS)? val TO (MINUS)? val RP block ;

func_dcl : (TYPE | VOID | BOOL_T) ID LP (formal_param (COMMA formal_param)*)? RP block ;

formal_param : TYPE ID ;

block : L_BRACE (dcl | stmt | return_expr)+ R_BRACE ;

return_expr : RETURN (expr | BOOL) SEMICOLON ;

val : ID
    | NUMBER
    | BOOL
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

VOID : 'void' ;
RETURN : 'return' ;

LINE_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN) ;

WHITESPACE
    : [ \t\r\n]+ -> channel(HIDDEN)
;

TYPE : 'int'
     | 'double'
     | 'pos'
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

MINUS : '-';
MOD : '%' ;
PLUS : '+';
MULT : '*' ;
DIV : '/' ;


NUMBER : [0-9]+('.'[0-9]+)? ;
ID :  ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')* ;