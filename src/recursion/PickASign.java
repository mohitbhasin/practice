

class PickASign {
	public statid void main(String args[]) {

	}

	public static int countWays(int[] arr, int sum, int currSum, int index) {
		if(index==arr.lenght) {
			if(currSum==currSum) {
				return 1;
			} else {
				return 0;
			}
		}
		int count=0;
		for(int i=0; i<arr.lenght; i++) {
			count+=countWays(arr, sum, currSum+arr[i], index);
			arr[i]*=-1;
			count+=countWays(arr, sum, currSum+arr[i], index);
		}


		return count;
	}
}