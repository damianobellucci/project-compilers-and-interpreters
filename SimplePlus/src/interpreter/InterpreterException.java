package interpreter;

/**
 * Eccezione runtime dell'interprete
 */
public class InterpreterException extends RuntimeException {
	private Integer ip;
	private String error;
	
	public InterpreterException(Integer ip, String error) {
		this.ip = ip;
		this.error = error;
	}

	public String toString() {
		return "Bytecode exception at ip [" + ip + "] " + error;
	}
}