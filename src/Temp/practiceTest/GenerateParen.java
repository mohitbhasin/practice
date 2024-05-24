import java.util.*;

class GenerateParen {
	public static void main(String args[]) {
		System.out.println(generate(3));
	}

	public static List<String> generate(int n) {
		List<String> result = new ArrayList<>();

		helper(n*2, result, "");
		return result;
	}

	public static void helper(int n, List<String> result, String curr) {
		if(curr.length()==n) {
			if(isValid(curr)) {
				result.add(curr);	
			}
			return;
		}

		helper(n, result, curr+'(');
		helper(n, result, curr+')');
	}

	public static boolean isValid(String s) {
		int count=0;
		for(char c: s.toCharArray()) {
			if(c=='(') {
				count++;
			} 
			else {
				count--;
			}
			
			if(count<0) {
				return false;
			}
		}
		return count==0;
	}
}