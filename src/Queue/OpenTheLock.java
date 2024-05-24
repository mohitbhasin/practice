import java.util.*;

class OpenTheLock {
	public static void main(String args[]) {
		String[] deadends = {"0201","0101","0102","1212","2002"};
		String target = "0202";

		System.out.println(openLock(deadends, target));
	}

	public static int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for(String deadend: deadends) set.add(deadend);
        Queue<String> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        que.offer("0000");
        int count = 0;
        
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i=0; i<size; i++) {
                String curr = que.poll();
                System.out.println(curr);
                if(visited.contains(curr)) continue;
                visited.add(curr);
                if(curr==target) return count;
                StringBuilder sb = new StringBuilder(curr);
                for(int j=0; j<4; j++) {
                    int val = sb.charAt(j)-'0';
                    String nei;
                    sb.setCharAt(j, (char) ('0' +( val==9 ? 0 : val+1)));
                    nei = sb.toString();
                    if(!set.contains(nei))
                    que.offer(nei);
                    sb.setCharAt(j, (char) ('0' +(val==0 ? 9 : val-1)));
                    nei = sb.toString();
                    if(!set.contains(nei))
                    que.offer(nei);
                }
            }
            count++;
        }
        return -1;
    }

	public static int openLock2(String[] deadends, String target) {
		Queue<String> que = new LinkedList<>();
		Set<String> deadSet = new HashSet<>();
		for(String deadend: deadends) deadSet.add(deadend);
		Set<String> visited = new HashSet<>();
		visited.add("0000");

		que.offer("0000");
		que.offer(null);
		int depth=0;
		while(!que.isEmpty()) {
			String curr = que.poll();
			if(curr==null) {
				depth++;
				if(que.peek()!=null) {
					que.offer(null);
				}
			}
			else if(curr.equals(target)) return depth;
			else if(!deadSet.contains(curr)) {
				for(int i=0; i<4; i++) {
					for(int dir=-1; dir<=1; dir+=2) {
						int val = (curr.charAt(i) - '0' + dir + 10) % 10;
						String nei = curr.substring(0, i) + val + curr.substring(i+1, 4);
						if(!visited.contains(nei)) {
							que.offer(nei);
							visited.add(nei);
						}
					}
				}
			}
		}
		return -1;
	}
}