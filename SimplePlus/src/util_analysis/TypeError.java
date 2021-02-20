package util_analysis;

public class TypeError extends Throwable{
	
	String errorDescription;
	
	//it should be good to have also 
	//int errorLine;
	//int errorColumn;
	

	
	public TypeError(String errorDescription){
		this.errorDescription = errorDescription;
	}
	
	@Override
	public String toString() {
		return errorDescription;
	}
}
