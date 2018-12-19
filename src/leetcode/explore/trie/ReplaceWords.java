package leetcode.explore.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ReplaceWords {
	TrieReplace root;
	
	ReplaceWords() {
		this.root = new TrieReplace();
	}
	
	public void insert(String s) {
		TrieReplace curr = root;
		char c;
		for(int i=0;i<s.length();i++) {
			c = s.charAt(i);
			if(curr.children.get(c)==null) {
				curr.children.put(c, new TrieReplace());
				curr = curr.children.get(c);
			} else {
				curr = curr.children.get(c);
			}
		}
		curr.isWord=true;
	}
	
	public String findRoot(String s) {
		TrieReplace curr = root;
		
		StringBuffer br = new StringBuffer();
		char c;
		for(int i=0;i<s.length();i++) {
			c = s.charAt(i);
			if(curr.children.get(c)!=null) {
				br.append(c);
				if(curr.isWord) {
					br.toString();
				}
				
				curr=curr.children.get(c);
			} 
		}
		
		return curr.isWord == true ? br.toString() : s;
		
	}
	
	
	public static void main(String args[]) {
		List<String> dict = new ArrayList();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
		
		ReplaceWords rw = new ReplaceWords();
		
		for(String s : dict) {
			rw.insert(s);
		}
		StringBuffer br = new StringBuffer();
		for(String s: sentence.split(" ")) {
			br.append(rw.findRoot(s)).append(" ");
		}
		System.out.println(br.substring(0, br.length()-1));
	}
	
	
}



class TrieReplace {
	boolean isWord;
	Map<Character, TrieReplace> children = new HashMap<>();
}