import java.util.*;

class ValidParentheses {
	public static void main(String args[]) {
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
	}
	

	public static boolean isValid(String s) {
        if(s.isEmpty()) return true;
        if(s.length()%2 !=0) return false;
        
        Map<Character, Character> openKey = new HashMap<>();
        openKey.put('(', ')');
        openKey.put('[', ']');
        openKey.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            if(openKey.containsKey(curr)) {
                stack.push(curr);
            } else {
                if(stack.isEmpty() || openKey.get(stack.peek())!=curr) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}