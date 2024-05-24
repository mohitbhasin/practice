import java.util.*;

class BalancedBrackets {
	public static void main(String args[]) {
		System.out.println(checkBalance("{[(]}"));
	}

	public static boolean checkBalance(String s) {
		HashMap<Character, Character> map = new HashMap<>();
		map.put('}','{');
		map.put(')','(');
		map.put(']','[');
		Stack<Character> openParen = new Stack<>();

		for(char c: s.toCharArray()) {
			if(map.containsKey(c)) {
				if(openParen.isEmpty() || openParen.peek()!=map.get(c)) {
					return false;					
				}
				openParen.pop();
			} else {
				openParen.push(c);
			}
		}
		return openParen.isEmpty();
	}
}