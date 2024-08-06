import java.util.*;

class WordLadder {
	public static void main(String args[]) {
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		System.out.println(ladderLength_allCombi("hit", "cog", wordList));
		System.out.println(ladderLength_string("hit", "cog", wordList));
	}

	public static int ladderLength_string(String beginWord, String endWord, List<String> wordList) {
		wordList = new ArrayList<>(wordList);
		Map<String, List<String>> map = new HashMap<>();
		wordList.add(beginWord);
		for(String word: wordList) {
			char[] chars = word.toCharArray();
			for(int i=0; i<chars.length; i++) {
				String newWord = word.substring(0, i) + "*" + word.substring(i+1, word.length());
				map.put(newWord, map.getOrDefault(newWord, new ArrayList<>()));
				map.get(newWord).add(word);
			}
		}
		
		// for(Map.Entry<String, List<String>> entry: map.entrySet()) System.out.println(entry.getKey()+"="+entry.getValue());
		
		Queue<String> que = new LinkedList<>();
		que.offer(beginWord);
		int level = 1;
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i=0; i<size; i++) {
				String curr = que.poll();
				if(curr.equals(endWord)) return level;
				for(int j=0; j<curr.length(); j++) {
					String key = curr.substring(0, j) + "*" + curr.substring(j+1, curr.length());
					for(String neigh: map.get(key)) {
						if(!visited.contains(neigh)) {
							que.offer(neigh);
							visited.add(neigh);
						}
					}
				}
			}
			level++;
		}
		return 0;
	}

	public static int ladderLength_allCombi(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<>(wordList);
		Queue<String> que = new LinkedList<>();
		que.offer(beginWord);
		set.remove(beginWord);
		int level = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			level++;
			for(int i=0; i<size; i++) {
				String curr = que.poll();
				if(curr.equals(endWord)) return level;
				for(String neigh: getNeighbors(curr)) {
					if(set.contains(neigh)) {
						set.remove(neigh);
						que.offer(neigh);
					}
				}
			}
		}
		return 0;
	}

	public static List<String> getNeighbors(String word) {
		char[] chars = word.toCharArray();
		List<String> neighbors = new ArrayList<>();
		for(int i=0; i<chars.length; i++) {
			char temp = chars[i];
			for(char c='a'; c<='z'; c++) {
				chars[i] = c;
				neighbors.add(new String(chars));
			}
			chars[i] = temp;
		}
		return neighbors;
	}
}