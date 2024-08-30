import java.util.*;


// This is a custom problem (Similar to Merge K sorted Lists)
class StockUltraSort {
	public static void main(String args[]) {
		Map<String, List<Integer>> map = new HashMap<>();
		map.put("Microsoft",Arrays.asList(110,120,135,150,151,187));
		map.put("Google",Arrays.asList(130,140,145,153,155));
		map.put("Amazon",Arrays.asList(112,122,139,151));
		map.put("Facebook",Arrays.asList(109,113));

		System.out.println(merge(map));
    }

    public static List<String> merge(Map<String, List<Integer>> map) {
			List<String> result = new ArrayList<>();
			PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.price - b.price);
			Map<String, Integer> indexMap = new HashMap<>();
			for(String comp: map.keySet()) {
				indexMap.put(comp, 0);
			}

			for(String key: indexMap.keySet()) {
				pq.offer(new Pair(key, map.get(key).get(0)));
				indexMap.put(key, 0);
			}

			while(!pq.isEmpty()) {
				Pair curr = pq.poll();
				result.add(curr.name+" $"+curr.price);
				if(indexMap.get(curr.name)==map.get(curr.name).size()-1) {
					continue;
				}
				int index = indexMap.get(curr.name)+1;
				indexMap.put(curr.name, index);
				curr.price = map.get(curr.name).get(index);
				pq.offer(curr);
			}
			return result;
		}
}

class Pair {
	String name;
	int price;
	public Pair(String name, int price) {
		this.name = name;
		this.price = price;
	}
}