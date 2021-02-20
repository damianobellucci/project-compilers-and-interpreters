package interpreter;

/**
 * Classe che astrae un'istruzione bytecode
 */
public class Node {
		private String instr;
		private String arg1;
		private Integer offset;
		private String arg2;
		private String arg3;
		
		public Node(String instr, String arg1, Integer offset, String arg2, String arg3) {
			
			this.instr = instr;
			this.arg1 = arg1;
			this.offset = offset;
			this.arg2 = arg2;
			this.arg3 = arg3;
		}
		
		public String getInstruction() {
			
			return instr;
		}
		
		public String getArg1() {
			
			return arg1;
		}
		
		public Integer getOffset() {
			
			return offset;
		}
		
		public String getArg2() {
			
			return arg2;
		}
		
		public String getArg3() {
			
			return arg3;
		}
		
		public void setOffset(int offset) {
			
			this.offset = offset;
		}
		
		/**
		 * Se l'istruzione non ha parametri e non è halt o pop allora è un'etichetta
		 */
		public boolean isLabel() {
			
			boolean res = false;
			
			if(this.instr.equals("halt") || this.instr.equals("pop"))
				return false;
			
			if(this.arg1 == null && this.arg2 == null && this.arg3 == null)
				res = true;
			
			return res;
		}
		
		/**
		 * Controllo se l'istruzione è una di quelle per il salto
		 */
		public boolean isBranch() {
			
			return (instr.equals("beq") || instr.equals("bleq") || instr.equals("bgeq")|| instr.equals("b") || instr.equals("jal"));
		}
		
		public String toString() {
			
			String res = new String(instr);
			
			if(arg1 != null)
				res = res + " " + arg1;
			
			if(offset != null)
				res = res + " " + offset;
			
			if(arg2 != null)
				res = res + " " + arg2;
			
			if(arg3 != null)
				res = res + " " + arg3;
			
			return res;
		}
	}