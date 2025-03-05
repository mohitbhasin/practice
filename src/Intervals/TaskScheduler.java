import java.util.*;

class TaskScheduler {
  public static void main(String args[]) {
    char[][] taskArr = {{'A','B','A','A','B','C'},{'A','A','A','B','B','B'}}; //A,B,C,*,A,B,*,*,A
    int[] nArr = {3,2};
    for(int i=0; i<taskArr.length; i++) {
      System.out.println(leastTime(taskArr[i], nArr[i]));
    }
  }

  public static int leastTime(char[] tasks, int n) {
    Map<Character, Integer> freqMap = new HashMap<>();
    for(char c: tasks) {
      freqMap.putIfAbsent(c, 0);
      freqMap.put(c, 1+freqMap.getOrDefault(c, 0));
    }
    
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
    for(int val: freqMap.values()) {
      pq.offer(val);
    }
    
    int result = 0;
    
    while(!pq.isEmpty()) {
      List<Integer> tempTasks = new ArrayList<>();
      for(int i=0; i<=n; i++) {
        if(!pq.isEmpty()) {
          tempTasks.add(pq.poll());
        }
      }
      //add executed tasks back in the PriorityQueue
      for(int val: tempTasks) {
        val--;
        if(val>0) {
          pq.offer(val);
        }
      }
      // update cycle count. If pq has tasks to execute, add a new slow of n+1
      // otherwise only add last executed task count from tempTasks.size()
      result+= pq.isEmpty() ? tempTasks.size() : n+1;
    }
    return result;
  }
}