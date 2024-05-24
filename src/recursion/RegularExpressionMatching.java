class RegularExpressionMatching {
	public static void main(String args[]) {
		String s = "hit";
		String p = "h*t";
		System.out.println(isMatch(s, p));
	}

	public static boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

	// public static boolean isMatch(String s, String p) {
	// 	// if(p.isEmpty() && s.isEmpty()) return true;
	// 	if(p.isEmpty()) return s.isEmpty();
    //     if(p.length()>0 && s.length()>0 && (p.charAt(0)=='.' || p.charAt(0)==s.charAt(0))) {
    //     	return isMatch(s.substring(1), p.substring(1));
    //     } else {
    //     	return false;
    //     }
    // }
}