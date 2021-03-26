grammar g;

prog: (dcl | stmt | func | func_call)* EOF
    ;
dcl: TYPE (assign | array_dcl) SEMICOLON
   ;
func: (TYPE | VOID) ID LP (param)? RP blok
    ;
param: TYPE ID (COMMA TYPE ID)*
    ;
array_dcl: ID L_BRACKET R_BRACKET ASSIGN_OP L_BRACE (val(COMMA val)*) R_BRACE
    ;
stmt: assign SEMICOLON | expr SEMICOLON | func_call SEMICOLON | selection | iterative | comment
    ;
comment: LINE_COMMENT
    ;
iterative: FOR val TO val blok
    ;
assign: ID ASSIGN_OP (expr | func_call | array_assign)
    ;
array_assign: ID L_BRACKET (NUMBER | expr) R_BRACKET (expr)?
    ;
expr: (MINUS)? val(aritmetisk_operation val)?
    ;
func_call: ID LP (ID ':' expr (COMMA ID ':' expr)*)? RP
    ;
selection: IF LP logical_expr RP blok (ELSE blok)?
    ;
logical_expr: expr COMPARER_OP expr ((AND | OR) logical_expr)?
    ;
blok: L_BRACE (dcl | stmt | return_expr) R_BRACE
    ;
return_expr: RETURN expr SEMICOLON
    ;
val: ID | NUMBER
    ;
aritmetisk_operation: (ARITHMETIC_OP)?
    ;

// TOKEN TABEL
TYPE: 'int'
    | 'double'
    ;
SEMICOLON: ';'
    ;
ID: ('a'..'z') // Skal lige have lidt flere
    ;
ASSIGN_OP: '='
    ;
MINUS: '-'
    ;
NUMBER: ('1'..'9') // Skal også have lidt flere tror jeg
    ;
ARITHMETIC_OP: MOD | PLUS | MINUS | MULTIPLICATION | DIVISION
    ;
MOD: '%'
    ;
PLUS: '+'
    ;
MULTIPLICATION: '*'
    ;
DIVISION: '/'
    ;
LP: '('
    ;
RP: ')'
    ;
COMMA: ','
    ;
COMPARER_OP: LESS_THAN | GREATER_THAN | LESS_THAN_EQ | GREATER_THAN_EQ
    ;
LESS_THAN: '<'
    ;
GREATER_THAN: '>'
    ;
LESS_THAN_EQ: '<='
    ;
GREATER_THAN_EQ: '>='
    ;
AND: '&&'
    ;
OR: '||'
    ;
ELSE: 'ELSE'
    ;
L_BRACE: '{'
    ;
R_BRACE: '}'
    ;
RETURN: 'return'
    ;
L_BRACKET: '['
    ;
R_BRACKET: ']'
    ;
FOR: 'for'
    ;
TO: 'to'
    ;
LINE_COMMENT: '//'
    ;
VOID: 'void'
    ;
IF: 'if'
    ;