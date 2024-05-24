class FacebookInterviewQuestion1 {
	int maxDepth;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        maxDepth = 1;
        dfs(nestedList, map, 1);
        int result = 0;
                        System.out.println(maxDepth);
        for(int key: map.keySet()) {
                System.out.println(key+": "+map.get(key));
            for(int num: map.get(key)) {
                result+=(maxDepth - key + 1) * num;
            }
        }
        return result;
    }
    
    public void dfs(List<NestedInteger> nestedList, Map<Integer, List<Integer>> map, int depth) {
        maxDepth=Math.max(depth, maxDepth);
        for(NestedInteger obj: nestedList) {
            if(!obj.isInteger()) {
                dfs(obj.getList(), map, depth+1);
            } else {
                if(!map.containsKey(depth)) {
                    map.put(depth, new ArrayList<>());
                }
                map.get(depth).add(obj.getInteger());
            }
        }
    }
}