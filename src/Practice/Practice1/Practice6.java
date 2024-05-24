import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

class Practice6 {
	public static void main(String args[]) {
		System.out.println(letterCombination("23"));
	}


	 public List<String> letterCombinations(String digits) {
        
    }

	public static ArrayList<String> letterCombination(String input) {
		HashMap<Integer, String> numMap = new HashMap<>();
		numMap.put(2, "abc");
		numMap.put(3, "def");
		numMap.put(4, "ghi");
		numMap.put(5, "jkl");
		numMap.put(6, "mno");
		numMap.put(7, "pqrs");
		numMap.put(8, "tuv");
		numMap.put(9, "wxyz");

		ArrayList<String> result = new ArrayList<>();
		for(char c: input.toCharArray()) {
			result.add(recur(c, numMap.get(c), ""));
		}
		return result;
	}

	public static String recur(char c, String s, String finalString) {
		if (s==null) return finalString;
		finalString+=(c);
		finalString+=s.charAt(0);
		return recur(c,s.substring(1), finalString);
	}
}