package interpreter;

/**
 * Eccezione durante il parsing del bytecode
 */
public class BytecodeException extends RuntimeException {
	private String line;
	private String error;
	
	public BytecodeException(String line, String error) {
		this.line = line;
		this.error = error;
	}

	public String toString() {
		return "Bytecode exception at line " + line + " " + error;
	}
}