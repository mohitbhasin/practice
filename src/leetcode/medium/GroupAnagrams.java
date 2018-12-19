package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]

public class GroupAnagrams {
	public static void main(String args[]) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		List<List<String>> result = groupAnagrams(strs);
		
		System.out.println("----> "+result);
	}
	
	
	 public static List<List<String>> groupAnagrams(String[] strs) {
		 List<List<String>> resultingLists = new ArrayList<List<String>>();
		 List<String> list;
		 HashMap<String, List<String>> map = new HashMap<>();
		 String tempString;
		 for(String s: strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			tempString = String.valueOf(chars);
			if(!map.containsKey(tempString)) {
				list = new ArrayList<String>();
				list.add(s);
				map.put(tempString, list);
			} else {
				list = map.get(tempString);
				list.add(s);
				map.put(tempString, list);
			}
		 }
		 map.forEach((key, value) -> resultingLists.add(value));
		 return resultingLists;
	    }
	
}
