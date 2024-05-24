import java.util.*;

class VowelSpellCheckler {
	public static void main(String args[]) {
		String[] wordlist = {"KiTe","kite","hare","Hare"};
		// String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
		String[] queries = {"keti","keto"};

		for(String word: spellchecker(wordlist, queries)) {
			System.out.print(word+", ");
		}
	}

	static Set<String> dict;
    static Map<String, String> lowerCaseMap;
    static Map<String, String> vowelMaskMap;

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        dict = new HashSet<>();
        lowerCaseMap = new HashMap<>();
        vowelMaskMap = new HashMap<>();
        for(String word: wordlist) {
            dict.add(word);
            String wordLower = word.toLowerCase();
            lowerCaseMap.putIfAbsent(wordLower, word);
            String masked = maskVowel(wordLower);
            vowelMaskMap.putIfAbsent(masked, word);
        }

        String[] result = new String[queries.length];
        int index=0;
        for(String word: queries) {
            result[index++]=solve(word);
        }
        return result;
    }

    public static String maskVowel(String word) {
        StringBuilder sb = new StringBuilder();
        for(char c: word.toCharArray()) {
            sb.append(isVowel(c) ? "*" : c);
        }
        return sb.toString();
    }

    public static boolean isVowel(char c) {
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
            return true;
        }
        return false;
    }

    public static String solve(String query) {
        if(dict.contains(query)) return query;

        String queryLower = query.toLowerCase();
        if(lowerCaseMap.containsKey(queryLower)) return lowerCaseMap.get(queryLower);
        
        String masked = maskVowel(queryLower);

        System.out.println(queryLower + vowelMaskMap.keySet());
        if(vowelMaskMap.containsKey(masked)) return vowelMaskMap.get(masked);

        return "";
    }
}