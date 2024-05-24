class LongestPalindrome {
	public static void main(String args[]) {
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		System.out.println(longestPalindrome(s));
	}

	public static int longestPalindrome(String s) {
        int[] heap = new int[52];
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int index = -1;
            if(c>='a' && c<='z') {
                index = c - 'a';
            } else {
                index = c - 'A';
                index += 26;
            }
            heap[index]++;
        }

        int result = 0;
        int odd = 0;
        for(int count: heap) {
            if(count%2==0) {
                result+=count;
            } else if(odd<1) {
                result+=count;
                odd++;
            }
        }
        for(int count: heap) {
        	System.out.print(count+", ");
        }
        System.out.println();
        return result;
    }
}