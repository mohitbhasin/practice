import java.util.*;

class ReorganizeString {
	public static void main(String args[]) {
		String[] strs = {
							// "aaaaabbbbbbb",
						  	// "abb",
						  	// "aaabc",
							// "aaab",
							// "g",
                            "aaaabbcc"
						  };
		for(String str: strs) {
			System.out.println("s="+str+"\tresult="+reorganizeString(str));
		}
	}

	public static String reorganizeString(String string1) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<string1.length(); i++) {
            char c = string1.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        for(char c: map.keySet()) {
        	pq.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        char prev='0';
        while(!pq.isEmpty()) {
        	char c = pq.poll();
        	if(prev!='0') {
        		pq.offer(prev);
        	}
        	sb.append(c);
        	int count = map.get(c);
        	count--;
            // Character valid for next iteration
        	if(count>0) {
        		map.put(c, count);
        		prev = c;
        	}
            // Character frequency 0, set prev to null
            else {
        		map.remove(c);
        		prev='0';
        	}
        }
        return sb.length()==string1.length() ? sb.toString() : "";
    }
}