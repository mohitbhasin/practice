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

	public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
     
        boolean result = false;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
               if(dfs(board,word,i,j,0)){
                   result = true;
               }
            }
        }
     
        return result;
    }
 
public static boolean dfs(char[][] board, String word, int i, int j, int k){
    int m = board.length;
    int n = board[0].length;
 
    if(i<0 || j<0 || i>=m || j>=n){
        return false;
    }
 
    if(board[i][j] == word.charAt(k)){
        char temp = board[i][j];
        board[i][j]='#';
        if(k==word.length()-1){
            return true;
        }else if(dfs(board, word, i-1, j, k+1)
        ||dfs(board, word, i+1, j, k+1)
        ||dfs(board, word, i, j-1, k+1)
        ||dfs(board, word, i, j+1, k+1)){
            return true;
        }
        board[i][j]=temp;
    }
 
    return false;
}
}