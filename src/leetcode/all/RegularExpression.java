package leetcode.all;

public class RegularExpression {

	
	
	public static boolean isMatch(String s, String p) {
		if(p.equals("")) {
			return false;
		}
		
		if(p.charAt(0)==s.charAt(0) || p.charAt(0)=='.') {
			return isMatch(s.substring(1),p.substring(1));
		}
		if(p.charAt(0)=='*' && s!=null) {
			if(p.length()==1) {
				return true;
			}
			if(p.charAt(1)=='*') {
				return isMatch(s, p.substring(1));
			}
			if(p.charAt(1)!=s.charAt(0)) {
				return isMatch(s.substring(1), p);
			}
			else {
				return true;
			}
		}
		return false;
	}
}

