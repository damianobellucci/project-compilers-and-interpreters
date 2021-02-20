package util_analysis;

public class LabelGenerator {
	private static int counterLabels = 0;
	private static int counterFunctions = 0;
	
	public static String newLabel() {
		return new String("label" + counterLabels++);
	}
	
	public static String newFunction() {
		return new String("function" + counterFunctions++);
	}
}
