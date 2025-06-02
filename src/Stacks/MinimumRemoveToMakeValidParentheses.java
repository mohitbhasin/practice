import java.util.*;

class MinimumRemoveToMakeValidParentheses {
	public static void main(String args[]) {
		List<String> list = new ArrayList<>();
		list.add(")((yz)())(");
		list.add("()((()");
		list.add("ab)ca(so)(sc(s)(");

		for(String s: list) {
			System.out.println(minRemoveToMakeValid(s));
			System.out.println(minRemoveToMakeValid_stack(s));
		}
	}

	// Better - Time Complexity: O(n) Space: O(1);
	public static String minRemoveToMakeValid(String s) {
        int balance = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)==')') {
                if(balance>0) {
                    sb.append(')');
                    balance--;   
                }
            } else if(s.charAt(i)=='(') {
                sb.append('(');
                balance++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        
        for(int i=sb.length()-1; i>=0 && balance>0; i--) {
            if(sb.charAt(i)=='(') {
                sb.deleteCharAt(i);
                balance--;
            }
        }
        return sb.toString();
    }

    // Time Complexity: O(n) Space: O(n);
    public static String minRemoveToMakeValid_stack(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int deletedCount = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c=='(') {
                sb.append(c);
                stack.push(i);
            } else if(c==')') {
                if(!stack.isEmpty()) {
                    sb.append(')');
                    stack.pop();
                } else {
                    deletedCount++;
                }
            } else {
                sb.append(c);
            }
        }
        while(!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop() - deletedCount);
        }
        return sb.toString();
    }
}