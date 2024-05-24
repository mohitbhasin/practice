import java.util.*;

class ExpressiveWords {
	public static void main(String args[]) {
		// String s = "heeellooo";
		// String[] words = {"hello", "hi", "helo"};
		// String s = "lee";
		// String[] words = {"le"};
		// String s = "vvvppppeeezzzzztttttkkkkkkugggggbbffffffywwwwwwbbbccccddddddkkkkksssppppddpzzzzzhhhhbbbbbmmmy";
		// String[] words = {"vpeezzttkkuggbbffywbccddksppddpzhhbbmy", "vvpeezzttkkugbbfywwbcdkksppddpzhbmy"};
		String s = "abccc";
		String[] words = {"abcd"};
		// for(String word: words) {
		// 	expressiveWords(word, words);	
		// }
		System.out.println(expressiveWords(s, words));
	}

	public static int expressiveWords(String s, String[] words) {
        List<Pair> groups = new ArrayList<>();
        int l = 0;
        int r = 0;
        Pair pair;
        while(r<s.length()) {
            char curr = s.charAt(r);
            if(curr!=s.charAt(l)) {
                pair = new Pair(s.charAt(l), r-l);
                groups.add(pair);
                l=r;
            }
            r++;
        }
        pair = new Pair(s.charAt(l), r-l);
        groups.add(pair);
        int result = 0;
        for(String word: words) {
            if(helper(groups, word)) result++;
        }
        return result;
    }
    
    public static boolean helper(List<Pair> groups, String word) {
        int l = 0;
        int r = 0;
        int i=0;
        Pair group;
        while(r<word.length()) {
        	if(i==groups.size()) return false;
            char curr = word.charAt(r);
            if(word.charAt(l)!=curr) {
                group = groups.get(i++);
                if((group.c!=word.charAt(l))) {
                    return false;
                }
                if(group.count!=r-l) {
                    if(group.count<3 || group.count<r-l) {
                    	return false;
                    }
                }
                l=r;
            }
            r++;
        }
        if(i==groups.size()) return false;
        group = groups.get(i++);
        if(word.charAt(l)!=group.c) return false; 
        if(r-l!=group.count && (r-l>group.count || group.count<3)) return false;
        return i==groups.size();
    }
}

class Pair {
    char c;
    int count;
    public Pair(char c, int count) {
        this.c = c;
        this.count = count;
    }

    public String toString() {
    	return "<"+c+":"+count+">";
    }
}