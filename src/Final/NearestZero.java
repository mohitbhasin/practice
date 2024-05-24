import java.util.*;

class NearestZero {
	public static void main(String args[]) {
		int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
		int[][] result = updateMatrix(mat);
		for(int[] row: result) {
			for(int col: row) {
				System.out.print(col);
			}
			System.out.println();
		}
	}
	public static int[][] updateMatrix(int[][] mat) {
        Queue<Pair> que = new LinkedList<>();
        int[][] dist = new int[mat.length][mat[0].length];
        
        for(int i=0; i<dist.length; i++) {
        	for(int j=0; j<dist[0].length; j++) {
        		if(mat[i][j]==0) {
        			dist[i][j]=0;
        			que.offer(new Pair(i,j));
        		} else {
        			dist[i][j]=Integer.MAX_VALUE;
        		}
        	}
        }

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!que.isEmpty()) {
        	Pair curr = que.poll();
        	for(int i=0; i<dir.length; i++) {
        		int new_r=curr.r+dir[i][0];
        		int new_c=curr.c+dir[i][1];
        		if(new_r>=0 && new_r<dist.length && new_c>=0 && new_c<dist[0].length) {
        			if(dist[new_r][new_c]>dist[curr.r][curr.c]+1) {
        				dist[new_r][new_c]=dist[curr.r][curr.c]+1;
        				que.offer(new Pair(new_r, new_c));
        			}
        		}
        	}

        }
        return dist;
    }
}

class Pair {
    int r;
    int c;
    
    Pair(int r, int c) {
        this.r=r;
        this.c=c;
    }
}