import java.util.*;

class IntegerToEnglishWords {
	public static void main(String args[]) {
		int[] nums = {0, 1230, 657, 12345, 1234567,1000000000};

		for(int num: nums) System.out.println(numberToWords(num));
	}

    static Map<Integer, String> map = new HashMap<>();
    public static String numberToWords(int num) {
        if(num==0) return "Zero";
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        
        
        StringBuilder sb = new StringBuilder();
        int unit = 0;
        String[] units = {"Thousand","Million","Billion"};
        while(num>0) {
            int curr = num%1000;
            sb.insert(0, hundredConversion(curr));
            num/=1000;
            if(num%1000>0) sb.insert(0, units[unit]+" ");
            unit++;
        }
        return sb.toString().trim();
    }
    
    public static String hundredConversion(int num) {
        StringBuilder sb = new StringBuilder();

        while(num>0) {
            if(num>99) {
                sb.append(map.get(num/100)+" Hundred ");
                num%=100;
            } else if(num>=20) {
                sb.append(map.get(num-num%10) + " ");
                num%=10;
            } else {
                sb.append(map.get(num) + " ");
                break;
            }
        }

        return sb.toString();
    }
}