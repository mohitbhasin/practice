class FindDuplicate {
	public static void main(String args[]) {
		check(new int[]{1});
	}


//not completed
	public static void check(int[] array) {
		int size = 32000;
		System.out.println(Integer.toBinaryString(size));
		int[] bitSet = new int[size >> 5];
		System.out.println(bitSet.length);
		System.out.println(21 % 32);
	}
}