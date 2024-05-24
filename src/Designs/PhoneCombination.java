import java.util.*;

class PhoneCombination {
	public static void main(String args[]) {
		Map<Character, String> lettersMap = new HashMap<>();
		lettersMap.put('2', "abc");
		lettersMap.put('3', "def");
		lettersMap.put('4', "ghi");
		lettersMap.put('5', "jkl");
		lettersMap.put('6', "mno");
		lettersMap.put('7', "pqrs");
		lettersMap.put('8', "tuv");
		lettersMap.put('9', "wxyz");
		List<String> result = new ArrayList<String>();
		combination("23", result, lettersMap, "", 0);
		System.out.println(result);
	}

	public static void combination(String digits, List<String> result, Map<Character, String> map, String curr, int index) {
		if(curr.length()==digits.length()) {
			result.add(curr);
			return;
		}
		if(index==digits.length()) {
			return;
		}
		String chars = map.get(digits.charAt(index)); 
		for(int i=0; i<chars.length(); i++) {
			combination(digits, result, map, curr+chars.charAt(i), index+1);
		}
	}
}