package problems;

public class mergeSortedList {
	public static void main(String args[]) {
		LinkedNode l1 = new LinkedNode(0);
		LinkedNode l2 = new LinkedNode(0);
		int a = 3;
		int b = 3;
		
		System.out.println("result = "+(a<b) );
		
	}
	
	static LinkedNode merge(LinkedNode l1, LinkedNode l2) {
		LinkedNode l3=null;
		
		while(l1!=null||l2!=null) {
			if(l1.getData()<l2.getData()) {
				l3 = l1;
			}
		}
		
		return l3;
	}
}
