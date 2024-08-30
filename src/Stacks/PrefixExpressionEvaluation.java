import java.util.*;

class PrefixExpressionEvaluation {
	public static void main(String args[]) {
		// String[] expression = {"/","-","15","*","/","3","2","5","5"}; //1.5;
		// String[] expression = {"+","*","2","3","-","4","5"}; //5
		String[] expression = {"-","*","5","6","/","7","2"}; //26.5
		System.out.println(evaluate(expression));
    }

    public static double evaluate(String[] elements) {
    	Stack<String> stack = new Stack<>();
    	Set<String> set = new HashSet<>();
    	set.add("/");
    	set.add("*");
    	set.add("+");
    	set.add("-");

    	for(String element: elements) {
    		// curr is operator
    		if(set.contains(element)) {
    			stack.push(element);
    		} 
    		// curr is operand
    		else {
    			// stack not empty and stack top is operator
    			if(stack.isEmpty() || set.contains(stack.peek())) {
    				stack.push(element);
    			} else {
    				while(!set.contains(stack.peek())) {
    					String a = stack.pop();
	    				String b = element;
	    				String operator = stack.pop();
	    				double result = 0;
	    				switch (operator) {
	    					case "/" : {
	    						result=Double.parseDouble(a) / Double.parseDouble(b);
	    						break;
	    					}
	    					case "*" : {
	    						result=Double.parseDouble(a) * Double.parseDouble(b);
	    						break;
	    					}
	    					case "+" : {
	    						result=Double.parseDouble(a) + (double) Double.parseDouble(b);
	    						break;
	    					}
	    					case "-" : {
	    						result=Double.parseDouble(a) - (double) Double.parseDouble(b);
	    						break;
	    					}
	    				}
	    				if(stack.isEmpty() || set.contains(stack.peek())) {
	    					stack.push(""+result);
	    					break;
	    				} else {
	    					element = ""+result;
	    				}
    				}
    			}
    		}
    	}
    	return Double.parseDouble(stack.peek());
    }
}