import java.util.*;

class MinimumMovesToSpreadStonesOverGrid {
	public static void main(String args[]) {
		List<int[][]> grids = new ArrayList<>();
		grids.add(new int[][]{{1,1,0},{1,1,1},{1,2,1}});
		grids.add(new int[][]{{3,2,0},{0,1,0},{0,3,0}});
		grids.add(new int[][]{{0,0,0},{9,0,0},{0,0,0}});
		grids.add(new int[][]{{6,0,0},{1,0,0},{1,0,1}});
		grids.add(new int[][]{{0,0,0},{7,0,1},{0,0,1}});
		for(int[][] grid: grids) {
			System.out.println(minimumMoves(grid));
		}
	}
	static int totalMinSteps;

	public static int minimumMoves(int[][] grid) {
		List<int[]> zeroes = new ArrayList<>();
		List<int[]> stones = new ArrayList<>();
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(grid[i][j]==0) {
					zeroes.add(new int[]{i,j});
				} else if(grid[i][j]>1) {
					stones.add(new int []{i,j, grid[i][j]-1});
				}
			}
		}
		totalMinSteps = Integer.MAX_VALUE;
		helper(grid, zeroes, stones, 0, 0);
		return totalMinSteps;
	}

	public static void helper(int[][] grid, List<int[]> zeroes, List<int[]> stones, int index, int count)  {
		if(index>=zeroes.size()) {
			totalMinSteps = Math.min(totalMinSteps, count);
			return;
		}
		int[] zeroCell = zeroes.get(index);
		for(int[] extraStones: stones) {
			if(extraStones[2]>0) {
				int dis = Math.abs(zeroCell[0] - extraStones[0]) + Math.abs(zeroCell[1]-extraStones[1]);
				extraStones[2]--;
				helper(grid, zeroes, stones, index+1, count+dis);
				extraStones[2]++;
			}
		}
	}

	public static void printGrid(int[][] grid) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(grid[i][j]+", ");
			}
			System.out.println();
		}
		System.out.println("------------");
	}
}