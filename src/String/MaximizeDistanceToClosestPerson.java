import java.util.*;	

class MaximizeDistanceToClosestPerson {
	public static void main(String args[]) {
		List<int[]> seatsList = new ArrayList<>();
		seatsList.add(new int[]{1,0,0,0,1,0,1});
		seatsList.add(new int[]{1,0,0,0});
		seatsList.add(new int[]{0,1});

		for(int[] seats: seatsList) {
			System.out.println(maxDistToClosest(seats));
		}
	}

	public static int maxDistToClosest(int[] seats) {
        int l = -1;
        int r = -1;
        int max = 0;
        
        for(int i=0; i<seats.length; i++) {
            if(seats[i]==1) {
                if(l==-1) {
                    l=i;
                    max=l;
                } else {
                    r=i;
                    max=Math.max(max, (r-l)/2);
                    l=r;
                }
            }
        }
        
        if(r==-1) {
            max=Math.max(max, Math.max(l, seats.length-1-l));
        } else {
            max=Math.max(max, seats.length-1-r);
        }
        return max;
    }
}