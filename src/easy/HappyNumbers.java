import java.util.*;

class HappyNumbers {
	public static void main(String args[]) {
		System.out.println(isHappy(188));
	}

	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
        while(n%3!=0) {
        	System.out.println(n);
        	int num=0;
            if(n==1) {
                return true; 
            }
            while(n>0) {
                int temp = n%10;
				num+=temp*temp;
                n/=10;
            }
            n=num;
        }
        return false;
    }
}