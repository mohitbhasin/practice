import java.util.*;

class CloneGraph {
	public static void main(String args[]) {
		Node root = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);

		root.neighbors.add(two);
		root.neighbors.add(three);
		root.neighbors.add(six);
		two.neighbors.add(root);
		two.neighbors.add(three);
		two.neighbors.add(five);
		three.neighbors.add(two);
		three.neighbors.add(root);
		four.neighbors.add(six);
		four.neighbors.add(five);
		five.neighbors.add(two);
		five.neighbors.add(four);
		six.neighbors.add(four);
		six.neighbors.add(root);

		// Node clone = clone(root, new HashMap<Node, Node>());

		Node clone = cloneGraph(root);



		Queue<Node> que = new LinkedList<>();
		que.offer(clone);
		Set<Node> visited = new HashSet<>();
		visited.add(clone);
		while(!que.isEmpty()) {
			Node curr = que.poll();			
			System.out.println(curr.val);
			for(Node neighbor: curr.neighbors) {
				if(!visited.contains(neighbor)) {
					visited.add(neighbor);
					que.offer(neighbor);
				}
			}
		}
	}



	public static Node clone(Node root, Map<Node, Node> primeMap) {
		if(root==null) {
			return null;
		}
		if(primeMap.containsKey(root)) {
			return primeMap.get(root);
		}

		Node prime = new Node(root.val);
		primeMap.put(root, prime);
		for(Node neighbor: root.neighbors) {
			prime.neighbors.add(clone(neighbor, primeMap));
		}
		return prime;
	}

	public static Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Node, Node> cloneMap = new HashMap<>();

        cloneMap.put(node, new Node(node.val));

        Stack<Node> stack = new Stack<>();
        stack.push(node);
        
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
             Node clone = cloneMap.get(curr);
            for(Node neighbor: curr.neighbors) {
                if(!cloneMap.containsKey(neighbor)) {
                	cloneMap.put(neighbor, new Node(neighbor.val));
                    stack.push(neighbor);
                }
                clone.neighbors.add(cloneMap.get(neighbor));                
            }
        }        
        return cloneMap.get(node);
    }

    public Node cloneGraph_wrong_for_comparison(Node node) {
        if(node==null) return null;
        Map<Node, Node> cloneMap = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            Node clone = new Node(curr.val);
            cloneMap.put(curr, clone);
            for(Node neighbor: curr.neighbors) {
                if(!cloneMap.containsKey(neighbor)) {
                    stack.push(neighbor);
                } else {
                    clone.neighbors.add(cloneMap.get(neighbor));
                }
            }
        }
        
        return cloneMap.get(node);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}