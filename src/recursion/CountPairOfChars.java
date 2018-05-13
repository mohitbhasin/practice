package recursion;

//We'll say that a "pair" in a string is two instances of a char separated by a char. 
//So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for A and 1 for x. 
//Recursively compute the number of pairs in the given string.

//countPairs("axa") → 1
//countPairs("axax") → 2
//countPairs("axbx") → 1


public class CountPairOfChars {
	public static void main(String args[]) {
		String str = "AxAxAxbxabbb";
		System.out.println("Total Pair in "+str+" ==> "+ countPairs(str));
	}
	
	//pair can only exists alternatively
	//if size less than 3 then 0 pairs coz AA does not satisfy.
	//compare first alternates (0 and 2) if matches add 1 and redo for substring removing first element 
	static int countPairs(String str) {
		if(str.length()<3) {
			return 0;
		} 
		if(str.charAt(0) == str.charAt(2)) {
			return 1 + countPairs(str.substring(1));
		}
		else {
			return countPairs(str.substring(1));
		}
	}
}
