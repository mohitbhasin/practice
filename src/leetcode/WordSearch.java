class WordSearch {
	static boolean[][] isVisited;
	public static void main(String args[]) {
		// char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};

		// char[][] board = {{'A','B'},{'C','D'}};
		// String word = "ABCCED";
		String word = "AAB";
		System.out.println(exist(board, word));
	}

	public static boolean exist(char[][] board, String word) {
        isVisited = new boolean[board.length][board[0].length];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j]==word.charAt(0)) {
					if(search(board, i, j, word, 0)) {
						return true;
					}
				}
			}
		}
		return false;
    }

	public static boolean search(char[][] board, int i, int j, String word, int index) {
		if(index>=word.length()) {
			return true;
		}
		if(i>=board.length || i<0 || j>=board[0].length || j<0 || board[i][j]!=word.charAt(index)) {
			return false;
		}
		// char temp = board[i][j];
		// board[i][j]='\0';
		System.out.println("i = "+i+" j = "+ j+" index = "+index);
		if(search(board, i+1, j, word, index+1) ||
				search(board, i, j+1, word, index+1) ||
				search(board, i, j-1, word, index+1) ||
				search(board, i-1, j, word, index+1)) {
			return true;
		}
		return false;
	}
}