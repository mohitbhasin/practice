class WordSearch {
	public static void main(String args[]) {
		char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
		String word = "ABCESEEEFS";
		System.out.println(exist(board, word));
	}

	public static boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]==word.charAt(0)) {
                    if(dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, int i, int j, String word, int index) {
        if(index==word.length()) {
            return true;
        }
        if(i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j]==word.charAt(index)) {
            System.out.println(word.charAt(index));
            board[i][j]='0';
            print(board);
            if(dfs(board, i+1, j, word, index+1) || dfs(board, i-1, j, word, index+1) || dfs(board, i, j+1, word, index+1) || dfs(board, i, j-1, word, index+1)) {
                return true;
            }
            board[i][j]=word.charAt(index);
        }
        return false;
    }

    public static void print(char[][] board) {
    	for(char[] curr: board) {
    		for(char c: curr) {
    			System.out.print(c+"\t");
    		}
    		System.out.println();
    	}
    }
}