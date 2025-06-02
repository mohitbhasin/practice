import java.util.*;

// Also do Longest Palindromic Substring problem
class PalindromicSubstrings {
	public static void main(String aregs[]) {
		List<String> list = new ArrayList<>();
		// list.add("cat");
		// list.add("lever");
		// list.add("rotator");
		list.add("peeweep");
		for(String s: list){
			System.out.println(countPalindromicSubstrings_dp(s));
			System.out.println(countPalindromicSubstrings_expandAround(s));
		}
	}

	public static int countPalindromicSubstrings_expandAround(String s) {
		int result = 0;
		for(int i=0; i<s.length(); i++) {
			result+=expandAround(s, i, i);
			result+=expandAround(s, i, i+1);
		}
       	return result;
    }

    public static int expandAround(String s, int i, int j) {
    	int count = 0;
    	while(i>=0 && j<s.length()) {
    		if(s.charAt(i)==s.charAt(j)) {
    			count++;
    		} else {
    			break;
    		}
    		i--;
    		j++;
    	}
    	return count;
    }

	public static int countPalindromicSubstrings_dp(String s) {
		int result = s.length();
		boolean[][] dp = new boolean[s.length()][s.length()];
		// base case 1: sinle character substring in dp
		for(int i=0; i<s.length(); i++) {
		    dp[i][i]=true;
		}
		//base case 2: two characters substring in dp.
		//If characters match, increment result.
		for(int i=0; i<s.length()-1; i++) {
		    if(s.charAt(i)==s.charAt(i+1)) {
		        dp[i][i+1] = true;
		        result++;
		    }
		}
		// final case to check all substrings of length 3 and greater.
		// len goes till n (including n) because the whole string can be a palindrome.
		for(int len=3; len<=s.length(); len++) {
		    for(int i=0; i<=s.length()-len; i++) {
		        // find the last index of substring of len using j
		        int j=i+len-1;
		        if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]) {
		            dp[i][j]=true;
		            result++;
		        }
		    }
		}
		return result;
    }

    public static void print(boolean[][] dp) {
    	for(boolean[] row: dp) {
    		for(boolean val: row) {
    			if(val) System.out.print("T, ");
    			else System.out.print("F, ");
    		}
    		System.out.println();
    	}
    }
}





