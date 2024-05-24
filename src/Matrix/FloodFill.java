class FloodFill {
	public static void main(String arg[]) {
		// int[][] image = {{0,0,0},{0,0,0}};
		// int sr = 0;
		// int sc = 0;
		// int color = 0;

		int[][] image = {{0,0,0},{0,1,0}};
		int sr = 1;
		int sc = 0;
		int color = 2;

		floodFill(image, sr, sc, color);
		for(int[] r: image) {
			for(int c: r) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
		if(image[sr][sc]==color) return image;
		dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    
    public static void dfs(int[][] image, int r, int c, int color, int org) {
        if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c]==org) {
            image[r][c]=color;
            dfs(image, r+1, c, color, org);
            dfs(image, r-1, c, color, org);
            dfs(image, r, c+1, color, org);
            dfs(image, r, c-1, color, org);
        }
    }
}