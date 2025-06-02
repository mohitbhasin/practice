import java.util.*;

class WordSearch {
	public static void main(String args[]) {
        List<char[][]> boardList = new ArrayList<>();
        List<String> wordList = new ArrayList<>();
        boardList.add(new char[][] {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}});
        boardList.add(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}});
        boardList.add(new char[][] {{'N','W','L','I','M'},{'V','I','L','Q','O'},{'O','L','A','T','O'},{'R','T','A','I','N'},{'O','I','T','N','C'}});
        boardList.add(new char[][] {{'J','D','E','I','Y'},{'G','I','L','M','O'},{'Z','A','I','E','O'},{'L','T','B','S','N'},{'S','I','T','C','C'}});
        wordList.add("ABCESEEEFS");
        wordList.add("ABCB");
        wordList.add("LATIN");
        wordList.add("AIM");

        for(int i=0; i<boardList.size(); i++) {
            System.out.println(exist(boardList.get(i), wordList.get(i)));
        }
	}

	static int[][] directions = {{1,0},{-1, 0},{0,-1},{0,1}};
    public static boolean exist(char[][] board, String word) {
         for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(word.charAt(0)==board[i][j] && findWord(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean findWord(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '0';

        for (int[] dir : directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (findWord(board, x, y, word, index + 1)) {
                board[i][j] = temp;
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }
}