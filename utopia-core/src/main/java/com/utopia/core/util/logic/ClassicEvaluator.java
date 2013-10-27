package com.utopia.core.util.logic;

import java.math.BigDecimal;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassicEvaluator {
	private static final Logger logger=Logger.getLogger(ClassicEvaluator.class.getName());
/** Static Logger */
	
	/**
	 * Evaluate Logic. <code>
	 *	format		:= <expression> [<logic> <expression>]
	 *	expression	:= @<context>@<exLogic><value>
	 *	logic		:= <|> | <&>
	 *  exLogic		:= <=> | <!> | <^> | <<> | <>>
	 *
	 *	context		:= any global or window context
	 *	value		:= strings can be with ' or "
	 *	logic operators	:= AND or OR with the prevoius result from left to right
	 *
	 *	Example	'@AD_Table@=Test | @Language@=GERGER
	 *  </code>
	 * @param logic
	 *            logic string
	 * @return locic result
	 */
	public static boolean evaluateLogic( String logic,ParameterHandler source) {
		//	Conditional
		StringTokenizer st = new StringTokenizer(logic.trim(), "&|", true);
		int it = st.countTokens();
		if (((it / 2) - ((it + 1) / 2)) == 0) //	only uneven arguments
		{
			logger.log(Level.WARNING,"evatuateLogic - Logic does not comply with format "
					+ "'<expression> [<logic> <expression>]' => " + logic);
			return false;
		}

		boolean retValue = evaluateLogicTuple(source, st.nextToken());
		while (st.hasMoreTokens()) {
			String logOp = st.nextToken().trim();
			boolean temp = evaluateLogicTuple(source, st.nextToken());
			if (logOp.equals("&"))
				retValue = retValue & temp;
			else if (logOp.equals("|"))
				retValue = retValue | temp;
			else {
				
				return false;
			}
		} // hasMoreTokens
		return retValue;
	} //  evaluateLogic
	
	/**
	 * Evaluate
	 * 
	 * @context@=value or
	 * @context@!value or
	 * @context@^value.
	 * 
	 * <pre>
	 * 
	 * 	value: strips ' and &quot; always (no escape or mid stream)
	 *   value: can also be a context variable
	 *   
	 * </pre>
	 * 
	 * @param logic
	 *            logic touple
	 * @return true or false
	 */
	private static boolean evaluateLogicTuple(ParameterHandler source, String logic) {
		logic=logic.trim();
		
		
		StringTokenizer st = new StringTokenizer(logic.trim(), "!=^><", true);
		if (st.countTokens() != 3) {
			logger.log(Level.WARNING,"evaluateLogicTuple - Logic touple does not comply with format "
							+ "'@context@=value' or '@context@!value' => "
							+ logic);
			return false;
		}
		//	First Part
		String first = st.nextToken().trim(); //	get '@tag@'
		String firstEval = first.trim();
		if (first.indexOf('@') != -1) //	variable
		{
			first = first.replace('@', ' ').trim(); //	strip 'tag'
			Object o = source.getParameterValue(first); //	replace with
															 // it's value
			firstEval=o==null?"":o.toString();
		}
		firstEval = firstEval.replace('\'', ' ').replace('"', ' ').trim(); //	strip
																		   // '
																		   // and
																		   // "

		//	Comperator
		String operand = st.nextToken();

		//	Second Part
		String second = st.nextToken(); //	get value
		String secondEval = second.trim(); 
		if (second.indexOf('@') != -1) //	variable
		{
			second = second.replace('@', ' ').trim(); // strip tag
			Object o= source.getParameterValue(second); //	replace with it's
														   // value
			secondEval=o==null?"":o.toString();
		}
		secondEval = secondEval.replace('\'', ' ').replace('"', ' ').trim(); //	strip
																			 // '
																			 // and
																			 // "

		//	Handling of ID compare (null => 0)
		if (first.indexOf("_ID") != -1 && firstEval.length() == 0)
			firstEval = "0";
		if (second.indexOf("_ID") != -1 && secondEval.length() == 0)
			secondEval = "0";

		//	Logical Comparison
		boolean result = evaluateLogicTouple(firstEval, operand, secondEval);
		//
		
		//
		return result;
	} //	evaluateLogicTouple
	

	/**
	 * Evaluate Logic Touple
	 * 
	 * @param value1
	 *            value
	 * @param operand
	 *            operand = ~ ^ ! > <
	 * @param value2
	 * @return evaluation
	 */
	private static boolean evaluateLogicTouple(String value1, String operand,
			String value2) {
		if (value1 == null || operand == null || value2 == null)
			return false;

		BigDecimal value1bd = null;
		BigDecimal value2bd = null;
		try {
			if (!value1.startsWith("'"))
				value1bd = new BigDecimal(value1);
			if (!value2.startsWith("'"))
				value2bd = new BigDecimal(value2);
		} catch (Exception e) {
			value1bd = null;
			value2bd = null;
		}
		//
		if (operand.equals("=")) {
			if (value1bd != null && value2bd != null)
				return value1bd.compareTo(value2bd) == 0;
			
			//Sina Start
			if(value1 != null && value2 != null){
				if(value1.equalsIgnoreCase("true") || value1.equalsIgnoreCase("Y"))
					return value2.equalsIgnoreCase("true") || value2.equalsIgnoreCase("Y");
				if(value1.equalsIgnoreCase("false") || value1.equalsIgnoreCase("N"))
					return value2.equalsIgnoreCase("false") || value2.equalsIgnoreCase("N");
			}
			//Sina End
			return (value1.compareTo(value2) == 0); 
		} else if (operand.equals("<")) {
			if (value1bd != null && value2bd != null)
				return value1bd.compareTo(value2bd) < 0;
			return value1.compareTo(value2) < 0;
		} else if (operand.equals(">")) {
			if (value1bd != null && value2bd != null)
				return value1bd.compareTo(value2bd) > 0;
			return value1.compareTo(value2) > 0;
		} else //	interpreted as not
		{
			if (value1bd != null && value2bd != null)
				return value1bd.compareTo(value2bd) != 0;
			return value1.compareTo(value2) != 0;
		}
	} //	evaluateLogicTouple
	
	
	
public static boolean locicIsValid(String logic){
	return ((logic.indexOf("[") !=-1 && logic.indexOf("]") !=-1));/*|| 
	(logic.indexOf("[") !=-1 && logic.indexOf("]") ==-1)||
	 (logic.indexOf("[") ==-1 && logic.indexOf("]") !=-1);*/
}
}
