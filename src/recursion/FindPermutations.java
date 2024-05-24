import java.util.*;

class FindPermutations {
	static ArrayList<String> output;
	public static void main(String args[]) {
		// System.out.println(permutaion("abc"));
		char[] str = {'a','b','c'};
		output = new ArrayList<>();
		getPermu(0, str.length, str);
		System.out.println(output);
	}


//wrong calculations
	public static List<String> permutaion(String s) {
		List<String> result = new ArrayList<>();
		helper(s, result, "", 0);
		return result;
	}

//wrong calculations
	public static void helper(String s, List<String> result, String curr, int index) {
		Set<String> permutations = new HashSet<>();
		if(curr.length()==s.length()) {
			result.add(curr);
			return;
		}

		for(int i=index; i<s.length(); i++) {
			String str = curr+s.charAt(i);
			result.add(str);
			helper(s, result, str, index+1);
			result.remove(str);

		}
	}

	public static void getPermu(int first, int n, char[] str) {
		System.out.println(output);
		if(first==n) {
			output.add(new String(str));
		}

		for(int i=first; i<str.length; i++) {
			swap(str, first, i);
			getPermu(first+1, n, str);
			swap(str, first, i);
		}
	}

	private static void swap(char[] str, int i, int j) {
		char c = str[i];
		str[i] = str[j];
		str[j] = c;
	}
}