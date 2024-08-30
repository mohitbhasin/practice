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
    	if(elements.length)
    	Stack<Double> stack = new Stack<>();
    	double a;
    	double b;
    	for(int i=elements.length-1; i>=0; i--) {
    		String element = elements[i];
    		switch (element) {
    			case "/": {
    				a=stack.pop();
    				b=stack.pop();
    				stack.push(a/b);
    				break;
    			}
	    		case "*": {
    				a=stack.pop();
    				b=stack.pop();
    				stack.push(a*b);
    				break;
    			}
	    		case "+": {
	    				a=stack.pop();
	    				b=stack.pop();
	    				stack.push(a+b);
	    				break;
    			}
    			case "-": {
	    				a=stack.pop();
	    				b=stack.pop();
	    				stack.push(a-b);
	    				break;
    			}
	    		default: {
	    			stack.push(Double.valueOf(element));
	    		}
	    	}
    	}
    	return stack.peek();
    }
}