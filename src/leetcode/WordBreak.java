import java.util.*;

class WordBreak{
	public static void main(String args[]) {
		// String word = "catsandogcat";
		// Set<String> wordDict = new HashSet<>();
		List<String> wordDict = new ArrayList<>();

		// wordDict.add("cats");
		// wordDict.add("dog");
		// wordDict.add("sand");
		// wordDict.add("and");
		// wordDict.add("cat");
		// wordDict.add("an");
		// System.out.println(check(word, wordDict));
		String word = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		wordDict.add("a");
		wordDict.add("aa");
		wordDict.add("aaa");
		wordDict.add("aaaa");
		wordDict.add("aaaaa");
		wordDict.add("aaaaaa");
		wordDict.add("aaaaaaa");
		wordDict.add("aaaaaaaa");
		wordDict.add("aaaaaaaaa");
		wordDict.add("aaaaaaaaaa");
		System.out.println(wordBreak(word, wordDict));
		System.out.println(wordBreak2(word, wordDict));

	}

	public static boolean check(String word, Set<String> wordDict) {
		if(word.length()==0 || word.isEmpty() || wordDict.contains(word)) return true;
		boolean flag = false;
		for(int i=0; i<word.length(); i++) {
			if(wordDict.contains(word.substring(0, i))) {
				flag=check(word.substring(i), wordDict);
			}
		}
		return flag;
	}

	public static boolean wordBreak2(String s, List<String> wordDict) {
        return wordBreakMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private static boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

	public static boolean wordBreak(String s, List<String> wordDict) {
		count=0;
       return dfs(s, new HashSet<>(wordDict), new HashMap<>());
    }
    static int count;
    public static boolean dfs(String s, Set<String> wordDict, Map<String, Boolean> map) {
    	System.out.println(count++);
        if(s.length()==0) return true;
        if(map.containsKey(s)) return map.get(s);
        for(int i=1; i<=s.length(); i++) {
        	String sub = s.substring(0, i);
            if(wordDict.contains(sub) && dfs(s.substring(i, s.length()), wordDict, map)) {
        		map.put(sub, true);
        		return true;
            }
        }
        map.put(s, false);
        return false;
    }
}