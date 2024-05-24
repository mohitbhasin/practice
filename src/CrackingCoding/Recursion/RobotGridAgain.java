// number of ways possible

class RobotGridAgain {
	public static void main(String args[]) {
		System.out.println(countOptions(0,0,3,3));
	}


	public static int countOptions(int i, int j, int x, int y) {
		if(i>=x || j>=y) {
			return 0;
		}

		if(i==x-1 && j==y-1) {
			return 1;
		}

		return countOptions(i+1, j, x, y) + countOptions(i, j+1, x, y);
	}
}