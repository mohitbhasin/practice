import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class RemoveDuplicate {
	public static void main(String args[]) {

		char[] chars = new char[] {'f', 'c', 'b', 'a', 'b', 'f', 'd'};

		for(char c: removeDup(chars)) {
			System.out.print(c + " ");
		}
		System.out.println();
		for(char c: removeDupUnsoeted(chars)) {
			System.out.print(c + " ");
		}		
	}

	public static char[] removeDup(char[] chars) {
		Arrays.sort(chars);
		int pre=0;
		int curr=1;

		while(curr<chars.length) {
			if(chars[pre]==chars[curr]) {
				curr++;
			}
			else {
				chars[++pre]=chars[curr++];
			}
		}

		return Arrays.copyOf(chars, pre+1);
	}

	public static char[] removeDupUnsoeted(char[] chars) {
		int pre=0;
		int curr=0;
		Set<Character> charSet = new HashSet<Character>();
		while(curr<chars.length) {
			if(!charSet.contains(chars[curr])) {
				charSet.add(chars[curr]);
				chars[pre++]=chars[curr++];
			} else {
				curr++;
			}
		}
		return Arrays.copyOf(chars, pre);
	}
}