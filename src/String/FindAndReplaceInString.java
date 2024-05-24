import java.util.*;

class FindAndReplaceInString {
	public static void main(String args[]) {
		// String s = "vmokgggqzp";
		// int[] indices = {3,5,1};
		// String[] sources = {"kg","ggq","mo"};
		// String[] targets = {"s","so","bfr"};
		// String s = "abcde";
		// int[] indices = {2,2};
		// String[] sources = {"cde","cdef"};
		// String[] targets = {"fe","f"};
		String s = "abcd";
		int[] indices = {0,2};
		String[] sources = {"ab","ec"};
		String[] targets = {"eee", "ffff"};

		System.out.println(findReplaceString(s, indices, sources, targets));
	}

	public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, List<String[]>> map = new HashMap<>();

        for(int i=0; i<indices.length; i++) {
        	if(!map.containsKey(indices[i])) {
        		map.put(indices[i], new ArrayList<>());
        	}
        	map.get(indices[i]).add(new String[]{sources[i], targets[i]});
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index<s.length()) {
        	if(map.containsKey(index)) {
        		for(String[] pair: map.get(index)) {
        			if(index+pair[0].length()<=s.length()) {
        				String source = pair[0];
        				String substr = s.substring(index, index+source.length());
        				if(source.equals(substr)) {
		        			sb.append(pair[1]);
		        			index+=substr.length();
		        		} else {
		        			sb.append(s.charAt(index++));
		        		}
        			}
        		}
        	}
        	else {
	        	sb.append(s.charAt(index++));
	        }
        }
        return sb.toString();
    }
}