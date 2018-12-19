package problems;

import java.util.HashSet;
import java.util.Set;

public class FirstOccuranceOfChar {
	public static void main(String args[]) {
		String s = "DBCABA";
		
		Set<Character> charSet = new HashSet<>();
		
		for(char c : s.toCharArray()) {
			if(!charSet.contains(c)) {
				charSet.add(c);
			} else {
				System.out.println(c);
				break;
			}
		}
		
		System.out.println("result = " + firstOccurance(s,charSet));
	}
	
	static char firstOccurance(String s, Set<Character> set) {
		if(s.length()==0) {
			System.out.println("char not found");
			return 0;
		} 
		if(!set.contains(s.charAt(0))) {
			System.out.println("recursinve call since char not in set");
			set.add(s.charAt(0));
			return firstOccurance(s.substring(1, s.length()), set);
		} else {
			System.out.println("char found");
			return s.charAt(0);
		}
	}
}
