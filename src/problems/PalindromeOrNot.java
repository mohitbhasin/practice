package problems;

public class PalindromeOrNot {
	public static void main(String args[]) {
		String s = "mohitbhasin";
		
		System.out.println("Planidromicity for "+s +" = "+isPalindrome(s));
			
		String[] sArray = {"mohit", "kunal", "bhasin"};
	}
	
	static boolean isPalindrome(String s) {
		int i =0;
		int j =s.length()-1;
		int mid = s.length()/2;
		while(i <=mid && j>mid) {
			if(s.charAt(i++)!=s.charAt(j--)) {
				return false;
			}
		}
		return true;
	}
}
