import java.util.*;

class LongestValidParentheses {
    public static void main(String args[]) {
        String s = ")()())";
        // for(int i=1; i<1; i++) System.out.println(i);
        // System.out.println(longestValidParentheses_exponential(s));
        System.out.println(longestValidParentheses_stack(s));

    }

    public static int longestValidParentheses_stack(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c=='(') {
                maxLen = Math.max(maxLen, count);
                stack.push(i);
            } else {
                if(!stack.empty()) {
                    count+=2;
                    stack.pop();
                }
            }
        }
        return maxLen;
    }

    public static int longestValidParentheses_exponential(String s) {
        int maxLen = 0;
        for(int i=0; i<s.length(); i++) {
            for(int j=i+1; j<s.length(); j+=2) {
                System.out.println(i+":"+j);
                if(check(s, i, j)) maxLen=Math.max(s.substring(i, j+1).length(), maxLen);
            }
        }
        return maxLen;
    }
    
    public static boolean check(String s, int start, int end) {
        int count = 0;
        
        for(int i=start; i<=end; i++) {
            if(s.charAt(i)=='(') count++;
            else count--;
            
            if(count<0) return false;
        }
        return count==0;
    }
}