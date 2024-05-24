import java.util.HashMap;
import java.util.Arrays;
class Practice5 {
	public static void main(String args[]){
		// System.out.println(fact(5));
		// System.out.println(factRecur(5));
		// AddSearchWord a = new AddSearchWord();
		// a.addWord("mohit");
		// a.addWord("mother");
		// a.addWord("hello");
		// System.out.println(a.searchWord("mohit"));
		// System.out.println(a.searchWord("m"));
		// System.out.println(a.searchWord("mother"));
		// int[] num1 = {2,4,5};
		// int[] num2 = {5,6,4};
		// for(int n: addTwoNums(num1, num2)) {
		// 	System.out.print(n+"\t");
		// }
		int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
	}

	public static int fact(int num) {
		if(num<1) return -1;
		if(num==1) return 1;
		int result=1;
		while(num>1) {
			result*=num--;
		}
		return result;
	}

	public static int factRecur(int num) {
		if(num<2) return num;
		return num * factRecur(num - 1);
	}

	public static int[] addTwoNums(int[] num1, int[] num2) {
		if(num1==null || num2==null) return null;
		int[] result= new int[Math.max(num1.length, num2.length)+1];
		int index=0; int sum=0;
		while(index<num1.length || index<num2.length) {
			if(index>=num1.length) sum=sum+num2[index];
			if(index>=num2.length) sum=sum+num1[index];
			else sum=sum+num1[index]+num2[index];
			result[index++]=sum%10;
			sum/=10;
		}
		if(sum==0) return Arrays.copyOf(result, result.length-1);
		result[index]=sum;
		return result;
	}

	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		for(int i=1; i<prices.length; i++) {
			int diff=prices[i]-prices[i-1];
			if(diff>0) maxProfit+=diff;
		}
		return maxProfit;

	}
}

class Trie {
	HashMap<Character, Trie> childMap = new HashMap<>();
	boolean isWord;
}

class AddSearchWord {
	Trie trie = new Trie();

	public void addWord(String word) {
		Trie t = trie;
		for(char c: word.toCharArray()) {
			if(!t.childMap.containsKey(c)) t.childMap.put(c, new Trie());
			t=t.childMap.get(c);
		}
		t.isWord=true;
	}

	public boolean searchWord(String word) {
		Trie t = trie;
		for(char c: word.toCharArray()) {
			if(!t.childMap.containsKey(c)) return false;
			t=t.childMap.get(c);
		}
		return t.isWord;
	}
}
