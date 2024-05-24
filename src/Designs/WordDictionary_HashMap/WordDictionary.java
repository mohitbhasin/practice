import java.util.*;

class WordDictionary {
    TreeNode dict;
    public WordDictionary() {
        this.dict = new TreeNode();
    }
    
    public void addWord(String word) {
        this.dict.insert(word);
    }
    
    public boolean search(String word) {
        return this.dict.search(dict, word);
    }
}

class TreeNode {
    Map<Character, TreeNode> tree;
    boolean isWord;
    
    public TreeNode() {
        this.tree = new HashMap<>();
        this.isWord = false;
    }
    
    public void insert(String s) {
        TreeNode curr = this;
        for(char c: s.toCharArray()) {
            if(!curr.tree.containsKey(c)) {
                curr.tree.put(c, new TreeNode());
            }
            curr=curr.tree.get(c);
        }
        curr.isWord=true;
    }
    
    public boolean search(TreeNode root, String word) {
        TreeNode curr = root;
        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i)!='.' && curr.tree.containsKey(word.charAt(i))) {
                curr=curr.tree.get(word.charAt(i));
            } else {
                if(word.charAt(i)=='.') {
                    for(char next: curr.tree.keySet()) {
                        if(search(curr.tree.get(next), word.substring(i+1))) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return curr.isWord;
    }
}