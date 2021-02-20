package ast;

import behavioural_analysis.BTBase;
import util_analysis.Environment;

/**
 * Represents a Simple Expression
 * Some child classes of this one will be SimpleExpSum, SimpleExpDiff, 
 * SimpleExpDiv, SimpleExpMult and SimpleExpNeg
 * @author Abel
 *
 */
public abstract class SimplePlusExp extends SimplePlusElementBase {

	/**
	 * Calculates the value of an expression
	 * @param e the environment that stores variable values
	 * @return an integer which is the value of the expression
	 * @throws IllegalAccessException 
	 */
	public abstract int getValue(Environment e);
	
	@Override
	public BTBase inferBehavior(Environment e) {
		
		return null;
	}

}
