class FirstBadVersion {
	static int bad;
	public static void main(String args[]) {
		int n = 2126753390;
		int b = 1702766719;
		bad = b;
		System.out.println(firstBadVersion(n));
	}

	public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while(left<right) {
            int mid = left + (right-left)/2;
            if(isBadVersion(mid)) {
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return left;
    }

    public static boolean isBadVersion(int version) {
    	return version>=bad;
    }
}