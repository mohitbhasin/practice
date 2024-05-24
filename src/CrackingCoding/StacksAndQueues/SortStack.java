import java.util.*;

class SortStack {
	public static void main(String args[]) {
		Stack<Integer> s1 = new Stack<>();
		s1.push(7);
		s1.push(10);
		s1.push(1);
		s1.push(12);
		s1.push(8);
		s1.push(5);
		s1.push(3);
		sort(s1);
		System.out.println(s1);
	}

	public static void sort(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<>();

		while(!s1.isEmpty()) {
			int temp=s1.pop();
			if(!s2.isEmpty() && temp>s2.peek()) {
				s1.push(s2.pop());
				s1.push(temp);
			} else {
				s2.push(temp);	
			}
		}

		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
}