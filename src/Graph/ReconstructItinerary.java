import java.util.*;

class ReconstructItinerary {
    public static void main(String args[]) {
        // List<List<String>> tickets = new ArrayList();
        // tickets.add(Arrays.asList(new String[]{"MUC","LHR"}));
        // tickets.add(Arrays.asList(new String[]{"JFK","MUC"}));
        // tickets.add(Arrays.asList(new String[]{"SFO","SJC"}));
        // tickets.add(Arrays.asList(new String[]{"LHR","SFO"}));
        List<List<String>> tickets = new ArrayList();
        tickets.add(Arrays.asList(new String[]{"JFK","SFO"}));
        tickets.add(Arrays.asList(new String[]{"JFK","ATL"}));
        tickets.add(Arrays.asList(new String[]{"SFO","ATL"}));
        tickets.add(Arrays.asList(new String[]{"ATL","JFK"}));
        tickets.add(Arrays.asList(new String[]{"ATL","SFO"}));

        System.out.println(findItinerary(tickets));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> map = new HashMap<>();
        
        for(List<String> ticket: tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            
            PriorityQueue<String> pq;
            
            if(!map.containsKey(src)) {
                pq = new PriorityQueue<>();
                pq.offer(dest);
                map.put(src, pq);
            } else {
                map.get(src).offer(dest);
            }
        }

        // for(String key: map.keySet()) {
        //     System.out.println(key+" --> "+map.get(key));
        // }

        List<String> result = new ArrayList<>();

        dfs(map, result, "JFK");

        return result;
    }
    
    public static void dfs(Map<String, PriorityQueue<String>> map, List<String> result, String curr) {
        result.add(curr);
        if(!map.containsKey(curr)) {
            System.out.println(curr + " not present in map");
            return;
        }
        int size = map.get(curr).size();
        for(int i=0; i<size; i++) {
            System.out.println(curr);
            printMap(map);
            String next = map.get(curr).poll();
            if(map.get(curr).size()==0) {
                map.remove(curr);
            }
            dfs(map, result, next);
        }
    }

    public static void printMap(Map<String, PriorityQueue<String>> map) {
        for(String key: map.keySet()) {
            System.out.println(key+" --> "+map.get(key));
        }
    }
}