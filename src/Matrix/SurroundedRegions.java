import java.util.*;

class SurroundedRegions {
	public static void main(String args[]) {
		char[][] board = 
			{{'X','O','X','O','X','O','O','O','X','O'},
			 {'X','O','O','X','X','X','O','O','O','X'},
			 {'O','O','O','O','O','O','O','O','X','X'},
			 {'O','O','O','O','O','O','X','O','O','X'},
			 {'O','O','X','X','O','X','X','O','O','O'},
			 {'X','O','O','X','X','X','O','X','X','O'},
			 {'X','O','X','O','O','X','X','O','X','O'},
			 {'X','X','O','X','X','O','X','O','O','X'},
			 {'O','O','O','O','X','O','X','O','X','O'},
			 {'X','X','O','X','X','X','X','O','O','O'}};
		// char[][] board = 
		// {{'X','O','X','O','X','O'},
		//  {'O','X','O','X','O','X'},
		//  {'X','O','X','O','X','O'},
		//  {'O','X','O','X','O','X'}};

		solve(board);

		for(char[] row: board) {
			for(char c: row) {
				System.out.print(c+", ");	
			}
			System.out.println();
		}
	}

	public static void solve(char[][] board) {
//         left and right column
        for(int i=0; i<board.length; i++) {
            if(board[i][0]=='O') dfs(board, i, 0);
            if(board[i][board[0].length-1]=='O') dfs(board, i, board[0].length-1);
        }
//         top and bottom rows
        for(int j=0; j<board[0].length; j++) {
            if(board[0][j]=='O') dfs(board, 0, j);
            if(board[board.length-1][j]=='O') dfs(board, board.length-1, j);
        }
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='V') board[i][j]='O';
            }
        }
    }
    
    
    public static void dfs(char[][] board, int i, int j) {
        if(i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j]=='O'){
            board[i][j]='V';
            dfs(board, i-1, j);
            dfs(board, i+1, j);
            dfs(board, i, j-1);
            dfs(board, i, j+1);
        }
    }
}