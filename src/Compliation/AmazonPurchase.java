import java.util.*;
//Incorrect
class AmazonPurchase {
	public static void main(String args[]) {
		List<Integer> shirt = Arrays.asList(2,4);
		List<Integer> pant = Arrays.asList(2,5,3);
		List<Integer> skirt = Arrays.asList(4,1,2);
		List<Integer> shoe = Arrays.asList(4,2);

		System.out.println(getOptions(shirt, pant, skirt, shoe, 10));
	}

	public static int getOptions(List<Integer> shirt, List<Integer> pant, List<Integer> skirt, List<Integer> shoe, int dollars) {
		if(shirt.isEmpty() || pant.isEmpty() || skirt.isEmpty() || shoe.isEmpty()) {
			return 0;
		}
		int sum = shirt.get(0)+pant.get(0)+skirt.get(0)+shoe.get(0);
		if(sum>dollars) {
			System.out.println(shirt.get(0)+"-"+pant.get(0)+"-"+skirt.get(0)+"-"+shoe.get(0));
			return 0;
		}
		return 1+
		getOptions(shirt.subList(1, shirt.size()), pant, skirt, shoe, dollars) 
		+ getOptions(shirt, pant.subList(1, pant.size()), skirt, shoe, dollars)
		+ getOptions(shirt, pant, skirt.subList(1, skirt.size()), shoe, dollars)
		+ getOptions(shirt, pant, skirt, shoe.subList(1, shoe.size()), dollars);

	}
}