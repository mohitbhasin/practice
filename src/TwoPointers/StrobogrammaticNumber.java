import java.util.*;

class StrobogrammaticNumber {
	public static void main(String args[]) {
		String[] nums = {"818", "69", "619", "962", "123"};

		for(String num: nums) {
			System.out.println(isStrobogrammatic(num));
		}
	}

	public static boolean isStrobogrammatic (String num) {
      Map<Character, Character> map = new HashMap<>();
      map.put('0','0');
      map.put('1','1');
      map.put('6','9');
      map.put('8','8');
      map.put('9','6');
      
      int left=0;
      int right=num.length()-1;
      
      while(left<right) {
        char a = num.charAt(left++);
        char b = num.charAt(right--);
        
        if(!map.containsKey(a) || map.get(a)!=b) return false;
      }
      return true;
    }
}