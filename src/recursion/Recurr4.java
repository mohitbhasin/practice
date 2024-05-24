import java.util.List;
import java.util.ArrayList;

class Recurr4 {
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		System.out.println(pascal(2, list, 1));
	}



	public static List<Integer> pascal(int rowIndex, List<Integer> curr, int currIndex) {
		if(currIndex>rowIndex) {
			return curr;
		}
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		for(int i=1; i<currIndex; i++) {
			temp.add(curr.get(i-1)+curr.get(i));
		}
		temp.add(1);
		return pascal(rowIndex, temp, currIndex+1);
	}
}