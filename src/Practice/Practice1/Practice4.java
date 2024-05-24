import java.lang.StringBuffer;
import java.util.Stack;

public class Practice4 {
	public static void main(String args[]) {
		// String S = "ab#c";
  //     	String T = "ad#c";
  //     	String S = "ab##";
		// String T = "c#d#";

       String S = "#c";
       String T = "#######c";
		System.out.println(backSpaceCompare(S,T));

	}

	//        String S = "ab#c";
//        String T = "ad#c";

	public static boolean backSpaceCompare(String S, String T) {
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
		System.out.println(stack.toString());
		return stack.toString();
	}
}