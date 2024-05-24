import java.util.*;
class FindDistance {
	public static void main(String args[]) {
		char[][] matrix = {
			{'o','o','x','o'},
			{'o','o','o','o'},
			{'o','o','x','o'},
			{'o','o','o','o'},
		};
		Pair start = new Pair(0,1);
		int[][] result = getDistance(matrix, start);
		for(int i=0; i<result[0].length; i++) {
			for(int j=0; j<result.length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}


	public static int[][] getDistance(char[][] matrix, Pair start) {
		int[][] result = new int[matrix[0].length][matrix.length];
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(start);
		int count=0;
		int size=0;
		while(!queue.isEmpty()) {
			size=queue.size();
			for(int i=0; i<size; i++) {
				Pair curr = queue.poll();
				if(curr.x<0 || curr.x>=matrix[0].length || curr.y<0 || curr.y>=matrix.length || matrix[curr.x][curr.y]=='x' || matrix[curr.x][curr.y]=='v') {
					continue;
				}
				result[curr.x][curr.y]=count;
				matrix[curr.x][curr.y]='v';
				queue.offer(new Pair(curr.x-1, curr.y));
				queue.offer(new Pair(curr.x+1, curr.y));
				queue.offer(new Pair(curr.x, curr.y-1));
				queue.offer(new Pair(curr.x, curr.y+1));
			}
			count++;
		}
		return result;
	}


}


class Pair {
	int x;
	int y;
	Pair(int x, int y) {
		this.x=x;
		this.y=y;
	}
}