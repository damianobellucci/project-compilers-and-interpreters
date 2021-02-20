package interpreter;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Interpreter {
	public static final int MEMSIZE = 1000;
	
	//codice bytecode
	private List<Node> code;
	
	//pila
	private int[] memory = new int[MEMSIZE];
	
	//registri
	private int ip = 0;
	private int sp = MEMSIZE;
	private int fp = MEMSIZE;
	private int ra;
	private int al;
	private int a0;
	private int t1;
	
	/**
	 * Si crea un interprete che rappresenta lo stato di esecuzione del bytecode
	 */
	public Interpreter(List<Node> code) {
		
		this.code = code;
	}
	
	/**
	 * Analisi del bytecode e generazione del codice per l'esecuzione
	 * In particolare generazione degli offset a partire dalle etichette e istruzioni di salto
	 */
	public void prepareCode() {
		
		List<Node> newCode = new ArrayList<Node>();
		
		int i = 0;
		
		Map<String, Integer> labelList = new HashMap<String, Integer>();	//mappa etichetta-istruzione bytecode
		
		Map<Integer, String> labelReference = new HashMap<Integer, String>();	//mappa linea bytecode-etichetta a cui saltare
		
		//scansione per riferimenti etichette
		for(Node node : code) {
			
			if(node.isLabel())
				//se è un'etichetta si registra la linea di codice a cui si trova l'etichetta
				//non viene generato codice
				labelList.put(node.getInstruction(), i);
			else if(node.isBranch()) {
				//se è un'istruzione di salto si registra la linea di codice e l'etichetta a cui si vuole saltare
				//l'offset a cui saltare non è ancora disponibile
				labelReference.put(i, node.getArg3());
				newCode.add(node);
				i++;
			}
			else {
				//per le altre istruzioni si genera codice normalmente
				newCode.add(node);
				i++;
			}
		}
		
		//printBytecode(code);
		
		/*System.out.println("\n" + labelList.toString());
		System.out.println(labelReference.toString());*/
		
		//si impostano gli offset a cui si deve saltare
		for(int j : labelReference.keySet())
			newCode.get(j).setOffset(labelList.get(labelReference.get(j)));
		
		/*if(!code.equals(newCode)) {
			System.out.println();
			printBytecode(newCode);
		}*/
		
		printBytecode(newCode);
		
		//aggiornamento del nuovo codice con gli offset per il salto
		code = newCode;
	}
	
	/**
	 * Esecuzione del bytecode con o senza tracing dei registri e dello stack
	 */
	public void run(Boolean suppressTrace) {
		System.out.println("\n--------------------");
		System.out.println("Starting interpreter");
		
		while(true) {
			//recupero prossima istruzione da eseguire
			Node bytecode = code.get(ip);
			
			//recupero il nome dell'istruzione
			String instruction = bytecode.getInstruction();

			//variabili temporanee per l'analisi delle istruzioni
			int r1;
			int r2;
			int r3;
			int n;
			int temp;
			int offset;
			
			if(!suppressTrace)
				System.out.println("$ip = " + ip + " - " + bytecode.toString());
			
			switch(instruction) {
			
				//push $r1
				case "push":	
					
					r1 = loadFromRegister(bytecode.getArg1());
					
					sp = sp - 1;
					
					memory[sp] = r1;
					
					ip++;
					
					break;
				
				//pop
				case "pop":	
					
					sp = sp + 1;
					
					ip++;
					
					break;
					
				//top $r1
				case "top":
					
					saveToRegister(bytecode.getArg1(), memory[sp]);
					
					ip++;
					
					break;
					
				//add $r1 $r2 $r3
				case "add":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					r3 = loadFromRegister(bytecode.getArg3());
					
					temp = r2 + r3;
					
					saveToRegister(bytecode.getArg1(), temp);
					
					ip++;
					
					break;
					
				//sub $r1 $r2 $r3
				case "sub":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					r3 = loadFromRegister(bytecode.getArg3());
					
					temp = r2 - r3;
					
					saveToRegister(bytecode.getArg1(), temp);
					
					ip++;
					
					break;
					
				//mult $r1 $r2 $r3
				case "mult":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					r3 = loadFromRegister(bytecode.getArg3());
					
					temp = r2 * r3;
					
					saveToRegister(bytecode.getArg1(), temp);
					
					ip++;
					
					break;
					
				//div $r1 $r2 $r3
				case "div":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					r3 = loadFromRegister(bytecode.getArg3());
					
					temp = r2 / r3;
					
					saveToRegister(bytecode.getArg1(), temp);
					
					ip++;
					
					break;
					
				//neg $r1 $r2
				case "neg":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					temp = -r2;
					
					saveToRegister(bytecode.getArg1(), temp);
					
					ip++;
					
					break;
					
				//and $r1 $r2 $r3
				case "and":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					r3 = loadFromRegister(bytecode.getArg3());
					
					if(r2 != 0 && r3 != 0)
						temp = 1;
					else
						temp = 0;
					
					saveToRegister(bytecode.getArg1(), temp);
					
					ip++;
					
					break;
					
				//or $r1 $r2 $r3
				case "or":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					r3 = loadFromRegister(bytecode.getArg3());
					
					if(r2 != 0 || r3 != 0)
						temp = 1;
					else
						temp = 0;
					
					saveToRegister(bytecode.getArg1(), temp);
					
					ip++;
					
					break;
					
				//not $r1 $r2
				case "not":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					if(r2 != 0)
						temp = 0;
					else
						temp = 1;
					
					saveToRegister(bytecode.getArg1(), temp);
					
					ip++;
					
					break;
					
				//eq $r1 $r2 $r3
				case "eq":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					r3 = loadFromRegister(bytecode.getArg3());
					
					if(r2 == r3)
						temp = 1;
					else
						temp = 0;
					
					saveToRegister(bytecode.getArg1(), temp);
					
					ip++;
					
					break;
					
				//neq $r1 $r2 $r3
				case "neq":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					r3 = loadFromRegister(bytecode.getArg3());
					
					if(r2 != r3)
						temp = 1;
					else
						temp = 0;
					
					saveToRegister(bytecode.getArg1(), temp);
					
					ip++;
					
					break;
					
				//geq $r1 $r2 $r3
				case "geq":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					r3 = loadFromRegister(bytecode.getArg3());
					
					if(r2 >= r3)
						temp = 1;
					else
						temp = 0;
					
					saveToRegister(bytecode.getArg1(), temp);
					
					ip++;
					
					break;
					
				//leq $r1 $r2 $r3
				case "leq":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					r3 = loadFromRegister(bytecode.getArg3());
					
					if(r2 <= r3)
						temp = 1;
					else
						temp = 0;
					
					saveToRegister(bytecode.getArg1(), temp);
					
					ip++;
					
					break;
					
				//gr $r1 $r2 $r3
				case "gr":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					r3 = loadFromRegister(bytecode.getArg3());
					
					if(r2 > r3)
						temp = 1;
					else
						temp = 0;
					
					saveToRegister(bytecode.getArg1(), temp);
					
					ip++;
					
					break;
					
				//ls $r1 $r2 $r3
				case "ls":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					r3 = loadFromRegister(bytecode.getArg3());
					
					if(r2 < r3)
						temp = 1;
					else
						temp = 0;
					
					saveToRegister(bytecode.getArg1(), temp);
					
					ip++;
					
					break;
					
				//sw $r1 offset($r2)
				case "sw":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					offset = bytecode.getOffset();
					
					offset = offset + r2;
					
					r1 = loadFromRegister(bytecode.getArg1());
					
					memory[offset] = r1;
					
					ip++;
					
					break;
					
				//lw $r1 offset($r2)
				case "lw":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					offset = bytecode.getOffset();
					
					offset = offset + r2;
					
					saveToRegister(bytecode.getArg1(), memory[offset]);
					
					ip++;
					
					break;
				
				//smem $r1 offset($r2)
				case "smem":
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					offset = bytecode.getOffset();
					
					//indirizzo della cella che contiene l'indirizzo della variabile passata per riferimento
					offset = offset + r2;
					
					r1 = loadFromRegister(bytecode.getArg1());
					
					offset = memory[offset];
					
					memory[offset] = r1;
					
					ip++;
					
					break;
					
				//lmem $r1 offset($r2)
				case "lmem":
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					offset = bytecode.getOffset();
					
					//indirizzo della cella che contiene l'indirizzo della variabile passata per riferimento
					offset = offset + r2;
					
					offset = memory[offset];
					
					saveToRegister(bytecode.getArg1(), memory[offset]);
					
					ip++;
					
					break;
					
				//b label -> b offset label
				case "b":
					
					offset = bytecode.getOffset();
					
					ip = offset;
					
					break;
					
				//beq $r1 $r2 label -> beq $r1 offset $r2 label
				case "beq":
					
					r1 = loadFromRegister(bytecode.getArg1());
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					offset = bytecode.getOffset();
					
					if(r1 == r2)
						ip = offset;
					else
						ip++;
					
					break;
					
				//bleq $r1 $r2 label -> bleq $r1 offset $r2 label
				case "bleq":
					
					r1 = loadFromRegister(bytecode.getArg1());
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					offset = bytecode.getOffset();
					
					if(r1 <= r2)
						ip = offset;
					else
						ip++;
					
					break;
					
				//bgeq $r1 $r2 label -> bgeq $r1 offset $r2 label
				case "bgeq":
					
					r1 = loadFromRegister(bytecode.getArg1());
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					offset = bytecode.getOffset();
					
					if(r1 >= r2)
						ip = offset;
					else
						ip++;
					
					break;
					
				
				//addi $r1 $r2 n
				case "addi":	
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					n = Integer.parseInt(bytecode.getArg3());
					
					temp = r2 + n;
					
					saveToRegister(bytecode.getArg1(), temp);
					
					ip++;
					
					break;
					
				//li $r1 n
				case "li":
					
					n = Integer.parseInt(bytecode.getArg2());
					
					saveToRegister(bytecode.getArg1(), n);
					
					ip++;
					
					break;
					
				//move $r1 $r2
				case "move":
					
					r2 = loadFromRegister(bytecode.getArg2());
					
					saveToRegister(bytecode.getArg1(), r2);
					
					ip++;
					
					break;
					
				//jal label
				case "jal":
					
					ra = ip + 1;
					
					offset = bytecode.getOffset();
					
					ip = offset;
					
					break;
					
				//jr $r1
				case "jr":
					
					r1 = loadFromRegister(bytecode.getArg1());
					
					ip = r1;
					
					break;
					
				//print $r1
				case "print":
					
					r1 = loadFromRegister(bytecode.getArg1());
					
					System.out.println(r1);
					
					ip++;
					
					break;
					
				//halt
				case "halt":
					System.out.println("halt");
					return;
					
				default:
					throw new InterpreterException(ip, "Invalid operation");
			}
			
			if(!suppressTrace) {
				System.out.print("$a0 = " + a0 + " -- $t1 = " + t1 + " -- $al = " + al + " -- $sp = " + sp + " -- $fp = " + fp + "-- $ra = " + ra + " --- ");
				for(int k = MEMSIZE - 1;k >= sp;k--)
					System.out.print(" | " + memory[k]);
				
				System.out.println("\n");
			}
		}
	}

	/**
	 * Dato il nome del registro restituisce il valore contenuto in esso
	 * Se il nome del registro non è valido viene lanciata un'eccezione a runtime
	 */
	private int loadFromRegister(String registerName) {
		
		switch(registerName) {
			
			case "$ip":
				return ip;
			case "$sp":
				return sp;
			case "$fp":
				return fp;
			case "$ra":
				return ra;
			case "$al":
				return al;
			case "$a0":
				return a0;
			case "$t1":
				return t1;
			default:
				throw new InterpreterException(ip, "Invalid register name");
		}		
	}
	
	/**
	 * Dato il nome del registro salva il valore dato
	 * Se il nome del registro non è valido viene lanciata un'eccezione a runtime
	 */
	private void saveToRegister(String registerName, int value) {
		
		switch(registerName) {
		
			case "$ip":
				ip = value;
				break;
			case "$sp":
				sp = value;
				break;
			case "$fp":
				fp = value;
				break;
			case "$ra":
				ra = value;
				break;
			case "$al":
				al = value;
				break;
			case "$a0":
				a0 = value;
				break;
			case "$t1":
				t1 = value;
				break;
			default:
				throw new InterpreterException(ip, "Invalid register name");
		}		
	}
	
	/**
	 * Stampa il bytecode formattato con i numeri di istruzione
	 */
	private static void printBytecode(List<Node> code) {
		for(int i = 0;i < code.size();i++)
			System.out.println(i + ": " + code.get(i).toString());
	}
}
