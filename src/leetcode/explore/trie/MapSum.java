package leetcode.explore.trie;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
	Trie2 root; 
	public MapSum() {
		root = new Trie2();
	}
	
	public static void main(String args[]) {
		MapSum mapSum = new MapSum();
		mapSum.insert("aa",3);
		mapSum.insert("ab",2);
		System.out.println(mapSum.summing("a"));
	}
	    
	public void insert(String key, int val) {
		if(key==null) {
			return;
		}
	    Trie2 curr = root;
	    for(int i=0;i<key.length();i++) {
	    	char c = key.charAt(i);
		    if(curr.children.get(c)==null) {
		    	curr.children.put(c, new Trie2());
		    	curr=curr.children.get(c);
		    } else {
		    	curr=curr.children.get(c);
		    }
	    }
	    curr.value=val;
	    System.out.println("Inserted key - "+key);
	}
	
	public int summing(String prefix) {
		if(prefix.length()<1) {
			return 0;
		}
		Trie2 curr = root;
		int sum=0;
		for(int i=0;i<prefix.length();i++) {
			if(curr.children.get(prefix.charAt(i))!=null) {
				curr=curr.children.get(prefix.charAt(i));	
			} else{
				return 0;
			}
		}
		return computeSum(curr, sum);
	}
	
	public static int computeSum(Trie2 keyChildren, int sum) {
		if(keyChildren==null) {
			return 0;
		} else {
			int tempSum=0;
			for(char c: keyChildren.children.keySet()) {
				System.out.println("char is - "+c); 
				tempSum+=computeSum(keyChildren.children.get(c),sum);
			}
			sum=sum+keyChildren.value+tempSum;
			System.out.println("child key value - "+keyChildren.value); 
		}
		
		return sum;
	}
}

class Trie2 {
	int value;
	Map<Character, Trie2> children = new HashMap<>() ;
}
