class WordSearch {
	public static void main(String args[]) {
		char[][] matrix = {
			{'A','C','D','F'},
			{'A','M','K','G'},
			{'P','C','L','Z'},
			{'F','Q','M','A'}};
		String s = "CDCDCD";
		System.out.println(search(matrix,s));
	}

	public static boolean search(char[][] matrix, String s) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j]==s.charAt(0)) {
					return dfs2(matrix, i, j, s, 0);
				}
			}	
		}
		return false;
	}

	//will return wrong result for string with character with same sequence such as CDCDCDCD it will refer back same character index. 
	// The reason is the current charater is not updated with blank character.
	public static boolean dfs2(char[][] matrix, int i, int j, String s, int index) {
		boolean result = false;
		if(s.length()==index) {
			return true;
		}
		if(i>=0 && i<matrix.length && j>=0 && j<matrix[0].length && matrix[i][j]==s.charAt(index) && index<s.length()) {
			result=true;
			result = 	dfs2(matrix, i+1, j, s, index+1) || 
					 	dfs2(matrix, i-1, j, s, index+1) || 
					 	dfs2(matrix, i, j+1, s, index+1) || 
					 	dfs2(matrix, i, j-1, s, index+1);
		}
		return result;
	}

	public static boolean dfs(char[][] matrix, int i, int j, String s, int index) {
		if(index==s.length()) {
			return true;
		}
		if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j]!=s.charAt(index)) {
			return false;
		}

		char temp = matrix[i][j];
		matrix[i][j] = ' ';
		boolean found = bfs(matrix, i+1, j, s, index+1) || 
						bfs(matrix, i-1, j, s, index+1) || 
						bfs(matrix, i, j+1, s, index+1) ||
						bfs(matrix, i, j-1, s, index+1);

		matrix[i][j]=temp;
		return found;

	}
}