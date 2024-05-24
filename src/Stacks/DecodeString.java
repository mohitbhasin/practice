import java.util.*;

class DecodeString {
	public static void main(String args[]) {
		String s = "3[a]2[bc]";
		// String s = "2[abc]3[cd]ef";
		// String s = "3[a2[c]]";


		System.out.println(decodeString(s));
	}

	//Better. maxK*N where is the repetition value. Space - O(N) 
	static int index = 0;
	public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while(index<s.length() && s.charAt(index) != ']') {
            if(Character.isLetter(s.charAt(index))) {
                sb.append(s.charAt(index++));
            } else {
                int val = 0;
                while(index < s.length() && Character.isDigit(s.charAt(index))) {
                    val*=10;
                    val+=s.charAt(index++) - '0';
                }
                index++;
                String decoded = decodeString(s);
                index++;
                while(val-->0) {
                    sb.append(decoded);
                }
            }
        }
        return sb.toString();
    }

	// Time Complexity: O(maxKˆcountK(n)) - better solution using 1.two stacks or 2. recurrsion
	public static String decodeString_Slow(String s) {
        Stack<Character> stack = new Stack<>();

        StringBuilder sb;
        for(char c: s.toCharArray()) {
        	if(c!=']') {
        		stack.push(c); //new String(c);
        	} else {
        		// decode alphabets
        		sb = new StringBuilder();
        		char curr = stack.peek();
        		while(curr>='a' && curr<='z') {
        			sb.append(stack.pop());
        			curr = stack.peek();
        		}
        		String decodedString = sb.toString();
        		// remove open bracket
        		stack.pop();
        		// generate number
        		curr = stack.peek();
        		sb = new StringBuilder();
        		while(curr>='0' && curr<='9') {
        			sb.insert(0, stack.pop());
        			if(stack.isEmpty()) {
        				break;
        			}
        			curr = stack.peek();
        		}
        		int num = Integer.valueOf(sb.toString());
        		// decode with num
        		sb = new StringBuilder();
        		while(num-->0) {
        			sb.append(decodedString);
        		}
        		// push back in stack
        		for(int i=sb.length()-1; i>=0; i--) {
        			stack.push(sb.charAt(i));
        		}
        	}
        }
        sb = new StringBuilder();
        while(!stack.isEmpty()) {
        	sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}