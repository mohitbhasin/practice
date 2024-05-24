import java.util.*;
import java.io.*;

class TrieMain {
	public static void main(String args[]) {
		Trie trie = new Trie();

		File file = new File("words.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String word = br.readLine();
			while(word!=null) {
				trie.insert(word);
				word = br.readLine();
			}
		} catch(Exception e) {

		}

		String[] query = {"searching","for","words","having","such","as","car","plant","rabbit","onion","soda","furniture","sky","glass", "mojito"};
		for(String word: query) {
			System.out.println(word+":"+trie.search(word));
		}
	}
}