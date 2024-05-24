class WordDictionary_Main {
    public static void main(String args[]) {
        WordDictionary dict = new WordDictionary();
        // dict.addWord("bad");
        // dict.addWord("dad");
        // dict.addWord("mad");
        // System.out.println(dict.search("pad"));
        // System.out.println(dict.search("bad"));
        // System.out.println(dict.search(".ad"));
        // System.out.println(dict.search("b.."));

        dict.addWord("a");
        // System.out.println(dict.search("a"));
        System.out.println(dict.search(".a"));
        // System.out.println(dict.search("a."));
    }
}