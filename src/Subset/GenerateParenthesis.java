import java.util.*;

class GenerateParenthesis {
	public static void main(String args[]) {
		int[] nums = {3, 2};

		for(int num: nums) {
			System.out.println(generateCombinationsOptimized(num));
			System.out.println(generate(num));
			System.out.println(generateCombinations(num));
		}
	}

	public static ArrayList<String> generateCombinationsOptimized(int n) {
		ArrayList<String> result = new ArrayList<>();
		helper("", n, n, result);
		return result;
	}

	public static void helper(String curr, int open, int close, List<String> result) {
		if(open==0 && close==0) {
			result.add(curr);
			return;
		}
		if(open>0) {
			helper(curr+'(', open-1, close, result);
		}
		if(close>open) {
			helper(curr+')', open, close-1, result);
		}

	}

	//During backtracking character swaps not required when using string
	public static List<String> generate(int n) {
		List<String> result = new ArrayList<>();

		helper2("", 0, n*2, result);
		return result;
	}

	public static void helper2(String curr, int bal, int len, List<String> result) {
	    if(bal<0) return;
	    if(curr.length()==len) {
	        if(bal>0) return;
	        result.add(curr);
	        return;
	    }
	    helper2(curr+'(', bal+1, len, result);
	    helper2(curr+')', bal-1, len, result);
	}

	//During backtracking character swaps required when using stringbuilder
	public static ArrayList<String> generateCombinations(int n) {
        ArrayList<String> result = new ArrayList<>();
        helper3(new StringBuilder(), 0, n*2, result);
        return result;
	}
	
	public static void helper3(StringBuilder sb, int bal, int len, List<String> result) {
	    if(bal<0) return;
	    if(sb.length()==len) {
	        if(bal>0) return;
	        result.add(sb.toString());
	        return;
	    }
	    helper3(sb.append('('), bal+1, len, result);
	    sb.deleteCharAt(sb.length()-1);
	    helper3(sb.append(')'), bal-1, len, result);
	    sb.deleteCharAt(sb.length()-1);
	}
}