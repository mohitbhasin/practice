import java.util.*;

class FloodFill {
	public static void main(String args[]) {
		// int[][] image = {
		// 	{1,1,1},
		// 	{1,1,0},
		// 	{1,0,1}
		// };

		int[][] image = {
			{0,0,0},
			{0,1,1}
		};
		floodFill(image, 1, 1, 1);
		for(int i=0; i<image.length; i++) {
			for(int j=0; j<image[0].length; j++) {
				System.out.print(image[i][j]+", ");
			}
			System.out.println();
		}
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		Queue<Pair> que = new LinkedList<>();
        Pair root = new Pair(sr, sc);
        que.offer(root);
        int color = image[sr][sc];
        if(color==newColor) {
        	return image;
        }
        while(!que.isEmpty()) {
            Pair curr = que.poll();
            if(curr.r>=0 && curr.r<image.length && curr.c>=0 && curr.c<image[0].length && image[curr.r][curr.c]==color) {
                image[curr.r][curr.c]=newColor;
                que.offer(new Pair(curr.r+1, curr.c));
                que.offer(new Pair(curr.r-1, curr.c));
                que.offer(new Pair(curr.r, curr.c+1));
                que.offer(new Pair(curr.r, curr.c-1));
            }
        }
        return image;
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