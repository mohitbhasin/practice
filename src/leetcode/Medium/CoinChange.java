import java.util.*;

class CoinChange {
	public static void main(String args[]) {
		// int[] coins = {1, 2, 5};
		// int amount = 11;
		// int[] coins = {2};
		// int amount = 3;
		// int[] coins = {2,5,10,1};
		// int amount = 27;
		int[] coins = {186,419,83,408};
		int amount = 6249;
		Arrays.sort(coins);
		System.out.println(coinChange(coins, amount));
	}

	public static int coinChange(int[] coins, int amount) {
		List<Integer> coinsList = new ArrayList<>();
		for(int coin: coins) {
			coinsList.add(coin);
		}

		List<List<Integer>> result = new ArrayList();
		change(coinsList, new ArrayList<>(), amount, result);
		int min  = Integer.MAX_VALUE;
		for(List<Integer> list: result) {
			min=Math.min(min, list.size());
		}
		System.out.println(min);

        return min;
    }

    public static void change(List<Integer> coins, List<Integer> currComb, int amount, List<List<Integer>> result) {
    	if(amount==0) {
    		result.add(new ArrayList<Integer>(currComb));
    		return;
    	}
    	if(amount<0) {
    		return;
    	}

    	for(int coin: coins) {
    		currComb.add(coin);
    		change(coins, currComb, amount-coin, result);
    		currComb.remove(currComb.size()-1);
    	}
    }
}