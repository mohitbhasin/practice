import java.util.*;

//Wrong solution
class WordLadder {
	public static void main(String args[]) {
		// String beginWord = "hit", endWord = "cog"; 
		// String[] wordList = {"hot","dot","dog","lot","log","cog"};
		// String beginWord = "hot", endWord = "dog"; 
		// String[] wordList = {"hot","dog","dot"};
		String beginWord = "qa", endWord = "sq";
		String[] wordList = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
		System.out.println(ladderLength(beginWord, endWord, Arrays.asList(wordList)));
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Map<String, Set<String>> map = new HashMap<>();
		Set<String> wordSet = new HashSet<>();
		for(String word: wordList) wordSet.add(word);
		for(String word: wordSet) {
			if(canTransform(beginWord, word)) {
				if(canTransform(beginWord, word)) {
					map.putIfAbsent(beginWord, new HashSet<>());
					map.get(beginWord).add(word);
					map.putIfAbsent(word, new HashSet<>());
					map.get(word).add(beginWord);
				}
			}
		}
		if(map.size()==0) return 0;
		for(String word: wordSet) {
			for(String wordB: wordSet) {
				if(canTransform(word, wordB)) {
					map.putIfAbsent(word, new HashSet<>());
					map.get(word).add(wordB);
					map.putIfAbsent(wordB, new HashSet<>());
					map.get(wordB).add(word);
				}
			}
		}

		System.out.println(map);

		Queue<String> queue = new LinkedList<>();
		int transform = 0;
		queue.offer(beginWord);

		Set<String> visited = new HashSet<>();

		visited.add(beginWord);
		while(!queue.isEmpty()) {
			String curr = queue.poll();
			System.out.println(curr);
			transform++;
			for(String next: map.get(curr)) {
				if(next.equals(endWord)) {
					return transform;
				}
				if(visited.contains(next)) continue;
				if(map.containsKey(next)) {
					queue.offer(next);
					visited.add(next);
				}
			}
		}
		return 0;
	}

	// Exceeds Time Complexity
	public static int ladderLength_dfs(String beginWord, String endWord, List<String> wordList) {
        minTransform = Integer.MAX_VALUE;
        helper(beginWord, endWord, wordList, 1, new HashSet<>());
        return minTransform==Integer.MAX_VALUE ? 0 : minTransform;
    }
    
    static int minTransform;
    
    public static void helper(String curr, String endWord, List<String> wordList, int transform, Set<String> visited) {
        if(curr.equals(endWord)) {
            minTransform = Math.min(minTransform, transform);
            return;
        }
        for(String word: wordList) {
            if(word.length()!=curr.length() || visited.contains(word)) continue;
            if(!canTransform(curr, word)) {
            	continue;
            }
            visited.add(word);
            helper(word, endWord, wordList, transform+1, visited);
            visited.remove(word);
        }
    }

    public static boolean canTransform(String a, String b) {
    	if(a.length()!=b.length() || a.equals(b)) return false;
    	boolean mismatch = false;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i)!=b.charAt(i)) {
                if(mismatch) {
                	return false;
                }
                else mismatch = true;
            }
        }
        return true;
    }
}