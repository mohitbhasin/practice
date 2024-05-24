class WordDictionary_Main {
    public static void main(String args[]) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("a");
        // System.out.println(dict.search("a"));
        System.out.println(dict.search(".a"));
        // System.out.println(dict.search("a."));
    }
}