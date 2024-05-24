class DefangIPAddress {
	public static void main(String args[]) {
		System.out.println(defangIPaddr("1.1.1.1"));
	}

	public static String defangIPaddr(String address) {
        String[] addressArray = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        
        for(String val: addressArray) {
            sb.append(val);
            sb.append("[.]");
        }
        
        return sb.substring(0, sb.length()-3);
    }
}