import java.util.*;

class Solution2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int numTest = scanner.nextInt();
        Queue<String> testCases = new LinkedList<>();
        for(int i=0; i<numTest; i++) {
            testCases.offer(scanner.next());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=numTest; i++) {
            stringSet = new HashSet<>();
            String word = testCases.poll();
            minString = word;
            generateWords(word, 0);
            System.out.println("Case #"+i+": "+minString);

        }
    }

    static Set<String> stringSet;
    static String minString;

    public static void generateWords(String s, int index) {
        if(index>=s.length()) return;
        String temp = null;
        for(int i=index; i<s.length()-1; i++) {
            StringBuilder sb = new StringBuilder(s);
            sb.insert(i+1, s.charAt(i));
            temp = sb.toString();
            if(!stringSet.contains(temp)) {
                stringSet.add(temp);
                findSmallestString(temp);
                generateWords(temp, i+2);
            }
        }
    }

    public static void findSmallestString(String curr) {
        int index = 0;
        while(index<minString.length() && index<curr.length()) {
            if(minString.charAt(index)<curr.charAt(index)) {
                break;
            }
            if(minString.charAt(index)>curr.charAt(index)){
                minString = curr;
                break;
            }
            index++;
        }
    }
}
