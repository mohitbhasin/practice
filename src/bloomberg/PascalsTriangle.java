import java.util.*;

class PascalsTriangle {
	public static void main(String args[]) {
		int numRows = 5;

		System.out.println(generate(numRows));
		System.out.println(generate_leetcode(numRows));
        System.out.println(print(numRows));
	}

    public static List<List<Integer>> print(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        result.get(0).add(1);
        for(int i=1; i<numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            List<Integer> prev = result.get(result.size()-1);
            for(int j=0; j<prev.size()-1; j++) {
                curr.add(prev.get(j) + prev.get(j+1));
            }
            curr.add(1);
            result.add(curr);
        }
        return result;
    }

	public static List<List<Integer>> generate_leetcode(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // Base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> digits = new ArrayList<>();
        digits.add(1);
        result.add(digits);
        if(numRows==1) return result;
        digits = new ArrayList<>();
        digits.add(1);
        digits.add(1);
        result.add(digits);
        if(numRows==2) return result;
        int i=2;
        while(i++<numRows) {
            List<Integer> num = result.get(result.size()-1);
            int index=0;
            digits = new ArrayList<>();
            digits.add(1);
            while(index<num.size()-1) {
                digits.add(num.get(index)+num.get(index+1));
                index++;
            }
            digits.add(1);
            result.add(digits);
        }
        return result;
    }
}