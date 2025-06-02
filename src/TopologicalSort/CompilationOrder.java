import java.util.*;

class CompilationOrder {
	public static void main(String args[]) {
		List<List<List<Character>>> dependenciesList = new ArrayList<>();
		List<List<Character>> l1 = new ArrayList<>();
		l1.add(Arrays.asList('B','A'));
		l1.add(Arrays.asList('C','A'));
		l1.add(Arrays.asList('D','C'));
		l1.add(Arrays.asList('E','D'));
		l1.add(Arrays.asList('E','B'));
		dependenciesList.add(l1);

		List<List<Character>> l2 = new ArrayList<>();
		l2.add(Arrays.asList('B','A'));
		l2.add(Arrays.asList('C','A'));
		l2.add(Arrays.asList('D','B'));
		l2.add(Arrays.asList('E','B'));
		l2.add(Arrays.asList('E','D'));
		l2.add(Arrays.asList('E','C'));
		l2.add(Arrays.asList('F','D'));
		l2.add(Arrays.asList('F','E'));
		l2.add(Arrays.asList('F','C'));
		dependenciesList.add(l2);

		List<List<Character>> l3 = new ArrayList<>();
		l3.add(Arrays.asList('A','B'));
		l3.add(Arrays.asList('B','A'));
		dependenciesList.add(l3);

		List<List<Character>> l4 = new ArrayList<>();
		l4.add(Arrays.asList('B','C'));
		l4.add(Arrays.asList('C','A'));
		l4.add(Arrays.asList('A','F'));
		dependenciesList.add(l4);

		for(int i=0; i<dependenciesList.size(); i++) {
			System.out.println(findCompilationOrder(dependenciesList.get(i)));
		}
	}


	public static List<Character> findCompilationOrder(List<List<Character>> dependencies) {
        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, Integer> indegreeMap = new HashMap<>();
        
        for(List<Character> dependency: dependencies) {
            char child = dependency.get(0);
            char parent = dependency.get(1);
            map.putIfAbsent(parent, new ArrayList<>());
            map.get(parent).add(child);
            indegreeMap.put(child, indegreeMap.getOrDefault(child, 0)+1);
            indegreeMap.putIfAbsent(parent, 0);
        }
        
        Queue<Character> que = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry: indegreeMap.entrySet()) {
            if(entry.getValue()==0) {
                que.offer(entry.getKey());
            }
        }
        
        // build the result
        List<Character> result = new ArrayList<>();
        while(!que.isEmpty()) {
            char curr = que.poll();
            result.add(curr);
            if(!map.containsKey(curr)) continue;
            for(char neigh: map.get(curr)) {
                indegreeMap.put(neigh, indegreeMap.get(neigh) - 1);
                if(indegreeMap.get(neigh)==0) {
                    que.offer(neigh);
                }
            }
        }
        if(result.size()!=indegreeMap.size()) {
            return new ArrayList<>();
        }
        return result;
    }
}