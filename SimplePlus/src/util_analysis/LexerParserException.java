package util_analysis;

/**
 * Eccezione durante l'analisi lessicale o sintattica
 */
public class LexerParserException extends RuntimeException {
	private String error;
	
	public LexerParserException(String error) {
		this.error = error;
	}

	public String toString() {
		return error;
	}
}