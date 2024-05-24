class DailyTemperatures {
	//Find number of days the next warmer temperature will happen
	public static void main(String args[]) {
		int[] temperatures = {73,74,75,71,69,72,76,73}; 
					  //result 1, 1, 4, 2, 1, 1, 0, 0
		int[] result = dailyTemperatures(temperatures);

		for(int i: result) {
			System.out.print(i+", ");
		}


	}
	//O(n2) not efficient - using stack is more efficient
	public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        
        for(int i=0; i<temperatures.length-1; i++) {
            for(int j=i+1; j<temperatures.length; j++) {
                if(temperatures[i]<temperatures[j]) {
                    result[i]=j-i;
                    break;
                }
            }
        }
        return result;
    }
}