import java.util.*;

class EarliestMomentWhenEveryoneBecomeFriends {
	public static void main(String args[]) {
		int[][] logs = {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
		int n = 6;
		System.out.println("--"+earliestAcq(logs, n));
	}

	public static int earliestAcq(int[][] logs, int n) {
        root = new int[n];
        set = new HashSet<>();
        for(int i=0; i<n; i++) {
            root[i]=i;
            set.add(i);
        }
        
        Arrays.sort(logs, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });

        for(int[] log: logs) System.out.print(log[0]+", ");
        
        for(int[] log: logs) {
            quickUnion(log[1], log[2]);
            if(set.size()==1) return log[0];
        }
        return -1;
    }
    
    static int[] root;
    static Set<Integer> set;
    
    public static int find(int x) {
        while(x!=root[x]) {
            set.remove(x);
            x=root[x];
        }
        return x;
    }
    
    public static void quickUnion(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);
        root[root_y] = root_x;
    }
}