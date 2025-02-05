import java.util.*;

class HappyNumbers {
	public static void main(String args[]) {
	   System.out.println(isHappyNumber(188));
        System.out.println(isHappyNumber(10));
        System.out.println(isHappy_withHashSet(188));
        System.out.println(isHappy_withHashSet(10));
	}

    // Time complexity O(log n), where n is the number itself. Space complexity O(1)
    public static boolean isHappyNumber(int n) {
      int slowPointer = n;
      int fastPointer = sumOfSquares(n);
      
      while(fastPointer!=1) {
        slowPointer=sumOfSquares(slowPointer);
        fastPointer=sumOfSquares(fastPointer);
        fastPointer=sumOfSquares(fastPointer);
        if(slowPointer==fastPointer) return false;
      }
      
      return true;
    }
    
    public static int sumOfSquares(int n) {
      int sum = 0;
      while(n>0) {
        sum+=Math.pow(n%10,2);
        n/=10;
      }
      return sum;
    }

    // Naive approach. Time complexity O(log n), Space complexity O(log n)
	public static boolean isHappy_withHashSet(int n) {
		Set<Integer> set = new HashSet<>();
        
        while(n>0) {
            int sum = 0;
            while(n>0) {
                sum+=Math.pow(n%10, 2);
                n/=10;
            }
            if(sum==1) return true;
            n=sum;
            if(set.contains(n)) return false;
            set.add(n);
        }
        return false;
    }
}