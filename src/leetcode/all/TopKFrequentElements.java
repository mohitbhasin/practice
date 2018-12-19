package leetcode.all;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	public static void main(String args[]) {
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		System.out.println(solution(nums, k));
	}
	
	public static List<Integer> solution(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i : nums) {
			if(!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i)+1);
			}
		}
		
		PriorityQueue<Pair> heap = new PriorityQueue<Pair>();
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			Pair pair = new Pair(entry.getKey(), entry.getValue());
			heap.offer(pair);
			if(heap.size()>k) {
				heap.poll();
			}
		}
		
		List<Integer> result = new ArrayList<>();
		
		while(heap.size()>0) {
			result.add(heap.poll().num);
		}
		Collections.reverse(result);
		return result;
	}
	
}

class Pair implements Comparable<Pair>{
	int num;
	int count;
	public Pair(int num, int count) {
		this.num = num;
		this.count = count;
	}
	@Override
	public int compareTo(Pair o) {
		return this.count - o.count;
	}
}
