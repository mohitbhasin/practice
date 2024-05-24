import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class IntersectionOfList {
	public static void main(String args[]) {
		int[] num1 = {1,2,2,1};
		int[] num2 = {2,2};
		System.out.println(intersect(num1, num2));
	}

	public static List<Integer> intersect(int[] num1, int[] num2) {

		List<Integer> result = new ArrayList<Integer>();
		for(int curr: num1) {
			for(int i=0; i<num2.length; i++) {
				if(curr==num2[i]) {
					result.add(curr);
					num2[i]=0;
				}
			}
		}
		return result;
	}
}