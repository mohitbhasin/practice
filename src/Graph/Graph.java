import java.util.*;
class Graph {
	public static void bfs(Node n1, Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		n1.isVisited=true;
		queue.offer(n1);
		Node prime;
		ArrayList<Node> tempList;
		while(!queue.isEmpty()) {
			tempList = new ArrayList<Node>();
			Node curr = queue.poll();
			prime = new Node(curr.val);
			for(Node n: curr.neighbors) {
				if(!n.isVisited) {
					n.isVisited=true;
					queue.offer(n);
					Node neighbor = new Node(n.val);
					tempList.add(neighbor);
				}
			}
			prime.neighbors = tempList;
		}
	}

	public static Node deepCopy(Node n1) {
		Node root = new Node(n1.val);
		bfs(n1, root);
		return root;
	}

	public static void main(String args[]) {
		Node n1 = new Node(2);
		Node n2 = new Node(8);
		Node n3 = new Node(4);
		Node n4 = new Node(7);
		Node n5 = new Node(1);

		n1.neighbors.add(n2);
		n1.neighbors.add(n3);

		n2.neighbors.add(n1);
		n2.neighbors.add(n4);
		n2.neighbors.add(n5);

		n3.neighbors.add(n1);
		n3.neighbors.add(n4);

		n4.neighbors.add(n3);
		n4.neighbors.add(n2);
		n4.neighbors.add(n5);

		n5.neighbors.add(n2);
		n5.neighbors.add(n4);

		Node clone = deepCopy(n1);
		System.out.println(clone);
		for(Node n: clone.neighbors) {
			System.out.println(n);
		}

	}

	static class Node {
		int val;
		ArrayList<Node> neighbors;
		boolean isVisited;

		public Node(int val) {
			this.val = val;
			this.neighbors=new ArrayList<Node>();
		}

		@Override
		public String toString() {
			return "Val="+val+" - Neighbors="+neighbors; 
		}
	}
}