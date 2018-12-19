package leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class KthLargestElementInArray {
	public static void main(String args[]) {
		int[] nums = {3,2,3,1,2,4,5,5,6};
//		System.out.println(kthLargestElements(nums, 2));
//		kthLargestElementsUsingHeap(nums,2);
		
		
		System.out.println(kthLargestElementsUsingHeap(nums,5));
	}
	
	public static int kthLargestElements(int[] nums, int k){
		Arrays.sort(nums);
		List<Integer> l = new ArrayList<Integer>();
		return l.get(k-1);
	}
	
	public static int kthLargestElementsUsingHeap(int[] nums, int k){
		PriorityQueue<Integer> p = new PriorityQueue<>(k);
		for(int i: nums) {
			p.offer(i);
			
			if(p.size()>k) {
				p.poll();
			}
		}
		System.out.println(p);
		return p.peek();
	}
}
