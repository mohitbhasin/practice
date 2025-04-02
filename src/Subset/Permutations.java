import java.util.*;

class Permutations {
	public static void main(String args[]) {
		List<String> list = new ArrayList<>();
		list.add("abcd");

		for(String word: list) {
			System.out.println(permuteWord(word));
		}

	}

	public static ArrayList<String> permuteWord(String word) {
        ArrayList<String> result = new ArrayList<>();
        helper(new StringBuilder(word), 0, result);
        return result;
    }

	public static void helper(StringBuilder sb, int index, List<String> result) {
        if(index==sb.length()) {
        	result.add(sb.toString());
            return;
        }

        for(int i=index; i<sb.length(); i++) {
        	swap(sb, index, i);
            helper(sb, index+1, result);
            swap(sb, i, index);
        }
    }

    public static void swap(StringBuilder sb, int i, int j) {
    	char temp = sb.charAt(i);
    	sb.setCharAt(i, sb.charAt(j));
    	sb.setCharAt(j, temp);
    }
}