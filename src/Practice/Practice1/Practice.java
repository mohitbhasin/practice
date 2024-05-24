import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Practice {
	public static void main(String args[]) {
		String s="dvdf";
		System.out.println(lengthOfLongestSubstring(s));
		System.out.println("is mohit unique ? = "+isUnique("mohitMM"));
		System.out.println("is mohit is permutaion of hmoti ? = "+isPermutation("mohit", "hmoti"));
		System.out.println("is mohit is permutaion of hMoti ? = "+isPermutation2("mohit", "hMoti"));
		// removeDuplicateFromLinkedList();
		//sample inputs pwwkew, abccbabcdedd, " ", dvdf
		System.out.println("Length of longest substring in abccbabcdedd is = "+lengthOflongestSubStringWithoutRepeatingCharacters(" "));
	}

	public static int lengthOfLongestSubstring(String s) {
		//
		int longestSize=0;
		List<Character> temp = new ArrayList<Character>();
		for(char c:s.toCharArray()) {
			if(!temp.contains(c)) {
				temp.add(c);
			} else {
				temp.remove(0);
			}
			longestSize=Math.max(temp.size(), longestSize);
		}
		return longestSize;
	}


	//Mohit
	public static boolean isUnique(String str) {
		int[] heap = new int[128];

		for(int i=0; i<str.length(); i++) {
			int temp = (int) str.charAt(i);
			if(heap[temp]>0) {
				return false;
			} else {
				++heap[temp];
			}
		}
		return true;
	}
	// mohit hmoti
	public static boolean isPermutation(String s1, String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		return sortString(s1).equals(sortString(s2));
	}

	public static String sortString(String s) {
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		return new String(temp);
	}

	public static boolean isPermutation2(String s1, String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		int[] chars = new int[128];
		for(char c: s1.toCharArray()) {
			chars[(int) c]++;
		}

		for(char c: s2.toCharArray()) {
			chars[(int) c]--;
			if(chars[(int) c]<0) {
				return false;
			}
		}
		return true;
	}

	// public static void removeDuplicateFromLinkedList(LinkedNode l) {
		
	// 	LinkedNode curr = l;
	// 	LinkedNode next = curr.next;
	// 	Set<Integer> dataSet = new HashSet<Integer>();
	// 	dataSet.add(curr.data);
	// 	while(next!=null) {
	// 		if(dataSet.contains(next.data)) {
	// 			curr.next=next.next;
	// 			next=curr.next;
	// 		} else {
	// 			dataSet.add(curr.data);
	// 		}
	// 	}

	// 	System.out.println(ll);
	// }

	public static int lengthOflongestSubStringWithoutRepeatingCharacters(String s) {
		//abccbabcdedd
		int maxLen=0;
		Set<Character> numSet = new HashSet<Character>();
		int i=0; int j=0;
		while(j<s.length()) {
			if(!numSet.contains(s.charAt(j))) {
				numSet.add(s.charAt(j++));
				maxLen = Math.max(maxLen, numSet.size());
			} else {
				numSet.remove(i++);
			}
		}
		return maxLen;
	}
}










