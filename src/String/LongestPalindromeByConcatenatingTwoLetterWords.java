import java.util.*;
// Incorrect 
class LongestPalindromeByConcatenatingTwoLetterWords {
	public static void main(String args[]) {
		// String[] words = {"lc","cl","gg"};
		// String[] words = {"ab","ty","yt","lc","cl","ab"};
		// String[] words = {"cc","ll","xx"};
		String[] words = {"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"};
		int result = longestPalindrome(words);
		System.out.println(result);
	}

	public static int longestPalindrome(String[] words) {
        Set<String> set = new HashSet<>();
        int result=0;
        for(String word: words) {
            String reverse = new StringBuilder(word).reverse().toString(); 
            if(set.contains(reverse)) {
                set.remove(reverse);
                result+=4;
            } else {
                set.add(word);
            }
        }

        System.out.println(set);

        boolean duplicate = false;
        for(String word: set) {
            if(word.charAt(0)==word.charAt(1)) {
                result+=2;
                break;
            }
        }
        return result;
    }
}