import java.util.*;

class TestCopy {
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

		printGraph(n1);
		System.out.println("------");
		printGraph(copy(n1));
		// Node clone = deepCopy(n1);
	}

	public static Node copy(Node root) {
		if(root==null) {
			return null;	
		}
		Node prime = new Node(root.val);
		root.isVisited=true;
		for(Node n: root.neighbors) {
			prime.neighbors.add(copy(n));
		}

		return prime;
	}

	public static void printGraph(Node n) {
		Queue<Node> queue = new LinkedList<Node>();
		HashMap<Node, Boolean> map = new HashMap<>();

		queue.offer(n);
		map.put(n, false);
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			if(!map.get(curr)) {
				System.out.println(curr);
				map.put(curr, true);
				for(Node neighbor: curr.neighbors) {
					queue.offer(neighbor);
					if(!map.containsKey(neighbor)) {
						map.put(neighbor, false);	
					}
				}
			}

		}
	}
}



class Node {
	int val;
	ArrayList<Node> neighbors;
	boolean isVisited;

	public Node(int val) {
		this.val = val;
		this.neighbors=new ArrayList<Node>();
		this.isVisited=false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Node n: neighbors) {
			sb.append(n.val+", ");
		}
		// System.out.println(sb);
		sb.setLength(sb.length() - 2);
		return "Val="+val+" Neighbors="+sb.toString(); 
	}
}