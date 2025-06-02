class GasStation {
	public static void main(String args[]) {
		int[][] gasArr = {
            {1,2,3,4,5},
            {1,1,1,1,10},
            {2,3,4}
		};
		int[][] costArr = {
            {3,4,5,1,2},
            {2,2,1,3,1},
            {3,4,3}
		};

		for(int i=0; i<gasArr.length; i++) {
			// System.out.println(gasStationJourney_bf(gasArr[i], costArr[i]));
			System.out.println(gasStationJourney(gasArr[i], costArr[i]));
		}
	}

	public static int gasStationJourney(int[] gas, int[] cost) {
		int totalGas = 0;
		int totalCost = 0;
		for(int i=0; i<gas.length; i++) {
		   totalGas+=gas[i];
		   totalCost+=cost[i];
		}
		if(totalGas<totalCost) return -1;

		int currGas = 0;
		int startIndex = 0;
		for(int i=0; i<gas.length; i++) {
		   currGas+=gas[i];
		   currGas-=cost[i];
		   if(currGas<0) {
		       currGas=0;
		       startIndex=i+1;
		   }
		}
		return startIndex;
	}

	public static int gasStationJourney_bf(int[] gas, int[] cost) {
       for(int i=0; i<gas.length; i++) {
           int index = i;
           int count = 0;
           int available = 0;
           while(count<gas.length) {
               available = available+gas[index];
               available = available-cost[index];
               if(available<0) {
                   break;
               }
               count++;
               if(index==gas.length-1) {
                   index=0;
               } else {
                   index++;
               }
           }
           if(available>=0 && count==gas.length) return index;
       }
       return -1;
	}
}