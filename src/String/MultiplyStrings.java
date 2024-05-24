import java.util.*;

class MultiplyStrings {
	public static void main(String args[]) {
		// String num1 = "2";
		// String num2 = "3";

		// String num1 = "123";
		// String num2 = "456";

		String num1 = "123456789";
		String num2 = "987654321";
		// String num1 = "123456789";
		// String num2 = "2";
		// String num1 = "498828660196";
		// String num2 = "840477629533";

		// String num1 = "123";
		// String num2 = "6";

		// String num1 = "100";
		// String num2 = "12";

		System.out.println(multiply_cleaner(num1, num2));
		// System.out.println(multiplyByOneDigit(num1, num2));
	}

	public static String multiply_cleaner(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        String result = "";
        StringBuilder product;
        String zeros = "";
        for(int i=num2.length()-1; i>=0; i--) {
            product = new StringBuilder();
            int carry=0;
            for(int j=num1.length()-1; j>=0; j--) {
                // important: careful with i and j corresponding to num1 and num2
                int val = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                val+=carry;
                product.insert(0, val%10);
                carry=val/10;
            }
            // check carry if needed to be inserted
            if(carry>0) product.insert(0, carry);
            product.append(zeros);
            zeros+="0";
            result = sum(result, product.toString());
        }
        return result;
    }
    
    public static String sum(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        
        while(i>=0 || j>=0) {
            int val = 0;
            if(i>=0 && j>=0) {
                val = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
                i--;
                j--;
            } else if(i>=0) {
                val = (a.charAt(i) - '0') + carry;
                i--;
            } else {
                val = (b.charAt(j) - '0') + carry;
                j--;
            }
            res.insert(0, val%10);
            carry=val/10;
        }
        
        if(carry>0) res.insert(0, carry);
        return res.toString();
    }

	public static String multiplyByOneDigit(String num1, String num2) {
		if(num1.startsWith("0") || num2.startsWith("0")) return "0";
		
		String sum="0";
		StringBuilder result = new StringBuilder();

		for(int i=num2.length() - 1; i>=0; i--) {
			int num = num2.charAt(i) - '0';
			int carry=0;
			int product=0;
			StringBuilder sb = new StringBuilder();
			for(int j=num1.length() - 1; j>=0; j--) {
				int val = num1.charAt(j) - '0';
				product=num*val+carry;
				sb.append(product%10);
				carry=product/10;
			}
			if(carry!=0) {
				sb.append(carry);
			}
			result.append(sum.charAt(0));
			sum=sum.substring(1,sum.length());
			sum=sumNum(sum, sb.toString());
		}
		result.append(sum);
		result.deleteCharAt(0);
		
		result.reverse();
		return result.toString();
	}

	public static String sumNum(String a, String b) {
		int i=0;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		while(i<a.length() || i<b.length()) {
			int sum;
			if(i<a.length() && i<b.length()) {
				sum = a.charAt(i) - '0' + b.charAt(i) - '0' + carry;
				sb.append(sum%10);
				carry = sum/10;
			} else if(i<a.length()) {
				sum = a.charAt(i) - '0' + carry;
				sb.append(sum%10);
				carry = sum/10;
			} else {
				sum = b.charAt(i) - '0' + carry;
				sb.append(sum%10);
				carry = sum/10;
			}
			i++;
		}

		if(carry==1) {
			sb.append(carry);
		}
		return sb.toString();
	}
}