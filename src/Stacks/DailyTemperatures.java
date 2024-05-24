import java.util.*;

class DailyTemperatures {
	public static void main(String args[]) {
		int[] temperatures = {73,74,75,71,69,72,76,73}; 
					  //result 1, 1, 4, 2, 1, 1, 0, 0
        int[] result = new int[temperatures.length];
		// result = dailyTemperatures(temperatures);

		// for(int i: result) {
		// 	System.out.print(i+", ");
		// }

        // System.out.println();
        result = findDays(temperatures);

        for(int i: result) {
            System.out.print(i+", ");
        }

	}


	public static int[] dailyTemperatures(int[] temperatures) {
    	int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack();
        stack.push(0);
        
        for(int i=1; i<temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]) {
            	for(int ele: stack) {
            		System.out.print(temperatures[ele]+", ");
            	}
            	System.out.println();
                result[stack.peek()] = i-stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    //concise
    public static int[] findDays(int[] temp) {
        Stack<Integer> stack = new Stack();
        int[] answer = new int[temp.length];

        for(int i=0; i<temp.length; i++) {          
            while(!stack.isEmpty() && temp[stack.peek()]<temp[i]) {
                int index = stack.pop();
                answer[index]=i - index;
            }
            stack.push(i);
        }
        System.out.println(stack);
        return answer;
    }
}