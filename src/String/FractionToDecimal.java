import java.util.*;

class FractionToDecimal {
	public static void main(String args[]) {
		System.out.println(fractionToDecimal(1,2));
		// System.out.println(fractionToDecimal(2,1));
		// System.out.println(fractionToDecimal(4,333));
		// System.out.println(fractionToDecimal(22,7));
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		int x = numerator;
		int y = denominator;
		StringBuilder result = new StringBuilder();
		Map<Integer, Integer> map = new HashMap<>();
		int count = 2;
		map.put(x, count);
		if(x<y) {
			result.append("0.");
			x=(x%y)*10;
		} else {
			result.append(x/y);
			if(x%y>0) {
				result.append(".");
			}
			x=(x%y)*10;
		}

		while(x>0) {
			result.append(""+x/y);
			x=(x%y);
			System.out.println(result + " keys:" + map.keySet() + " X="+x);
			if(map.containsKey(x)) {
				if(result.charAt(map.get(x))!='0') {
					result.replace(result.length()-1, result.length(), ")");
				} else {
					result.append(")");	
				}
				result.insert(map.get(x), "(");
				break;
			}
			map.put(x, count++);
			x*=10;
		}

		return result.toString();
	}
}