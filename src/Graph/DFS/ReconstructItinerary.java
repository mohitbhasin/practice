import java.util.*;

class ReconstructItinerary {
	public static void main(String args[]) {
		// String[][] ticketsArr = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
		String[][] ticketsArr = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		// String[][] ticketsArr = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		List<List<String>> tickets = new ArrayList<>();
		for(String[] ticket: ticketsArr) {
			List<String> tick = Arrays.asList(ticket);
			tickets.add(tick);
		}
		System.out.println(findItinerary(tickets));
		// System.out.println(findItinerary2(ticketsArr));

	}

	// Iterative DFS - Stack
	public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket: tickets) {
            String source=ticket.get(0);
            String dest=ticket.get(1);            
            if(!map.containsKey(source)) {
                map.put(source, new PriorityQueue<>());
            }
            map.get(source).add(dest);
        }
        
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while(!stack.isEmpty()) {
            	while(map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
            		stack.push(map.get(stack.peek()).poll());
            	}
            	System.out.println(stack);
            	result.add(0, stack.pop());
            	System.out.println("result--"+result);
        }
        return result;
    }

	//Post Order DFS solutions
	public static List<String> reconstruct(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> ticketsMap = new HashMap<>();
		// PriorityQueue<String> pq;
		for(List<String> ticket: tickets) {
            PriorityQueue<String> pq;
            if(ticketsMap.containsKey(ticket.get(0))) {
                ticketsMap.get(ticket.get(0)).add(ticket.get(1));
            } else {
                pq = new PriorityQueue<>();
                pq.add(ticket.get(1));
                ticketsMap.put(ticket.get(0), pq);
            }
        }

		List<String> result = new ArrayList<>();
		dfs3(ticketsMap, result, "JFK");
		return result;
	}

	public static void dfs(Map<String, PriorityQueue<String>> ticketsMap, List<String> result, String source) {
		if(!ticketsMap.containsKey(source)) {
			
		} else {
			PriorityQueue<String> destinations = ticketsMap.get(source);
			while(!destinations.isEmpty()) {
				dfs(ticketsMap, result, destinations.poll());
			}
		}
		result.add(0, source);
	}

	public static void dfs3(Map<String, PriorityQueue<String>> ticketsMap, List<String> result, String source) {
		if(ticketsMap.containsKey(source)) {
			PriorityQueue<String> destinations = ticketsMap.get(source);
			while(!destinations.isEmpty()) {
				dfs3(ticketsMap, result, destinations.poll());
			}
		}
		result.add(0, source);
	}

	public static void dfs2(Map<String, PriorityQueue<String>> ticketsMap, List<String> result, String source) {
		while(ticketsMap.containsKey(source) && !ticketsMap.get(source).isEmpty()) {
			PriorityQueue<String> destinations = ticketsMap.get(source);
			dfs2(ticketsMap, result, destinations.poll());
		}
		result.add(0,source);
	}
}