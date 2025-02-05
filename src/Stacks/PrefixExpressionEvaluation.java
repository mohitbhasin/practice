import java.util.*;

class PrefixExpressionEvaluation {
	public static void main(String args[]) {
		List<String[]> list = new ArrayList<>();
		list.add(new String[] {"/","-","15","*","/","3","2","5","5"}); //1.5;
		list.add(new String[] {"+","*","2","3","-","4","5"}); //5
		list.add(new String[] {"-","*","5","6","/","7","2"}); //26.5
		list.add(new String[] {"+","-","*","3","4","5","/","6","2"}); //10
		list.add(new String[] {"-","*","+","2","3","4","/","5","2",}); //17.5
		
		for(String[] expression: list) {
			System.out.println(evaluate(expression));
		}
    }

    public static double evaluate(String[] elements) {
    	Stack<Double> stack = new Stack<>();
    	for(int i=elements.length-1; i>=0; i--) {
    		String element = elements[i];
    		if(element.equals("/") || element.equals("*") || element.equals("+") || element.equals("-")) {
    			stack.push(helper(stack.pop(), stack.pop(), element));
    		} else {
    			stack.push(Double.valueOf(element));
    		}
    	}
    	return stack.pop();
    }
    
    public static double helper(double a, double b, String operator) {
    	switch (operator) {
			case "/": {
				return a/b;
			}
    		case "*": {
				return a*b;
			}
    		case "+": {
    			return a+b;
			}
			case "-": {
    			return a-b;
			}
			default: {
				throw new IllegalArgumentException();
			}
    	}
    }
}