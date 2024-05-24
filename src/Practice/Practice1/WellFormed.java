import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

class WellFormed {
	public static void main(String args[]) {
		System.out.println(isWellFormed("(([]){})"));
	}

	public static boolean isWellFormed(String s) {
		Set<Character> leftBrackets = new HashSet<Character>();
		leftBrackets.add('(');
		leftBrackets.add('{');
		leftBrackets.add('[');

		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(',')');
		map.put('[',']');
		map.put('{','}');

		Stack<Character> stack = new Stack<Character>();

		for(char c: s.toCharArray()) {
			if(!leftBrackets.contains(c) && stack.isEmpty()) {
				return false;
			}

			if(leftBrackets.contains(c)) {
				stack.add(c);
			} 
			else {
				if(c==map.get(stack.peek())) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.size()==0;
	}
}