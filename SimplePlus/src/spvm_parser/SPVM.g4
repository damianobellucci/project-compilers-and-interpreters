grammar SPVM;

// THIS IS THE PARSER INPUT

program: assembly*;

assembly:
	  	instr='push' arg1=REGISTER
	  | instr='pop'
	  | instr='top' arg1=REGISTER
	  | instr='add' arg1=REGISTER arg2=REGISTER arg3=REGISTER
	  | instr='sub' arg1=REGISTER arg2=REGISTER arg3=REGISTER
	  | instr='mult' arg1=REGISTER arg2=REGISTER arg3=REGISTER
	  | instr='div' arg1=REGISTER arg2=REGISTER arg3=REGISTER
	  | instr='neg' arg1=REGISTER arg2=REGISTER
	  | instr='and' arg1=REGISTER arg2=REGISTER arg3=REGISTER
	  | instr='or' arg1=REGISTER arg2=REGISTER arg3=REGISTER
	  | instr='not' arg1=REGISTER arg2=REGISTER
	  | instr='eq' arg1=REGISTER arg2=REGISTER arg3=REGISTER
	  | instr='neq' arg1=REGISTER arg2=REGISTER arg3=REGISTER
	  | instr='geq' arg1=REGISTER arg2=REGISTER arg3=REGISTER
	  | instr='leq' arg1=REGISTER arg2=REGISTER arg3=REGISTER
	  | instr='gr' arg1=REGISTER arg2=REGISTER arg3=REGISTER
	  | instr='ls' arg1=REGISTER arg2=REGISTER arg3=REGISTER
	  | instr='sw' arg1=REGISTER offset=NUMBER '(' arg2=REGISTER ')'
	  | instr='lw' arg1=REGISTER offset=NUMBER '(' arg2=REGISTER ')'
	  | instr='smem' arg1=REGISTER offset=NUMBER '(' arg2=REGISTER ')'
	  | instr='lmem' arg1=REGISTER offset=NUMBER '(' arg2=REGISTER ')'
	  | instr=LABEL ':'
	  | instr='b' arg3=LABEL
	  | instr='beq' arg1=REGISTER arg2=REGISTER arg3=LABEL
	  | instr='bleq' arg1=REGISTER arg2=REGISTER arg3=LABEL
	  | instr='bgeq' arg1=REGISTER arg2=REGISTER arg3=LABEL
	  | instr='addi' arg1=REGISTER arg2=REGISTER arg3=NUMBER
	  | instr='li' arg1=REGISTER arg2=NUMBER
	  | instr='move' arg1=REGISTER arg2=REGISTER
	  | instr='jal' arg3=LABEL
	  | instr='jr' arg1=REGISTER
	  | instr='print' arg1=REGISTER
	  | instr='halt' ;
 

// THIS IS THE LEXER INPUT

//LABELs
fragment 
CHAR		: 'a'..'z' |'A'..'Z' ;
LABEL		: CHAR (CHAR | DIGIT)* ;

//Numbers
fragment 
DIGIT	    : '0'..'9';
NUMBER      : DIGIT+;

//Registers
REGISTER	: '$' CHAR DIGIT
			| '$' CHAR CHAR;

//ESCAPE SEQUENCES
WS              : (' '|'\t'|'\n'|'\r')-> skip;
LINECOMMENTS 	: '//' (~('\n'|'\r'))* -> skip;
BLOCKCOMMENTS   : '/*'( ~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMMENTS)* '*/' -> skip;

