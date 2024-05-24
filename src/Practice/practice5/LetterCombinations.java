import java.util.*;

class LetterCombinations {
	static HashMap<Character, List<Character>> map;
	public static void main(String args[]) {
		System.out.println(generateComb("27"));
	}

	public static List<String> generateComb(String num) {
		List<String> result = new ArrayList<>();
		if(num.length()==0 || num==null) {
			return result;
		}

		map = new HashMap<>();

		List<Character> values = new ArrayList<>();
		values.add('a');values.add('b');values.add('c');
		map.put('2', values);
		values = new ArrayList<>();
		values.add('d');values.add('e');values.add('f');
		map.put('3', values);
		values = new ArrayList<>();
		values.add('g');values.add('h');values.add('i');
		map.put('4', values);
		values = new ArrayList<>();
		values.add('j');values.add('k');values.add('l');
		map.put('5', values);
		values = new ArrayList<>();
		values.add('m');values.add('n');values.add('o');
		map.put('6', values);
		values = new ArrayList<>();
		values.add('p');values.add('q');values.add('r');values.add('s');
		map.put('7', values);
		values = new ArrayList<>();
		values.add('t');values.add('u');values.add('v');
		map.put('8', values);
		values = new ArrayList<>();
		values.add('w');values.add('x');values.add('y');values.add('z');
		map.put('9', values);


		helper(num, 0, "", result);
		return result;
	}

	public static void helper(String num, int index, String curr, List<String> result) {
		if(curr.length() == num.length	()) {
			result.add(curr);
			return;
		}
 		char digit = num.charAt(index);
 		for(char c: map.get(digit)) {
 			helper(num, index+1, curr+c, result);
 		}
	}
}