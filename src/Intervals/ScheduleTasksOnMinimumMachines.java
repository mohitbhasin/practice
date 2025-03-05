import java.util.*;

class ScheduleTasksOnMinimumMachines {
	public static void main(String args[]) {
		List<int[][]> tasksList = new ArrayList<>();
		tasksList.add(new int[][]{{1,7}, {8,13}, {5,6}, {10,14}, {6,7}}); // output = 2
		tasksList.add(new int[][]{{1,4},{1,4},{1,4},{1,4}}); // output = 4
		tasksList.add(new int[][]{{1,7}, {8,13}, {19,26}, {13,15}, {16,18}}); // output = 1

		for(int[][] tasks: tasksList) {
			System.out.println(minimumMachines(tasks));
		}
	}

	public static int minimumMachines(int[][] tasks) {
      Arrays.sort(tasks, (a,b) -> a[0] - b[0]);
      PriorityQueue<Integer> machines = new PriorityQueue<Integer>();
      int maxMachines = 0;
      for(int i=0; i<tasks.length; i++) {
        int startTime = tasks[i][0];
        int endTime = tasks[i][1];
        while(!machines.isEmpty() && startTime>=machines.peek()) {
          machines.poll();
        }
        machines.offer(endTime);
        maxMachines=Math.max(maxMachines, machines.size());
      }
      return maxMachines;
    }
}