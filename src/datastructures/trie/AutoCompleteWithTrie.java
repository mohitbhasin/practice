package datastructures.trie;

import java.util.List;

class AutoCompleteWithTrie {
	public static void main(String args[]) {
		Trie t = new Trie();
		t.insert("amazon");
		t.insert("amazon prime");
		t.insert("amazing");
		t.insert("amazing spider man");
		t.insert("amazed");
		t.insert("alibaba");
		t.insert("ali express");
		t.insert("ebay");
		t.insert("walmart");
		
		List<String> a = t.autocomplete("al");
		for(String s: a) {
			System.out.println(s);
		}
	}
}
