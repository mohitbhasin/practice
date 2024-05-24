import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class LetterCombinationOfPhoneNum {
	public static void main(String args[]) {
		Map<Character, String> lettersMap = new HashMap<Character, String>();
		List<String> result = new ArrayList<String>();

		lettersMap.put('2', "abc");
		lettersMap.put('3', "def");
		lettersMap.put('4', "ghi");
		lettersMap.put('5', "jkl");
		lettersMap.put('6', "mno");
		lettersMap.put('7', "pqrs");
		lettersMap.put('8', "tuv");
		lettersMap.put('9', "wxyz");

		combination(result, lettersMap, "239", "", 0);

		System.out.println(result);

	}

	public static void combination(List<String> result, Map<Character, String> lettersMap, String nums, String curr, int count) {
		if(curr.length()==nums.length()) {
			result.add(curr);
			return;
		}

		char num = nums.charAt(count);
		String letters = lettersMap.get(num);
		for(char c: letters.toCharArray()) {
			combination(result, lettersMap, nums, curr+c, count+1);
		}
	}
}