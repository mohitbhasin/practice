import java.util.*;

class DeepCopy {
	static HashMap<Node, Node> visited = new HashMap<>();

	public static Node makeCopy(Node root) {
		if(root==null) {
			return null;
		}
		Node prime = new Node(root.val);
		visited.put(root, prime);

		for(Node neighbor: root.neighbors) {
			if(visited.containsKey(neighbor)) {
				prime.neighbors.add(visited.get(neighbor));
			} else {
				prime.neighbors.add(makeCopy(neighbor));
			}			
		}
		return prime;
	}

	public static Node makeCopyRecur(Node root, HashMap<Node, Node> map) {
		Node prime;
		if(map.containsKey(root)) {
			prime=map.get(root);
		} else {
			prime = new Node(root.val);
			map.put(root, prime);
		}
		for(Node n: root.neighbors) {
			if(map.containsKey(n)) {
				prime.neighbors.add(map.get(n));
			} else {
				prime.neighbors.add(makeCopyRecur(n, map));
			}
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

		Node prime = makeCopy(n1);
		printGraph(n1);
		// System.out.println("-------");
		// printGraph(prime);
		System.out.println("-------");
		printGraph(makeCopyRecur(n1, new HashMap<Node, Node>()));


		


	}


	static class Node {
		int val;
		ArrayList<Node> neighbors;

		public Node(int val) {
			this.val = val;
			this.neighbors=new ArrayList<Node>();
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for(Node n: neighbors) {
				sb.append(n.val+", ");
			}
			sb.setLength(sb.length() - 2);
			return "Val="+val+" Neighbors="+sb.toString(); 
		}
	}
}