import java.util.*;

class PopulateNextRightPointer {
	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		populateNext(root);

		System.out.println(levelOrder(root));


	}

	public static Node populateNext(Node root) {
		if(root==null) return null;
		Queue<Node> que = new LinkedList<>();
		que.offer(root);

		while(!que.isEmpty()) {
			int size = que.size();
			for(int i=0; i<size; i++) {
				Node levelNode = que.poll();
				if(i<size-1) {
					levelNode.next = que.peek();
				}
				if(levelNode.left!=null) {
					que.offer(levelNode.left);
				}
				if(levelNode.right!=null) {
					que.offer(levelNode.right);
				}
			}
		}
		return null;
	}

	public static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Queue<Node> que = new LinkedList<Node>();
		que.offer(root);
		while(!que.isEmpty()) {
			int size=que.size();
			ArrayList<Integer> tempList = new ArrayList<>();
			for(int i=0; i<size; i++) {
				Node node = que.poll();
				if(node.left!=null) {
					que.offer(node.left);
				}
				if(node.right!=null) {
					que.offer(node.right);
				}
				tempList.add(node.val);
				tempList.add(node.next==null ? -1 : node.next.val);
			}
			result.add(tempList);
		}
		return result;
	}


}

class Node {
	int val;
	Node left;
	Node right;
	Node next;

	public Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}