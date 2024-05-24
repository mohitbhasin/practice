import java.util.*;

class ReconstructItenary {
	public static void main(String args[]) {
		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};

		// String[][] tickets = {
		// 	{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}
		// };
		System.out.println(findItenary(tickets));
	}

	public static List<String> findItenary(String[][] tickets) {
		Map<String, PriorityQueue<String>> ticketMap = new HashMap<>();
		PriorityQueue<String> des;
		for(String[] ticket: tickets) {
			if(!ticketMap.containsKey(ticket[0])) {
				des=new PriorityQueue<>();
				des.add(ticket[1]);
				ticketMap.put(ticket[0], des);
			} else {
				des=ticketMap.get(ticket[0]);
				des.add(ticket[1]);
				ticketMap.put(ticket[0], des);
			}
		}

		List<String> path = new ArrayList<>();
		helper(ticketMap, "JFK", path);
		// path.add("JFK");
		// helper2(ticketMap, "JFK", path);
		return path;
	}

	public static void helper(Map<String, PriorityQueue<String>> ticketMap, String source, List<String> path) {
		while(ticketMap.containsKey(source) && !ticketMap.get(source).isEmpty()) {
			helper(ticketMap, ticketMap.get(source).poll(), path);
		}
		path.add(0,source);
	}

	public static void helper2(Map<String, PriorityQueue<String>> ticketMap, String source, List<String> path) {
		if(!ticketMap.containsKey(source) || ticketMap.get(source).isEmpty()) {
			return;
		}
		for(String des: ticketMap.get(source)) {
			path.add(des);
			ticketMap.get(source).remove(des);
			helper2(ticketMap, des, path);
		}
	}
}