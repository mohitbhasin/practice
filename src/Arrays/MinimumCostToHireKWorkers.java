import java.util.*;

class MinimumCostToHireKWorkers {
	public static void main(String args[]) {
		int[] quality = {3,1,10,10,1}; int[] wage = {4,8,2,2,7}; int k = 3;
		// int[] quality = {4,4,4,5}; int[] wage = {13,12,13,12}; int k = 2;
		System.out.println(mincostToHireWorkers(quality, wage, k));
	}


	public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        Pair[] ratios = new Pair[quality.length];
        
        for(int i=0; i<quality.length; i++) {
            Pair pair = new Pair((double) wage[i]/quality[i], quality[i]);
            ratios[i]=pair;
        }
        
        Arrays.sort(ratios, (a, b) -> (int) (a.ratio<b.ratio ? -1 : 1));
        for(Pair pair: ratios) System.out.print(pair.ratio+", ");
        System.out.println("---");
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;

        for(int i=0; i<k; i++) {
        	pq.offer(ratios[i].quality);
        	sum+=ratios[i].quality;
        }

        double pivotRatio = ratios[k].ratio;
        double minCost = pivotRatio*sum;

        System.out.println(minCost);

        for(int pivot=k; pivot<quality.length; pivot++) {
        	pivotRatio = ratios[pivot].ratio;
        	if(!pq.isEmpty() && ratios[pivot].quality<pq.peek()) {
        		sum-=pq.poll();
        		pq.offer(ratios[pivot].quality);
        		sum+=ratios[pivot].quality;
        		double cost = ratios[pivot].ratio * sum;
        		minCost = Math.min(minCost, cost);
        	}
        }

        return minCost;
    }

    public static double mincostToHireWorkers_TimeLimitExceeds(int[] quality, int[] wage, int k) {
        Pair[] ratios = new Pair[quality.length];
        
        for(int i=0; i<quality.length; i++) {
            Pair pair = new Pair((double) wage[i]/quality[i], quality[i]);
            ratios[i]=pair;
        }
        
        Arrays.sort(ratios, (a, b) -> (int) (a.ratio<b.ratio ? -1 : 1));
        for(Pair pair: ratios) System.out.print(pair.ratio+", ");
        System.out.println();
        double minCost = Double.MAX_VALUE;
        for(int i=k-1; i<ratios.length; i++) {
            PriorityQueue<Double> pq = new PriorityQueue<>();
            for(int j=0; j<i+1; j++) {
                pq.offer(ratios[i].ratio*ratios[j].quality);
            }
            double sum=0;
            for(int val=0; val<k; val++) {
                sum+=pq.poll();
            }
            minCost = Math.min(minCost, sum);
        }
        return minCost;
    }
}

class Pair {
    double ratio;
    int quality;
    public Pair(double ratio, int quality) {
        this.ratio = ratio;
        this.quality = quality;
    }
}