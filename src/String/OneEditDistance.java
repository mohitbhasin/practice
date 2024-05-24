class OneEditDistance {
	public static void main(String args[]) {
		String[] s = {"ab","abcde","","A"};
		String[] t = {"acb","abcd","","a"};

		for(int i=0; i<s.length; i++) {
			System.out.println(isOneEditDistance(s[i], t[i]));
		}
	}

	public static boolean isOneEditDistance(String s, String t) {
        if(s.length()<t.length()) return isOneEditDistance(t, s);
        if(s.length()-t.length()>1 || s.equals(t)) return false;
        
        for(int i=0; i<t.length(); i++) {
            if(s.charAt(i)!=t.charAt(i)) {
              if(s.length()>t.length()) {
                return s.substring(i+1).equals(t.substring(i));
              } else {
                  return s.substring(i+1).equals(t.substring(i+1));
              }
            }
        }
        return true;
    }
}