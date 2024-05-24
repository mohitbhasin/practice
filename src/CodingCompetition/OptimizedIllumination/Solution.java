import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Solution obj = new Solution();
        Scanner scanner = new Scanner(System.in);
        int numTest = scanner.nextInt();
        for(int testCase=1; testCase<=numTest; testCase++) {
            int M = scanner.nextInt();
            int R = scanner.nextInt();
            int N = scanner.nextInt();
            Queue<Integer> meters = new LinkedList<>();
            for(int i=0; i<N; i++) {
                meters.offer(scanner.nextInt());
            }
            int result = obj.optimizedIlluminate(M, R, meters);
            String output;
            if(result==-1) {
                output = "IMPOSSIBLE";
            } else {
                output = String.valueOf(result);
            }
            System.out.println("Case #" + testCase + ": " + output);
        }
    }

    public static int optimizedIlluminate(int freeway, int radius, Queue<Integer> meters) {
        int meterReq = radius;
        int count=0;
        while(!meters.isEmpty()) {
            int meterLoc = -1;
            while(!meters.isEmpty() && meters.peek()<=meterReq) {
                meterLoc = meters.poll();
            }
            if(meterLoc==-1) return -1;
            count++;
            if((Integer.MAX_VALUE - (2*radius))<meterReq) return count;
            meterReq=meterLoc+radius;
            if(meterReq>=freeway) return count;
            meterReq+=radius;
        }
        return meterReq-radius>=freeway ? count : -1;
    }

    public static void test() {
         int freeway = 10;
         int radius = 2;
         int[] meters = new int[]{2,3,4,6,8};
         Queue<Integer> que = new LinkedList<>();
         for(int meter: meters) {
             que.offer(meter);
         }
         System.out.println(optimizedIlluminate(freeway, radius, que));
    }
}
