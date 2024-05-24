class NextGreaterElement_III {
	public static void main(String args[]) {
		int[] nums = {12, 543576, 2147483647, 230241
};
		for(int num: nums) {
			System.out.println(nextGreaterElement(num));
		}
	}

	public static int nextGreaterElement(int n) {
        String str = new String(""+n);
        char[] vals = str.toCharArray();
        int len = str.length()-1;
        int i=vals.length-2;
        int left = -1;
        while(i>=0) {
        	// dip is found
        	if(vals[i]<vals[i+1]) {
        		left=i;
        		break;
        	}
        	i--;
        }


        if(i==-1) return -1;

        for(int j=len; j>i; j--) {
			if(vals[j]>vals[i]) {
    			swap(vals, j, i);
    			left = i+1;
    			break;
			}
		}

        int right = len;
        while(left<right) {
        	swap(vals, left++, right--);
        }

        str = new String(vals);
        
        int result=-1;

		try {
        	result = Integer.valueOf(str);
        } catch(NumberFormatException e) {
        	return -1;
        }
        

        return result<n ? -1 : result;
    }

    public static void swap(char[] vals, int i, int j) {
    	char temp = vals[i];
    	vals[i] = vals[j];
    	vals[j] = temp;
    }
}