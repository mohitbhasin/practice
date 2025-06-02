import java.util.*;

class MaximalSquare {
	public static void main(String args[]) {
		
		// char[][] matrix = {
		// 	{'0','1'},{'1','0'}
		// };
		List<char[][]> matList = new ArrayList<>();
		matList.add(new char[][] {
			{'0','1'},{'1','0'}
		});
		matList.add(new char[][] {
			{'0', '1', '1', '0', '1',},
			{'1', '1', '0', '1', '0',},
			{'0', '1', '1', '1', '0',},
			{'1', '1', '1', '1', '0',},
			{'1', '1', '1', '1', '1',},
			{'0', '0', '0', '0', '0',},
		});
		matList.add(new char[][] {
			{'1','0','1','1','0','1'},
			{'1','1','1','1','1','1'},
			{'0','1','1','0','1','1'},
			{'1','1','1','0','1','0'},
			{'0','1','1','1','1','1'},
			{'1','1','0','1','1','1'}
		});
		for(char[][] matrix: matList) {
			System.out.println(maximalSquare(matrix));
		}
	}

	// input is char matrix
	public static int maximalSquare(char[][] matrix) {
        int max = 0;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(i==0 || j==0) {
					max = Math.max(max, matrix[i][j] - '0');
					continue;
				}
                if(matrix[i][j]=='1') {
                    int min = Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1])) - '0';
                    int val = matrix[i][j]-'0';
                    matrix[i][j] = (char) (min+val+'0');
                    max = Math.max(matrix[i][j]-'0', max);
                }
			}
		}
		return max*max;
    }
}