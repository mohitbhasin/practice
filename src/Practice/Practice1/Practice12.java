class Practice12 {
	public static void main(String args[]) {
		System.out.println(getNumberOfCoins(3));
	}

	public static int getNumberOfCoins(int amount) {
		int cents[] = {1, 5, 10, 25, 50};
		return change(amount, cents, 0, 4);
	}

	public static int change(int amount, int[] cents, int coins, int i) {
		if(i<0) {
			return ++coins;
		} 
		if(amount>cents[i]) {
			coins++;
			amount-=cents[i];
		} else {
			i--;
		}
		return change(amount, cents, coins, i);
	}
}