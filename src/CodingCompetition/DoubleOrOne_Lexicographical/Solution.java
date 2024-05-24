import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int numTest = scanner.nextInt();
        Queue<String> testCases = new LinkedList<>();
        for(int i=0; i<numTest; i++) {
            testCases.offer(scanner.next());
        }
        for(int i=1; i<=numTest; i++) {
            System.out.print("Case #"+i+": ");
            findSmallestString(testCases.poll());

        }
    }

    public static void findSmallestString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i=0; i<s.length(); i++) {
            if(i+1!=s.length()) {
                if(s.charAt(i)==s.charAt(i+1)) {
                    count++;
                } else {
                    if(s.charAt(i)<s.charAt(i+1)) {
                        while(count>0) {
                            sb.append(s.charAt(i));
                            count--;
                        }
                        count=1;
                    }
                }
            }
            sb.append(s.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
