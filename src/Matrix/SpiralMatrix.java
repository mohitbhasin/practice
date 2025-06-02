import java.util.*;

class SpiralMatrix {
    public static void main(String args[]) {
        List<int[][]> list = new ArrayList<>();
        list.add(new int[][] {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        });
        list.add(new int[][] {
            {1,2,3,4},
            {10,11,12,5},
            {9,8,7,6}
        });
        for(int[][] matrix: list) {
            System.out.println(spiralOrder(matrix));
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int direction = 1;
       
        List<Integer> result = new ArrayList<>();
        int rows=matrix.length;
        int cols=matrix[0].length;
        int row=0;
        int col=-1;
        
        while(rows>0 && cols>0) {
            for(int i=0; i<cols; i++) {
                col+=direction;
                result.add(matrix[row][col]);
            }
            rows--;
            for(int i=0; i<rows; i++) {
                row+=direction;
                result.add(matrix[row][col]);
            }
            cols--;
            direction*=-1;

        }
        return result;
    }
}

