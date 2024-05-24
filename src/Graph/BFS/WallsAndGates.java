import java.util.*;

class WallsAndGates {
	public static void main(String args[]) {
		int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
		wallsAndGates(rooms);
		for(int[] room: rooms) {
			for(int r: room) {
				System.out.print(r+", \t");
			}
			System.out.println();
		}
	}


	public static void wallsAndGates(int[][] rooms) {
		Queue<int[]> queue = new LinkedList<>();

		for(int i=0; i<rooms.length; i++) {
			for(int j=0; j<rooms[0].length; j++) {
				if(rooms[i][j]==0) {
					queue.offer(new int[]{i,j});
				}
			}
		}
		
		int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			for(int[] direction: directions) {
				int i = curr[0]+direction[0];
				int j = curr[1]+direction[1];

				if(i<0 || i>=rooms.length || j<0 || j>=rooms[0].length || rooms[i][j]!=Integer.MAX_VALUE) {
					continue;
				}
				queue.offer(new int[]{i,j});
				rooms[i][j]=rooms[curr[0]][curr[1]] + 1;
			}
		}
	}
}