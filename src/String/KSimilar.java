import java.util.*;

// incorrect
class KSimilar {
	public static void main(String args[]) {
		String s1="bccaba";
		String s2="abacbc";

		System.out.println(kSimilarity(s1, s2));

	}

	public static int kSimilarity(String s1, String s2) {
        int k=0;
        Map<Character, List<Integer>> s1Map = new HashMap<>();
        char[] s1_chars = s1.toCharArray();
        for(int i=0; i<s1_chars.length; i++) {
            if(s1Map.containsKey(s1_chars[i])) {
                s1Map.get(s1_chars[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                s1Map.put(s1_chars[i], list);
            }
        }
        
        for(int i=0; i<s2.length(); i++) {
        	print(s1_chars);
            if(s1_chars[i]!=s2.charAt(i)) {
                swap(i, s2.charAt(i), s1Map, s1_chars);
                k++;
            } else {
            	System.out.println(s2.charAt(i));
            }
        }
        return k;
    }

    public static void print(char[] chars) {
    	for(char c: chars) {
    		System.out.print(c+", ");
    	}
		System.out.println();
    }
    
    public static void swap(int index, char c, Map<Character, List<Integer>> s1Map, char[] s1_chars) {
        int charIndex = s1Map.get(c).remove(0);
        s1_chars[charIndex]=s1_chars[index];
        s1_chars[index]=c;
        
        s1Map.get(c).add(index);
        s1Map.get(s1_chars[charIndex]).add(charIndex);
    }
}