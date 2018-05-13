import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Test {
	public static void main(String args[]) {
//		System.out.println("solution"+root(100));
		int a = 3;
		int b = 4;
		
		int[] arr = {1,2,3};
		
		System.out.println(reductionCost(arr));
		
	}
	
//	/////
	static int kDifference(int[] a, int k) {
	    int count = 0;
		for (int i = 0; i < a.length; i++) 
		{
		for (int j = i + 1; j < a.length; j++)
		if (a[i] - a[j] == k | a[j] - a[i] == k)
		count++;
		}
		return count;
		}

	    
	//custom sorted array
	// sort array so that even nums are first and odd nums are at the end.
	//return min num swap required
	//if a[] = {23,4,6,7}
	//valid arrays are:
	// [4,6,7,23]
	// [6,4,7,23]
	// [4,6,23,7]
	// [4,6,7,23]
	//mins swaps are 2 
	
	static int moves(int[] a) {
		
		
		return 0;

    }
		
	
	///////
	
	
	static int reductionCost(int[] num) {
		int result=0;
		Arrays.sort(num);
		List<Integer> list = new ArrayList<Integer>();
		for (int i : num)
		{
		   list.add(i);
		}
		System.out.println(list);
		while(list.size()>1) {
			int a= (int) list.get(0);
			int b= (int) list.get(1);
			System.out.println(a+" "+b);
			int sum = a+b;
			System.out.println("sum is "+ sum);
			list.remove(0);
			System.out.println(list);
			list.remove(0);
			System.out.println(list);
			list.add(sum);
			result = result + sum;
			
		
		}
		
		return result;
		
	}
	
	
	
	public static float root(int number) { 
		float root = 0.0f; 
		float square = root;
		while (square < number) 
		{ 
			System.out.println("running for "+square);
			root++; 
			square = root * root; 
		} 
		return root; 
		}
	
	public static int powerSum(double X, int P, double N) {
		System.out.println("X= "+X+" P= "+P+"\tN= "+N);
	    double i_pow = Math.pow(N,P);
	    System.out.println("Power Value -> "+i_pow);
	    if (i_pow > X) {
	    	System.out.println("power greater than X("+X+") returning 0. Pow Value--> " +i_pow);
	        return 0;
	    }
	    else if (i_pow == X) {
	    	System.out.println("power equals X("+X+") returning 1. Pow Value--> " +i_pow);
	        return 1;
	    }
	      // subproblem
	    System.out.println("X-i_pow --> " +X +" - "+i_pow + " = "+ (X-i_pow));
	    return powerSum(X,P,N+1) + powerSum(X-i_pow,P,N+1);
	}
}