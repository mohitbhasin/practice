class ValidateIPAddress {
	public static void main(String args[]) {
		// String queryIP = "f:f:f:f:f:f:f:f";
		String[] queryIP = {"172.16.254.1","2001:0db8:85a3:0:0:8A2E:0370:7334","256.256.256.256",
		"f:f:f:f:f:f:f:f","12..33.4","2001:0db8:85a3:0:0:8A2E:0370:7334:","256.256.256.256"};
        for(String s: queryIP) {
        	System.out.println(validIPAddress(s));
        }
        
        
	}

	public static String validIPAddress(String queryIP) {
        // if len > 39 or == 0; return neither
        // ipv4 <=15 length
        // split based on "." should exact 4
        
        // ipv6 <=39 length 
        // split based on "." should exact 8
        if(queryIP.length()>39 || queryIP.endsWith(".") || queryIP.endsWith(":")) return "Neither";
        String result = "";
        if(queryIP.contains(".")) {
            String[] splitString = queryIP.split("\\.");
            if(splitString.length!=4) return "Neither";
            for(String s: splitString) {
                if(s.length()==0 || !checkIP4(s)) return "Neither";
            }
            result="IPv4";
        }
        else {
            String[] splitString = queryIP.split("\\:");
            if(splitString.length!=8) return "Neither";
            for(String s: splitString) {
                if(s.length()==0 || !checkIP6(s)) return "Neither";
            }
            result="IPv6";
        }
        return result;
    }
    
    public static boolean checkIP4(String s) {
        if(s.length()>3) return false;
        if(s.length()>1 && s.charAt(0)=='0') return false;
        int num = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c<'0' || c>'9') return false;
            num*=10;
            num+=c-'0';
        }
        return num<=255 ? true : false;
    }
    
    public static boolean checkIP6(String s) {
        if(s.length()>4) return false;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!((c>='0' && c<='9') || (c>='a' && c<='f') || (c>='A' && c<='F'))) return false;
        }
        return true;
    }
}