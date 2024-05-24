class RobotInGrid {
	public static void main(String args[]) {
		int[][] grid = new int[][] {
										{ 1, 2, -3, 4, 5, 6 },
										{ 7, 8, 9, 10, 11, -12 },
										{ 13, -14, 15, -16, 17, 18 },
										{ 19, 20, 21, 22, -23, 24 }
		};
		System.out.println(findPath(grid, 0, 0));
	}

	public static boolean findPath(int[][] grid, int r, int c) {
		int r_length = grid.length;
		int c_length = grid[0].length;
		if(r==r_length-1 && c==c_length-1) {
			System.out.print("Found");
			return true;
		}
		else if(r==r_length || c==c_length || grid[r][c]<1) {
			return false;
		}
		else {
			System.out.print(grid[r][c]+" --> ");
			return findPath(grid, r+1, c) || findPath(grid, r, c+1);
		}
	}
}