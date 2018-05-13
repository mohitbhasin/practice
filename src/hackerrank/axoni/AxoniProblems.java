package hackerrank.axoni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AxoniProblems {
	public static void main(String args[]) {
//		System.out.println("solution"+root(100));
		int a = 3;
		int b = 4;
		
		int[] arr = {1,2,3,8,5};
		
		System.out.println(reductionCost(arr));
		
	}
	
//	K difference - arrays with integers, k is integer
	// find how many possible difference equal to k of two integer are possible 
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
	
	//Array Reduction => given array of integer, elements are move at a cost from array.
	//remove two elements, add sum of them at the back of array, find the reduciton 
	static int reductionCost(int[] num) {
		int result=0;
		Arrays.sort(num);
		List<Integer> list = new ArrayList<Integer>();
		for (int i : num)
		{
		   list.add(i);
		}
		while(list.size()>1) {
			System.out.println(list);
			int a= (int) list.get(0);
			int b= (int) list.get(1);
			System.out.println(a+" "+b);
			int sum = a+b;
			System.out.println("sum is "+ sum);
			list.remove(0);
			list.remove(0);
			list.add(sum);
			result = result + sum;
			//I missed below step in submission to Axoni
			Collections.sort(list);
		}
		
		return result;
		
	}
}
