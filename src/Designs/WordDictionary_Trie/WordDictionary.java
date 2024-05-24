class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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
        return findWord(word, root);
    }

    public boolean findWord(String word, TrieNode curr) {
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(c=='.') {
                for(TrieNode neighbor: curr.neighbors) {
                    if(neighbor!=null && findWord(word.substring(i+1), neighbor)) {
                        return true;
                    }
                }
                return false;
            }
            int index = c - 'a';
            if(curr.neighbors[index]==null) return false;
            curr = curr.neighbors[index];
        }
        return curr.isWord;
    }
}

class TrieNode {
    TrieNode[] neighbors;
    boolean isWord;

    public TrieNode() {
        this.neighbors = new TrieNode[26];
        this.isWord = false;
    }
}