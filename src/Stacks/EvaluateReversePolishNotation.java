import java.util.*;


// Postfix Notation
class EvaluateReversePolishNotation {
	public static void main(String args[]) {
		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		System.out.println(evalRPN(tokens));
	}

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new 	Stack();
		int a;
		int b;
		for(String token: tokens) {
			System.out.println(token + " -- "+ stack);
			switch (token) {
				case "/" : {
					b=stack.pop();
					a=stack.pop();
					stack.push(a/b);
					break;
				}
				case "*" : {
					b=stack.pop();
					a=stack.pop();
					stack.push(a*b);
					break;
				}
				case "+" : {
					b=stack.pop();
					a=stack.pop();
					stack.push(a+b);
					break;
				}
				case "-": {
					b=stack.pop();
					a=stack.pop();
					stack.push(a-b);
					break;
				}
				default: {
					stack.push(Integer.valueOf(token));
				}
			}
		}
		return stack.pop();
	}
}