class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            int index = c - 'a';
            if(curr.neighbors[index]==null) {
                curr.neighbors[index]=new TrieNode();
            }
            curr = curr.neighbors[index];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode result = findWord(word);
        if(result==null || !result.isWord) return false;
        return true;
    }
    
    public boolean startsWith(String prefix) {
        return findWord(prefix)==null ? false : true;
    }

    public TrieNode findWord(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()) {
            int index = c - 'a';
            if(curr.neighbors[index]==null) return null;
            else {
                curr = curr.neighbors[index];
            }
        }
        return curr;
    }
}