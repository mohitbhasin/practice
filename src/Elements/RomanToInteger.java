import java.util.*;

class RomanToInteger {
	public static void main(String args[]) {
		// System.out.println(convert("XIV"));
		System.out.println(convert("XIX"));
		System.out.println(leftToRight("XIX"));
		// System.out.println(backConvert("IC"));


	}
	// XXI
	public static int convert(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int result = map.get(s.charAt(0));

		for(int i=1; i<s.length(); i++) {
			if(map.get(s.charAt(i)) > map.get(s.charAt(i-1))) {
				int temp = map.get(s.charAt(i-1));
				result-=temp;
				result+=map.get(s.charAt(i)) - temp;
			} else {
				result+=map.get(s.charAt(i));
			}
		}

		return result;
	}

	public static int backConvert(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int result = map.get(s.charAt(s.length() - 1));

		for(int i=s.length()-2; i>=0; i--) {
			if(map.get(s.charAt(i))<map.get(s.charAt(i+1))) {
				result-=map.get(s.charAt(i));
			} else {
				result+=map.get(s.charAt(i));
			}
		}

		return result;
	}

	public static int leftToRight(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int i=0;
		int result = 0;
		while(i<s.length()) {
			if(i+1<s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
				result-=map.get(s.charAt(i));
				result+=map.get(s.charAt(i+1));
				i+=2;
			} else {
				result-=map.get(s.charAt(i));
				i++;
			}
		}
		return result;
	}
}
















