import java.util.*;

class DecodeWays {
	public static void main(String[] args) {
		// String[] strs = {"60, 11106","12","226","06","111111111111111111111111111111111111111111111"};
		String[] strs = {"111111111111111111111111111111111111111111111"};
		for(String s: strs)
		System.out.println(numDecodings(s) + ": "+count);
	}

	static Map<String, Integer> memo = new HashMap<>();
    static int count = 0;
    public static int numDecodings(String s) {
        if(s.length()==0) return 1;
        if(s.charAt(0)=='0') return 0;
        if(memo.containsKey(s)) return memo.get(s);
	    int  a = numDecodings(s.substring(1));
        int b = 0;
        if(s.length()>1 && Integer.valueOf(s.substring(0,2))<=26)  {
            b = numDecodings(s.substring(2));
        }
        memo.put(s, a+b);
        count++;
        return memo.get(s);
    }

	static Map<Integer, Integer> map;

	public static int numDecodings_old(String s) {
		map = new HashMap<>();
        return helper(s, 0);
    }

    public static int helper(String s, int index) {
    	if(map.containsKey(index)) return map.get(index);
        if(index==s.length()) {
            return 1;
        }
        if(s.charAt(index)=='0') return 0;

    	if(index>s.length()) {
    		return 0;
    	}

        int count=helper(s, index+1);
        if(index<s.length()-1) {
        	int tens = 10 * (s.charAt(index) - '0') + s.charAt(index+1) - '0';
	        if(tens>=10 && tens<27) {
	        	count+= helper(s, index+2);
	        }
        }
        map.put(index, map.getOrDefault(index, 0)+count);
        return count;
    }
}