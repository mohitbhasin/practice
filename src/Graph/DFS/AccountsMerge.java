import java.util.*;

class AccountsMerge {
    public static void main(String args[]) {
        List<List<String>> accounts = new ArrayList<>();
        // accounts.add(Arrays.asList(new String[]{"John","johnsmith@mail.com","john_newyork@mail.com"}));
        // accounts.add(Arrays.asList(new String[]{"John","johnsmith@mail.com","john00@mail.com"}));
        // accounts.add(Arrays.asList(new String[]{"John","johnnybravo@mail.com"}));
        accounts.add(Arrays.asList(new String[]{"John","johnsmith@mail.com","john_newyork@mail.com","john00@mail.com"}));
        accounts.add(Arrays.asList(new String[]{"John","john00@mail.com","john123@mail.com"}));
        accounts.add(Arrays.asList(new String[]{"John","johnnybravo@mail.com"}));

        System.out.println(accountsMerge(accounts));
        System.out.println("--------------");
        System.out.println(accountsMerge_Alt(accounts));
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> adjList = new HashMap<>();
        
        for(List<String> account : accounts) {
            String firstEmail = account.get(1);
            for(int i=2; i<account.size(); i++) {
                if(!adjList.containsKey(firstEmail)) {
                    adjList.put(firstEmail, new ArrayList<>());
                }
                String anotherEmail = account.get(i);
                adjList.get(firstEmail).add(anotherEmail);
                if(!adjList.containsKey(anotherEmail)) {
                    adjList.put(anotherEmail, new ArrayList<>());
                }
                adjList.get(anotherEmail).add(firstEmail);
            }
        }
        List<List<String>> result = new ArrayList<>();
        Set<String> visitedEmails = new HashSet<>();
        
        for(List<String> account: accounts) {
            if(!visitedEmails.contains(account.get(1))) {
                List<String> curr = new ArrayList<>();
                dfs(account.get(1), curr, adjList, visitedEmails);
                Collections.sort(curr);
                curr.add(0, account.get(0));
                result.add(curr);
            }
        }
        return result;
    }
    
    public static void dfs(String email, List<String> curr, Map<String, List<String>> adjList, Set<String> visited) {
        if(visited.contains(email)) return;
        visited.add(email);
        curr.add(email);
        if(!adjList.containsKey(email)) return;
        for(String nextEmail: adjList.get(email)) {
            dfs(nextEmail, curr, adjList, visited);
        }
    }

    public static List<List<String>> accountsMerge_Alt(List<List<String>> accounts) {
        Map<String, List<String>> adjList = new HashMap<>();
        
        for(List<String> account: accounts) {
            String first = account.get(1);
            adjList.putIfAbsent(first, new ArrayList<>());
            for(int i=2; i<account.size(); i++) {
                String second = account.get(i);
                adjList.putIfAbsent(second, new ArrayList<>());
                adjList.get(second).add(first);
                adjList.get(first).add(second);
            }
        }
        Set<String> globalVisited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        
        for(List<String> account: accounts) {
            List<String> list = new ArrayList<>();
            dfs(account.get(1), list, globalVisited, adjList);
            if(!list.isEmpty()) {
                Collections.sort(list);
                list.add(0, account.get(0));
                result.add(list);
            }
        }
        return result;
    }
    
    public static void dfs(String email, List<String> list, Set<String> globalVisited, Map<String, List<String>> adjList) {
        if(globalVisited.contains(email)) return;
        list.add(email);
        globalVisited.add(email);
        for(String next: adjList.get(email)) {
            dfs(next, list, globalVisited, adjList);
        }
    }
}