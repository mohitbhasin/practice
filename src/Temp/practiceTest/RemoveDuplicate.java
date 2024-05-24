import java.util.*;

class RemoveDuplicate {
	public static void main(String args[]) {
		char[] arr = {'a','z','f','e','m','z','m','a','k'};

		for(char c: remove(arr)) {
			System.out.print(c);
		}
	}

	public static char[] remove(char[] arr) {
		int prev=0;
		int curr=0;
		Set<Character> set = new HashSet<>();
		while(curr<arr.length) {
			if(!set.contains(arr[curr])) {
				arr[prev]=arr[curr];
				prev++;
			}
			set.add(arr[curr]);
			curr++;
		}
		return Arrays.copyOf(arr,prev);
	}
}