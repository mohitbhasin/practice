// import java.util.*;

class StringToInteger_Atoi {
	public static void main(String args[]) {
		String[] strs = {"-2147483648", "     -42", "    +42", "    42ab", "    42  2", "    00042", "-91283472332", "41283472332"};
		for(String s: strs) {
			// System.out.println(myAtoi(s));
			System.out.println(myAtoi_concise(s));
		}
	}

	public static int myAtoi(String s) {
        int result = 0;
        int sign = 1;
        int index = 0;
        
        while(s.charAt(index)==' ') index++;
        
        if(s.charAt(index)=='-' || s.charAt(index)=='+') {
            if(s.charAt(index++)=='-') sign=-1;
        }
        
        while(index<s.length()) {
            char c = s.charAt(index++);
            if(c<'0' || c>'9') {
                break;
            } else {
            	if(sign<0) {
            		if(-result<Integer.MIN_VALUE/10 || (-result==Integer.MIN_VALUE/10 && -(c-'0')<Integer.MIN_VALUE%10)) {
            			return Integer.MIN_VALUE;
            		}
            	} 
            	if(sign>0) {
                    if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && (c-'0')>Integer.MAX_VALUE%10)) {
                    	return Integer.MAX_VALUE;
                    }
                }
                result*=10;
                result+=c - '0';
            }
        }
        return result*sign;
    }

    public static int myAtoi_concise(String s) {
    	int result = 0;
        int sign = 1;
        int index = 0;
        
        while(s.charAt(index)==' ') index++;
        
        if(s.charAt(index)=='-' || s.charAt(index)=='+') {
            if(s.charAt(index++)=='-') sign=-1;
        }
        
        while(index<s.length() && Character.isDigit(s.charAt(index))) {
    		int digit = s.charAt(index++) - '0';
        	if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && digit>Integer.MAX_VALUE%10)) {
        		return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        	}
            result*=10;
            result+=digit;
        }
        return result*sign;
    }
}