import java.util.*;

class ValidSudoku {
	public static void main(String args[]) {
		List<char[][]> boards = new ArrayList<>();
		boards.add(new char[][] {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
		boards.add(new char[][] {{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
		boards.add(new char[][] {{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}});
		for(char[][] board: boards) System.out.println(isValidSudoku(board));
	}

	public static boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet;
        Set<Character> colSet;
        Map<Integer, Set<Character>> boxMap = new HashMap<>();;
        
        for(int i=0; i<board.length; i++) {
            rowSet = new HashSet<>();
            for(int j=0; j<board[0].length; j++) {
                char curr = board[i][j];
                if(curr=='.') continue;
                if(rowSet.contains(curr)) return false;
                rowSet.add(curr);
            }
        }
        
        for(int i=0; i<board.length; i++) {
            colSet = new HashSet<>();
            for(int j=0; j<board[0].length; j++) {
                char curr = board[j][i];
                if(curr=='.') continue;
                if(colSet.contains(curr)) return false;
                colSet.add(curr);
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int box = (i/3 * 3) + j/3;
                char curr = board[i][j];
                if(curr=='.') continue;
                if(boxMap.containsKey(box) && boxMap.get(box).contains(curr)) return false;
                boxMap.putIfAbsent(box, new HashSet<>());
                boxMap.get(box).add(curr);
            }
        }
        return true;
    }
}