grammar g;

// Parser rules
prog: (dcl | stmt | func | func_call )* EOF ;
dcl : TYPE (assign | array_dcl | pos_dcl) SEMICOLON
    ;

array_dcl : ID L_BRACKET R_BRACKET ASSIGN_OP L_BRACE (val (COMMA val)*) R_BRACE ;

assign : ID ASSIGN_OP (expr | func_call | array_assign) ;

pos_dcl : ID ASSIGN_OP L_BRACE XCOORD COLON expr COMMA YCOORD COLON expr R_BRACE ;

array_assign : ID L_BRACKET (NUMBER  | expr) R_BRACKET (expr)? ;

expr : (MINUS)? val (aritmetisk_operation val)? ;

aritmetisk_operation : (ARITHMETIC_OP)? ;

func_call : ID LP (ID COLON expr ( COMMA ID COLON expr)*)? RP ;

stmt : assign SEMICOLON
     | expr SEMICOLON
     | func_call SEMICOLON
     | selection
     | iterative
     | comment
     ;

selection : IF LP logical_expr RP blok (ELSE blok)? ;

iterative : FOR val TO val blok ;

logical_expr : expr COMPARER_OP expr ((AND | OR) logical_expr)? ;

func : (TYPE | VOID) ID LP (param)? RP blok ;

param : TYPE ID (COMMA TYPE ID)* ;

blok : L_BRACE (dcl | stmt | return_expr )+ R_BRACE ;

return_expr : RETURN expr SEMICOLON ;

val : ID
    | NUMBER
    ;

comment : LINE_COMMENT ;

// Lexer rules - Produces tokens and returns it to the parser
COLON : ':';
COMPARER_OP : LESS_THAN
            | GREATHER_THAN
            | LESS_THAN_EQ
            | GREATER_THAN_EQ
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
MOD : '%' ;
PLUS : '+';
MINUS : '-';
MULTIPLICATION : '*' ;
DIVISION : '/' ;

IF : 'if' ;
ELSE : 'else' ;
FOR : 'for' ;

COMMA: ',';

TYPE : 'int'
     | 'double'
     | 'pos'
     ;

VOID : 'void' ;

TO: 'to' ;

NUMBER : [0-9]+('.'[0-9]+)?
       ;

LINE_COMMENT : '//' (.)*? ;

SEMICOLON : ';' ;

L_BRACKET : '[' ;
R_BRACKET : ']' ;
L_BRACE : '{' ;
R_BRACE : '}' ;
LP : '(' ;
RP : ')' ;

RETURN : 'return' ;

POS : 'pos' ;

XCOORD : 'x';
YCOORD : 'y';

ID :  ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')* ;