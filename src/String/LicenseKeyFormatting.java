class LicenseKeyFormatting {
	public static void main(String args[]) {
		String s = "5F3Z-2e-9-w";
		int k = 4;

		System.out.print(licenseKeyFormatting(s, k));
	}

	public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count=0;
        for(int i=s.length() - 1; i>=0; i--) {
            if(s.charAt(i)!='-') {
                sb.insert(0, Character.toUpperCase(s.charAt(i)));
                count++;
                if(count==k) {
                    sb.insert(0, '-');
                    count=0;
                }
            }
        }
        if(sb.length()!=0 && sb.charAt(0)=='-') {
            return sb.substring(1);
        }
        return sb.toString();
    }
}