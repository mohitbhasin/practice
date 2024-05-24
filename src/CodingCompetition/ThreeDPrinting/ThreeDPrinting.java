import java.util.*;

public class ThreeDPrinting {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        Queue<int[][]> testQue = new LinkedList<>();

        for(int test=1; test<=testCount; test++) {
            // getting each test case
            int[][] testCase = new int[3][4];
            for(int printer=0; printer<3; printer++) {
                int[] inks = new int[4];
                inks[0] = scanner.nextInt();
                inks[1] = scanner.nextInt();
                inks[2] = scanner.nextInt();
                inks[3] = scanner.nextInt();
                testCase[printer] = inks;
            }
            testQue.add(testCase);
        }

        for(int test=1; test<=testCount; test++) {
            System.out.print("Case #"+test+": ");
            printInk(testQue.poll());
        }

    }

    public static void printInk(int[][] printersInkArr) {
        List<Integer> output = new ArrayList<>();
        int sum=0;
        int total=1000000;

        for(int i=0; i<printersInkArr[0].length; i++) {
            int amountToConsider = Math.min(printersInkArr[0][i], Math.min(printersInkArr[1][i], printersInkArr[2][i]));
            if(sum+amountToConsider > total) {
                amountToConsider=total - sum;
            }
            sum+=amountToConsider;
            output.add(amountToConsider);
        }
        StringBuilder sb = new StringBuilder();

        if(sum<total) {
            System.out.println("IMPOSSIBLE");
            return;
        }


        for(int amount: output) {
            sb.append(amount+" ");
        }
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb.toString());
    }
}
