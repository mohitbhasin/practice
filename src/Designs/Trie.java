class Trie {
    Trie[] children;
    boolean isWord;
    public Trie() {
        children = new Trie[26];
        isWord=false;
    }
    
    public void insert(String word) {
        Trie currTrie = this;
        
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(currTrie.children[index]==null) {
                currTrie.children[index] = new Trie();
            }
            currTrie=currTrie.children[index];
        }
        currTrie.isWord=true;
    }
    
    public boolean search(String word) {
        Trie currTrie = this;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(currTrie.children[index]==null) {
                return false;
            }
            currTrie = currTrie.children[index];
        }
        return currTrie.isWord==true;
    }
    
    public boolean startsWith(String prefix) {
        Trie currTrie = this;
        for(int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if(currTrie.children[index]==null) {
                return false;
            }
            currTrie = currTrie.children[index];
        }
        return true;
    }
}