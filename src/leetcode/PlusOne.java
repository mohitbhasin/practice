class PlusOne {
	public static void main(String args[]) {
		int[] num = {9};

		for(int i: addOne(num)) {
			System.out.print(i+", ");
		}
	}

	public static int[] addOne(int[] num) {
		int index = num.length - 1;

		while(index>=0) {
			int sum = num[index]+1;
			num[index]=sum;
			if(sum>9) {
				num[index]=0;
				index--;
			} else {
				return num;
			}
		}


		int[] newNum = new int[num.length + 1];
		newNum[0] = 1;
		return newNum;
	}
}