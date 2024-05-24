class PermutaionInString {
	public static void main(String args[]) {
		System.out.println(checkInclusion("abc", "bbbca"));
	}

    public static  boolean checkInclusion(String s1, String s2) {
        int[] s1chars = new int[26];
        for(int i=0; i<s1.length(); i++) {
            s1chars[s1.charAt(i) - 'a']++;
        }
        
        for(int i=0; i<=s2.length() - s1.length(); i++) {
            int[] s2chars = new int[26];
            for(int j=i; j<s1.length()+i; j++) {
                s2chars[s2.charAt(j)-'a']++;
            }
            if(checkFrequencies(s1chars, s2chars)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean checkFrequencies(int[] s1chars, int[] s2chars) {
        for(int i=0; i<s1chars.length; i++) {
            if(s1chars[i]!=s2chars[i]) return false;
        }
        return true;
    }


    //Not Efficient (n X n!). Time Limit Exceeds.

	// public static boolean checkInclusion(String s1, String s2) {
 //        return checkInPermutaion(s1.toCharArray(), 0, s1.length(), s2);
 //    }
    private static boolean checkInPermutaion(char[] str, int first, int n, String s2) {
    	if(first==n) {
    		return s2.indexOf(new String(str))>=0;
    	}
    	for(int i=first; i<n; i++) {
    		swap(str, first, i);
    		if(checkInPermutaion(str, first+1, n, s2)) {
    			return true;
    		}
    		swap(str, first, i);
    	}
    	return false;
    }

    private static void swap(char[] str, int i, int j) {
    	char c = str[i];
    	str[i] = str[j];
    	str[j] = c;
    }
}