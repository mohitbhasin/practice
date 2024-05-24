import java.util.*;

class MinimumIndexSumOfTwoLists {
	public static void main(String args[]) {
		String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
		String[] list2 = {"KFC","Shogun","Burger King"};
		list2 = findRestaurant(list1, list2);
		for(String s: list2) System.out.print(s+", ");
	}

	public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<list1.length; i++) {
            map.putIfAbsent(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        Map<String, Integer> sumMap = new HashMap<>();
        for(int i=0; i<list2.length; i++) {
            String curr = list2[i];
            if(map.containsKey(curr)) {
                int sum = map.get(curr) + i;
                if(sum<min) {
                    result.clear();
                    result.add(curr);
                    min=sum;
                } else if(sum==min) {
                    result.add(curr);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }
}