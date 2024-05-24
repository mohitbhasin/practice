import java.util.*;

class TimeNeededToInformAllEmployees {
	public static void main(String args[]) {
		// int n = 15;
		// int headID = 0;
		// int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
		// int[] informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
		// int n = 6;
		// int headID = 2;
		// int[] manager = {2,2,-1,2,2,2};
		// int[] informTime = {0,0,1,0,0,0};
		int n = 11;
		int headID = 4;
		int[] manager = {5,9,6,10,-1,8,9,1,9,3,4};
		int[] informTime = {0,213,0,253,686,170,975,0,261,309,337};
		System.out.println(numOfMinutes(n, headID, manager, informTime));
	}


	 public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer,List<Integer>> managerMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            managerMap.put(i, new ArrayList<>());
        }
        for(int i=0; i<n; i++) {
            if(manager[i]!=-1) {
                managerMap.get(manager[i]).add(i);
            }
        }
        return dfs(managerMap, informTime, headID, informTime[headID]);
    }
    
    public static int dfs(Map<Integer,List<Integer>> managerMap, int[] informTime, int currEmp, int currTime) {
        if(managerMap.get(currEmp).isEmpty()) {
            return currTime;
        }
        int maxTime = 0;
        for(int subEmp: managerMap.get(currEmp)) {
            maxTime = Math.max(maxTime, dfs(managerMap, informTime, subEmp, currTime + informTime[subEmp]));
        }
        return maxTime;
    }
		// Not Accurate
	 public static int numOfMinutesBFS(int n, int headID, int[] manager, int[] informTime) {
        int count=informTime[headID];
        HashMap<Integer,List<Integer>> managerMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            managerMap.put(i, new ArrayList<>());
        }
        for(int i=0; i<n; i++) {
            if(manager[i]!=-1) {
                managerMap.get(manager[i]).add(i);
            }
        }
        List<Integer> tempList;
        Queue<List<Integer>> que = new LinkedList<>();
        que.offer(managerMap.get(headID));
        int size=0;
        while(!que.isEmpty()) {
        	size=que.size();
        	int maxTime=0;
        	for(int i=0; i<size; i++) {
        		tempList = que.poll();
	            for(int emp: tempList) {
	                maxTime = Math.max(maxTime, informTime[emp]);
	                que.offer(managerMap.get(emp));
	            }
        	}
        	System.out.println(maxTime);
            count+=maxTime;
        }
        return count;       
    }
}