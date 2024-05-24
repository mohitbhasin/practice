import java.util.List;
import java.util.ArrayList;

class GenerateAllParentheses {
	public static void main(String args[]) {
		List<String> list = new ArrayList<String>();
		GenerateAllParentheses g = new GenerateAllParentheses();
		g.generate2(8, list, "", 0);
		System.out.println(list);
	}

	public void generate2(int n, List<String> list, String curr, int balance) {
		if(curr.length()==n) {
			if(balance==0) {
				list.add(curr);;
			}
			return;
		}
		if(balance<0) {
			return;
		}
		generate2(n, list, curr+'(', balance+1);
		generate2(n, list, curr+')', balance-1);
	}

	public void generate(int n, List<String> list, String curr) {
		if(curr.length()==n) {
			if(isValid(curr)) {
				list.add(curr);
			}
			return;
		}
		generate(n, list, curr+'(');
		generate(n, list, curr+')');
	}

	public boolean isValid(String s) {
		int count=0;
		for(char c: s.toCharArray()) {
			if(c=='(') {
				++count;
			} else if(count<1) {
				return false;
			} else {
				--count;
			}
		}
		return count==0;
	}
}