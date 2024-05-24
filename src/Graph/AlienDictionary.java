import java.util.*;
class AlienDictionary {
	public static void main(String args[]) {
        String[][] wordsArr = {
        	{"wrt","wrf","er","ett","rftt"},
        	{"ac","ab","zc","zb"}
        };
        for(String[] words: wordsArr) {
        	System.out.println(alienOrder(words));
        }
	}

	static Map<Character, List<Character>> adjList;
    static Map<Character, Boolean> visited;
    public static String alienOrder(String[] words) {
        adjList = new HashMap<>();
        visited = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        // put all the chars on the map
        for(String word: words) {
            for(int i=0; i<word.length(); i++) {
                adjList.putIfAbsent(word.charAt(i), new ArrayList<>());
            }
        }
        
        // put the relation in reverse order in the map
        // consider two words at a time to look for mismatched character
        for(int i=0; i<words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            
            if(word1.length()>word2.length() && word1.startsWith(word2)) {
                return "";
            }
            
            for(int j=0; j<Math.min(word1.length(), word2.length()); j++) {
                if(word1.charAt(j)!=word2.charAt(j)) {
                    adjList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }
        for(char c: adjList.keySet()) {
            if(!helper(c, sb)) return "";
        }
        
        return sb.toString();
    }
    
    public static boolean helper(char c, StringBuilder sb) {
        if(visited.containsKey(c)) return visited.get(c);
        visited.put(c, false);
        for(char next: adjList.get(c)) {
            if(!helper(next, sb)) {
                return false;
            }
        }
        sb.append(c);
        visited.put(c, true);
        return true;
    }
}