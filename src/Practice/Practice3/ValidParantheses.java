import java.util.*;
class ValidParantheses {
	public static void main(String args[]) {
		// String s = "()[]{}";
		// String s = "(]";
		// String s = "([)]";
		String s = "{[]}}";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<Character>();
		for(char c: s.toCharArray()) {
			if(map.containsKey(c)) {
				stack.push(c);
			} else {
				if(c!=map.get(stack.pop())) {
					return false;
				}
			}
		}
		return true;
	}
}