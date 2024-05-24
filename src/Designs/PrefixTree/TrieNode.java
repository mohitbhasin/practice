class TrieNode {
    TrieNode[] neighbors;
    boolean isWord;

    public TrieNode() {
        this.neighbors = new TrieNode[26];
        this.isWord = false;
    }
}