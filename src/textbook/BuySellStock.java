package textbook;

//find max profit on share prices
//<310,315,275,295,260,270,290,230,255,250>
//max profit by one by and one sell is 30
//buy at 260 and sell at 290.
//note that 260 is not the lowest price

public class BuySellStock {
	public static void main(String args[]) {
		int[] prices = {310,315,275,295,260,270,290,230,255,250};
		System.out.println("Max profit is "+ buySell(prices));
	}
	
	static int buySell(int[] prices) {
		int minPrice=Integer.MAX_VALUE;
		int maxProfit=0;
		for(int p : prices) {
			maxProfit=Math.max(maxProfit, p-minPrice);
			minPrice=Math.min(minPrice, p);
			System.out.println("Min prices "+minPrice);
		}
		return maxProfit;
	}
}
