import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Practice2 {
	public static void main(String args[]) {
		// System.out.println("Hel");
		fibonacciPrint(8);
		System.out.println("------------");		
		System.out.println(fibonacciRecursion(8)+"\t"+fibonacciRecursion(7)+"\t"+fibonacciRecursion(6)+"\t"+fibonacciRecursion(5)+"\t"+fibonacciRecursion(4)+"\t"+fibonacciRecursion(3)+"\t"+fibonacciRecursion(2)+"\t"+fibonacciRecursion(1)+"\t"+fibonacciRecursion(0));
		// System.out.println(fibonacciRecursion(8));
		System.out.println("------------");		
		System.out.println(fibonacciRecursionMemo(8, new HashMap<Integer, Integer>()));
		System.out.println("------------");
		System.out.println(checkPrime(8));
		System.out.println("------------");
		System.out.println(palindromeOrNot("daadd"));
		System.out.println("------------");
		System.out.println(factorial(12));
		System.out.println("------------");
		System.out.println("Reverse num is = " + reverseNumber(-123568));
		System.out.println("------------");
		System.out.println("Reverse String = " + reverseString("MohitBhasin"));
		System.out.println("------------");
		System.out.println("Length of longest sub string is = " + lengthOfLongestSubString("dvdf"));
	}
	public static void fibonacciPrint(int num) {
		int temp1=0;
		int temp2=1;
		for(int i=0; i<=num; i++) {
			int res=temp1+temp2;
			System.out.print(res+"\t");
			temp1=temp2;
			temp2=res;
		}
	}

	public static int fibonacciRecursion(int num) {
		if(num==0 || num==1) {
			return 1;
		}
		// System.out.println(num);
		return (fibonacciRecursion(num-2) + fibonacciRecursion(num-1));
	}

	public static int fibonacciRecursionMemo(int num, HashMap<Integer, Integer> map) {
		if(num==0 || num==1) {
			return 1;
		}
		if(map.containsKey(num)) {
			return map.get(num);
		}
		// System.out.println(num);
		int temp = fibonacciRecursionMemo(num-2, map) + fibonacciRecursionMemo(num-1, map);
		map.put(num,temp);

		return temp;
	}

	public static boolean checkPrime(int num) {
		System.out.print("checkPrime for "+ num+" = ");
		for(int i=2; i<=num/2; i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}

	public static boolean palindromeOrNot(String str) {
		int i=0;
		int j=str.length()-1;

		while(i<j) {
			if(str.charAt(i)!=str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static int factorial(int num) {
		if(num<2) {
			return 1;
		}
		return num*factorial(num-1);
	}

	public static int reverseNumber(int num) {
		int sign = num<0 ? -1 : 1;
		num = num*sign;
		int result=0;
		while(num>0) {
			result = result*10 + (num%10);
			num=num/10;
		}
		return result*sign;
	}

	public static String reverseString(String str) {
		StringBuilder strB = new StringBuilder();
		for(int i=str.length()-1; i>=0; i--) {
			strB.append(str.charAt(i));
		}
		return strB.toString();
	}

	//abcabcb
	public static int lengthOfLongestSubString(String s) {
		int i=0;
		int j=0;
		Set<Character> set = new HashSet<Character>();
		int maxLen=0;
		while(j<s.length()) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				maxLen = Math.max(set.size(), maxLen);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return maxLen;
	}

}