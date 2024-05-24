import java.util.*;

class CountOccurrence {
	public static void main(String args[]) {
		String s="asjdhaskjbjvsdlkjvhakjdhakjshb";
		// String s="aabbaacccddddaeee";
		//axva
		System.out.println(count(s, 'j'));
		System.out.println(nonRepeat(s));
		System.out.println(removeDuplicates(s));
		System.out.println(reverse(s));
		System.out.println(maxOccurrence(s));
	}

	public static int count(String s, char c) {
		int count=0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)==c) {
				count++;
			}
		}
		return count;
	}

	public static char nonRepeat(String s) {
		int set[] = new int[26];

		for(int i=0; i<s.length(); i++) {
			set[s.charAt(i) - 'a']++;
		}

		for(int i=0; i<s.length(); i++) {
			if(set[s.charAt(i) - 'a']==1) {
				return s.charAt(i);
			}
		}		
		return '\0';
	}

	public static String removeDuplicates(String s) {
		int i=0;
		int j=0;
		Set<Character> set = new HashSet<Character>();

		char[] chars = s.toCharArray();
		
		while(j<chars.length) {
			if(!set.contains(chars[j])) {
				set.add(chars[j]);
				chars[i]=chars[j];
				i++;
			}
			j++;
		}
		return new String(Arrays.copyOf(chars, i));
	}

	public static String reverse(String s) {
		char[] chars = s.toCharArray();

		for(int i=0; i<chars.length/2; i++) {
			char temp = chars[i];
			chars[i] = chars[chars.length-i-1];
			chars[chars.length-i-1]=temp;
		}
		return new String(chars);
	}

	public static char maxOccurrence(String s) {
		int[] set = new int[26];
		int max=Integer.MIN_VALUE;
		int temp;
		int resultIndex=-1;
		for(int i=0; i<s.length(); i++) {
			temp=s.charAt(i) - 'a';
			set[temp]++;
			max=Math.max(max, set[temp]);
		}
		for(int i=0; i<set.length; i++) {
			if(set[i]==max) {
				resultIndex=i;
				break;
			}
		}
		return (char) ('a'+resultIndex);

	}
}









