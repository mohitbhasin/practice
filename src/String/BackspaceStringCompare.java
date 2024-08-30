import java.util.*;

class BackspaceStringCompare {
	public static void main(String args[]) {
		String s = "ab##";
		String t = "c#d#";
		System.out.println(backspaceCompare(s, t));
		System.out.println(backSpaceCompare_stack(s, t));
	}

	public static boolean backspaceCompare(String s, String t) {
        return formString(s).equals(formString(t));
    }

    public static String formString(String s) {
        int bkcount = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--) {
            char curr = s.charAt(i);
            if(curr=='#') {
                bkcount++;
            } else {
                if(bkcount<=0) {
                    sb.insert(0, curr);
                } else {
                    bkcount--;
                }
            }
        }
        return sb.toString();
    }

    // Previous approach preferred.
    public static boolean backSpaceCompare_stack(String S, String T) {
		return removeBacksapce(S).equals(removeBacksapce(T));
	}

    public static String removeBacksapce(String S) {
		Stack<Character> stack = new Stack<>();
		for(char c: S.toCharArray()) {
			if(c!='#') {
				stack.push(c);
			} else if(!stack.empty()) {
				stack.pop();
			}
		}
		return stack.toString();
	}
}