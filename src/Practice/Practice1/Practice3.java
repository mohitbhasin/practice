import java.util.Arrays;

class Practice3 {
	public static void main(String args[]) {
		int[] result = addTwoNums(new int[]{2,3,4,5}, new int[]{3,2});
		for(int n: result) {
			System.out.print(n+"\t");
		}
		System.out.println();
		System.out.println("using better approach = ");
		int[] result2 = addTwoNums2(new int[]{2,3,4,5}, new int[]{3,2});
		for(int n: result2) {
			System.out.print(n+"\t");
		}
		System.out.println();
		System.out.println("isUnique = "+isUnique("ashjdgew"));
		System.out.println("isUnique2 = "+isUnique2("ashjdgew"));
	}

	//2345
	//32
	public static int[] addTwoNums2(int[] a, int[] b) {
		int index = 0;
		int[] result = new int[Math.max(a.length, b.length)+1];
		int carry=0;
		while(index<result.length) {
			carry = (index>=a.length ? 0 : a[index]) + (index>=b.length ? 0 : b[index]) + carry;
			result[index++] = carry%10;
			carry=carry/10;
		}
		return result;
	}


	public static int[] addTwoNums(int[] a, int b[]) {
		int len = Math.max(a.length, b.length) + 1;
		int[] result = new int[len];
		int carry=0;
		int index=0;
		while(index<a.length || index<b.length) {
			if(index<a.length && index<b.length) {
				carry = a[index]+b[index] + carry;
				result[index] = carry%10;
				carry=carry/10;
			} else if(index>=a.length) {
				carry = b[index] + carry;
				result[index] = carry%10;
				carry=carry/10;
			} else if(index>=b.length) {
				carry = a[index] + carry;
				result[index] = carry%10;
				carry=carry/10;
			}
			index++;
		}

		result[index] = carry;
		return result;
	}

	//abcdef = true
	//abcddef = false
	// using tochararray and arrays.sort
	public static boolean isUnique(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		for(int i=1; i<chars.length; i++) {
			if(chars[i-1]==chars[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isUnique2(String s) {
		boolean[] char_set = new boolean[128];
		for(int i=0; i<s.length(); i++) {
			if(char_set[s.charAt(i)]) {
				return false;
			}
			char_set[s.charAt(i)]=true;
		}
		return true;
	}
}







