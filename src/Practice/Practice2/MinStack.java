import java.util.List;
import java.util.ArrayList;

class MinStack {
	public static void main(String args[]) {
		int[] nums = {3, 1, 21, 2, -1, 2, -23, 1, 34};

		Stack s = new Stack();
		s.push(3);
		System.out.println(s.min());
		s.push(1);
		System.out.println(s.min());
		s.push(21);
		s.push(2);
		System.out.println(s.min());
		s.push(-1);
		System.out.println(s.min());
		s.push(-23);
		System.out.println(s.min());
		System.out.println(s.pop());
		System.out.println(s.min());
	}

}

class Stack {
	List<StackData> data;

	Stack() {
		data = new ArrayList<StackData>();
	}

	public void push(int num) {
		StackData sd;
		if(data.size()==0) {
			sd = new StackData(num, num);
		}
		else {
			int temp = data.get(data.size()-1).min;
			sd = new StackData(num, Integer.min(num, temp));
		}
		data.add(sd);
	}

	public int pop() {
		if(data.size()==0) {
			return Integer.MIN_VALUE;
		}

		return data.remove(data.size()-1).data;
	}

	public int min() {
		return data.get(data.size()-1).min;
	}

}

class StackData {
	int data;
	int min;
	StackData(int data, int min) {
		this.data=data;
		this.min=min;
	}
}