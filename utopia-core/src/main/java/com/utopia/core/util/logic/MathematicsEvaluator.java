package com.utopia.core.util.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathematicsEvaluator {



    public static int getValueOfExpresion(String definition){
    	return (int) new MathematicsEvaluator(definition).value(0);
    }
    public static BigDecimal getValueOfExpresionAsBigDecimal(String definition){
    	return new BigDecimal(new MathematicsEvaluator(definition).value(0));
    }
   //----------------- public interface ---------------------------------------

   public MathematicsEvaluator(String definition) {
         // Construct an expression, given its definition as a string.
         // This will throw an IllegalArgumentException if the string
         // does not contain a legal expression.
      parse(definition);
   }

   public double value(double x) {
         // Return the value of this expression, when the variable x
         // has the specified value.  If the expression is undefined
         // for the specified value of x, then Double.NaN is returned.
      return eval(x);
   }

   public String getDefinition() {
         // Return the original definition string of this expression.  This
         // is the same string that was provided in the constructor.
      return definition;
   }

   //------------------- private implementation details ----------------------------------


   private String definition;  // The original definition of the expression,
                               // as passed to the constructor.

   private byte[] code;        // A translated version of the expression, containing
                               //   stack operations that compute the value of the expression.

   private double[] stack;     // A stack to be used during the evaluation of the expression.

   private double[] constants; // An array containing all the constants found in the expression.


   private static final byte  // values for code array; values >= 0 are indices into constants array
       PLUS = -1,   MINUS = -2,   TIMES = -3,   DIVIDE = -4,  POWER = -5,
       SIN = -6,    COS = -7,     TAN = -8,     COT = -9,     SEC = -10,
       CSC = -11,   ARCSIN = -12, ARCCOS = -13, ARCTAN = -14, EXP = -15,
       LN = -16,    LOG10 = -17,  LOG2 = -18,   ABS = -19,   SQRT = -20,
       UNARYMINUS = -21, VARIABLE = -22;


   private static String[] functionNames =  // names of standard functions, used during parsing
       { "sin", "cos", "tan", "cot", "sec",
         "csc", "arcsin", "arccos", "arctan", "exp",
         "ln", "log10", "log2", "abs", "sqrt" };
   public static List<String> getSupportedFunctions(){
	   List<String> list = new ArrayList<String>();
	   Collections.addAll(list, functionNames);
	   return list;
   }

   private double eval(double variable) { // evaluate this expression for this value of the variable
      try {
         int top = 0;
         for (int i = 0; i < codeSize; i++) {
            if (code[i] >= 0)
               stack[top++] = constants[code[i]];
            else if (code[i] >= POWER) {
               double y = stack[--top];
               double x = stack[--top];
               double ans = Double.NaN;
               switch (code[i]) {
                  case PLUS:    ans = x + y;  break;
                  case MINUS:   ans = x - y;  break;
                  case TIMES:   ans = x * y;  break;
                  case DIVIDE:  ans = x / y;  break;
                  case POWER:   ans = Math.pow(x,y);  break;
               }
               if (Double.isNaN(ans))
                  return ans;
               stack[top++] = ans;
            }
            else if (code[i] == VARIABLE) {
               stack[top++] = variable;
            }
            else {
                double x = stack[--top];
                double ans = Double.NaN;
                switch (code[i]) {
                   case SIN: ans = Math.sin(x);  break;
                   case COS: ans = Math.cos(x);  break;
                   case TAN: ans = Math.tan(x);  break;
                   case COT: ans = Math.cos(x)/Math.sin(x);  break;
                   case SEC: ans = 1.0/Math.cos(x);  break;
                   case CSC: ans = 1.0/Math.sin(x);  break;
                   case ARCSIN: if (Math.abs(x) <= 1.0) ans = Math.asin(x);  break;
                   case ARCCOS: if (Math.abs(x) <= 1.0) ans = Math.acos(x);  break;
                   case ARCTAN: ans = Math.atan(x);  break;
                   case EXP: ans = Math.exp(x);  break;
                   case LN: if (x > 0.0) ans = Math.log(x);  break;
                   case LOG2: if (x > 0.0) ans = Math.log(x)/Math.log(2);  break;
                   case LOG10: if (x > 0.0) ans = Math.log(x)/Math.log(10);  break;
                   case ABS: ans = Math.abs(x);  break;
                   case SQRT: if (x >= 0.0) ans = Math.sqrt(x);  break;
                   case UNARYMINUS: ans = -x; break;
                }
                if (Double.isNaN(ans))
                   return ans;
                stack[top++] = ans;

            }
         }
      }
      catch (Exception e) {
         return Double.NaN;
      }
      if (Double.isInfinite(stack[0]))
         return Double.NaN;
      else
         return stack[0];
   }


   private int pos = 0, constantCt = 0, codeSize = 0;  // data for use during parsing

   private void error(String message) {  // called when an error occurs during parsing
      throw new IllegalArgumentException("Parse error:  " + message + "  (Position in data = " + pos + ".)");
   }

   private int computeStackUsage() {  // call after code[] is computed
      int s = 0;   // stack size after each operation
      int max = 0; // maximum stack size seen
      for (int i = 0; i < codeSize; i++) {
         if (code[i] >= 0 || code[i] == VARIABLE) {
            s++;
            if (s > max)
               max = s;
         }
         else if (code[i] >= POWER)
            s--;
      }
      return max;
   }

   private void parse(String definition) {  // Parse the definition and produce all
                                            // the data that represents the expression
                                            // internally;  can throw IllegalArgumentException
      if (definition == null || definition.trim().equals(""))
         error("No data provided to Expr constructor");
      this.definition = definition;
      code = new byte[definition.length()];
      constants = new double[definition.length()];
      parseExpression();
      skip();
      if (next() != 0)
         error("Extra data found after the end of the expression.");
      int stackSize = computeStackUsage();
      stack = new double[stackSize];
      byte[] c = new byte[codeSize];
      System.arraycopy(code,0,c,0,codeSize);
      code = c;
      double[] A = new double[constantCt];
      System.arraycopy(constants,0,A,0,constantCt);
      constants = A;
   }

   private char next() {  // return next char in data or 0 if data is all used up
      if (pos >= definition.length())
          return 0;
      else
         return definition.charAt(pos);
   }

   private void skip() {  // skip over white space in data
      while(Character.isWhitespace(next()))
         pos++;
   }

        // remaining routines do a standard recursive parse of the expression

   private void parseExpression() {
      boolean neg = false;
      skip();
      if (next() == '+' || next() == '-') {
         neg = (next() == '-');
         pos++;
         skip();
      }
      parseTerm();
      if (neg)
         code[codeSize++] = UNARYMINUS;
      skip();
      while (next() == '+' || next() == '-') {
         char op = next();
         pos++;
         parseTerm();
         code[codeSize++] = (op == '+')? PLUS : MINUS;
         skip();
      }
   }

   private void parseTerm() {
      parseFactor();
      skip();
      while (next() == '*' || next() == '/') {
         char op = next();
         pos++;
         parseFactor();
         code[codeSize++] = (op == '*')? TIMES : DIVIDE;
         skip();
      }
   }

   private void parseFactor() {
      parsePrimary();
      skip();
      while (next() == '^') {
         pos++;
         parsePrimary();
         code[codeSize++] = POWER;
         skip();
      }
   }

   private void parsePrimary() {
      skip();
      char ch = next();
      if (ch == 'x' || ch == 'X') {
         pos++;
         code[codeSize++] = VARIABLE;
      }
      else if (Character.isLetter(ch))
         parseWord();
      else if (Character.isDigit(ch) || ch == '.')
         parseNumber();
      else if (ch == '(') {
         pos++;
         parseExpression();
         skip();
         if (next() != ')')
            error("Exprected a right parenthesis.");
         pos++;
      }
      else if (ch == ')')
         error("Unmatched right parenthesis.");
      else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')
         error("Operator '" + ch + "' found in an unexpected position.");
      else if (ch == 0)
         error("Unexpected end of data in the middle of an expression.");
      else
         error("Illegal character '" + ch + "' found in data.");
   }

    private void parseWord() {
       String w = "";
       while (Character.isLetterOrDigit(next())) {
          w += next();
          pos++;
       }
       w = w.toLowerCase();
       for (int i = 0; i < functionNames.length; i++) {
          if (w.equals(functionNames[i])) {
             skip();
             if (next() != '(')
                error("Function name '" + w + "' must be followed by its parameter in parentheses.");
             pos++;
             parseExpression();
             skip();
             if (next() != ')')
                error("Missing right parenthesis after parameter of function '" + w + "'.");
             pos++;
             code[codeSize++] = (byte)(SIN - i);
             return;
          }
       }
       error("Unknown word '" + w + "' found in data.");
    }

    private void parseNumber() {
       String w = "";
       while (Character.isDigit(next())) {
          w += next();
          pos++;
       }
       if (next() == '.') {
          w += next();
          pos++;
          while (Character.isDigit(next())) {
             w += next();
             pos++;
          }
       }
       if (w.equals("."))
          error("Illegal number found, consisting of decimal point only.");
       if (next() == 'E' || next() == 'e') {
          w += next();
          pos++;
          if (next() == '+' || next() == '-') {
             w += next();
             pos++;
          }
          if (! Character.isDigit(next()))
             error("Illegal number found, with no digits in its exponent.");
          while (Character.isDigit(next())) {
             w += next();
             pos++;
          }
       }
       double d = Double.NaN;
       try {
          d = Double.valueOf(w).doubleValue();
       }
       catch (Exception e) {
       }
       if (Double.isNaN(d))
          error("Illegal number '" + w + "' found in data.");
       code[codeSize++] = (byte)constantCt;
       constants[constantCt++] = d;
    }


} // end class Expr
