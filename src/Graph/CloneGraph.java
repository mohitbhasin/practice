import java.util.*;

class CloneGraph {

	private static HashMap<Node, Node> visited = new HashMap<>();

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

		// Node prime = cloneGraph(n1);
		// printGraph(n1);
		// System.out.println("-------");
		// printGraph(prime);
		// System.out.println("-------");
		// prime = bfs(n1);
		// printGraph(prime);

		Node a = new Node(1);
		Node b = new Node(2);
		a.neighbors.add(b);
		b.neighbors.add(a);
		printGraph(a);
		Node copy = cloneGraphDFSIterative(a);
		printGraph(copy);
	}

	public static Node cloneGraphDFSIterative(Node node) {
        Stack<Node> stack = new Stack<>();
        Map<Node, Node> visited = new HashMap<>();

        stack.push(node);
        visited.put(node, new Node(node.val));

        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            Node copy = visited.get(curr);
            for(Node n: curr.neighbors) {
            	if(!visited.containsKey(n)) {
            		visited.put(n, new Node(n.val));
            		stack.push(n);
            	}
            	copy.neighbors.add(visited.get(n));
            }
        }
        return visited.get(node);
    }

	public static Node cloneGraph(Node node) {
		if(node==null) {
			return null;
		}

		if(visited.containsKey(node)) {
			return visited.get(node);
		}

		Node cloneNode = new Node(node.val);
		visited.put(node, cloneNode);

		for(Node neighbor: node.neighbors) {
			cloneNode.neighbors.add(cloneGraph(neighbor));
		}
		return cloneNode;
	}

	public static Node bfs(Node n) {
		HashMap<Node, Node> map = new HashMap<>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(n);
		map.put(n, new Node(n.val));
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			Node prime = map.get(curr);
			for(Node neighbor: curr.neighbors) {
				if(!map.containsKey(neighbor)) {
					queue.offer(neighbor);
					map.put(neighbor, new Node(neighbor.val));
				}
				prime.neighbors.add(map.get(neighbor));
			}
		}
		return map.get(n);
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