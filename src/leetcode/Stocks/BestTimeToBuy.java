class BestTimeToBuy {
	public static void main(String args[]) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
		System.out.println(onePass(prices));
        System.out.println(onePassBetter(prices));
	}

	public static int maxProfit(int[] prices) {
        int max = 0;

        for(int i=0; i<prices.length-1; i++) {
        	for(int j=i+1; j<prices.length; j++) {
        		max=Math.max(max, prices[j] - prices[i]);
        	}
        }
        return max;
    }

    public static int onePass(int[] prices) {
    	int maxProfit=0;
    	int minPrice=Integer.MAX_VALUE;
    	for(int i=0; i<prices.length; i++) {
    		if(prices[i]<minPrice) {
    			minPrice=prices[i];
    		} else if(prices[i]-minPrice>maxProfit) {
    			maxProfit=prices[i]-minPrice;
    		}
    	}
    	return maxProfit;
    }

    public static int onePassBetter(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int maxproft=0;
        for (int i=0; i<prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            maxproft = Math.max(maxproft,prices[i]-minPrice);
        }
        return maxproft;
    }    
}