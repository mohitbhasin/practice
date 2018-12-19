package leetcode.explore.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	TrieNode root;
    public Trie() {
    	this.root = new TrieNode();
    }
    
    public static void main(String args[]) {
    	Trie t = new Trie();
    	t.insert("mohit");
    	t.insert("bhasin");
    	System.out.println(t.search("mohite"));
    	System.out.println(t.startsWith("moht"));
    	
//    	Trie t = new Trie();
    }
    
    public void insert(String s) {
    	TrieNode curr = root;
    	
    	for(int i=0;i<s.length();i++) {
    		char c=s.charAt(i);
    		if(curr.children.get(c)==null) {
    			curr.children.put(c, new TrieNode());
    			curr=curr.children.get(c);
    		} else {
    			curr=curr.children.get(c);
    		}
    	}
    	curr.isWord=true;
    }
    
    public boolean search(String s) {
    	TrieNode curr = root;
    	
    	for(int i=0;i<s.length();i++) {
    		char c=s.charAt(i);		
    		if(curr.children.get(c)!=null) {
    			curr=curr.children.get(c);
    		} else {
    			return false;
    		}
    	}
    	return curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
    	TrieNode curr = root;
    	
    	for(int i=0;i<prefix.length();i++) {
    		char c=prefix.charAt(i);		
    		if(curr.children.get(c)!=null) {
    			curr=curr.children.get(c);
    		} else {
    			return false;
    		}
    	}
    	
    	return true;
    }
}


class TrieNode {
	boolean isWord;
	public Map<Character, TrieNode> children = new HashMap<>();
}