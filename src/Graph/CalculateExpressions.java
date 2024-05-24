import java.util.*;

class CalculateExpressions {
	public static final Set<Character> set = new HashSet<>(Arrays.asList('/', '*', '+', '-'));
	public static final Stack<Integer> stack = new Stack<Integer>();
	public static void main(String args[]) {
		Expression e = new Expression('+');
		e.left = new Expression('*');
		e.right = new Expression('5');
		e.left.left = new Expression('4');
		e.left.right = new Expression('-');
		e.left.right.left = new Expression('7');
		e.left.right.right = new Expression('2');
		calculate(e);
		System.out.println("result - "+stack.pop());
	}

	public static void calculate(Expression e) {
		if(e==null) {
			return;
		}
		calculate(e.left);
		calculate(e.right);
		char element = e.val;
		if(set.contains(element)) {
			System.out.println(element);
			int b = stack.pop();
			int a = stack.pop();
			int temp = 0;
			switch(element) {
				case '/': temp = a / b; break;
				case '*': temp = a * b; break;
				case '+': temp = a + b; break;
				case '-': temp = a - b; break;
				default : ;
			}
			stack.push(temp);
		} else {
			stack.push(element - '0');
		}
		System.out.println(stack);
	}
}

class Expression {
	char val;
	Expression left;
	Expression right;
	Expression(char val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}