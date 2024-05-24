import java.util.*;

class PathBetweenNodesInGraph {
	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);

		one.neighbors.add(two);
		one.neighbors.add(five);
		one.neighbors.add(six);
		two.neighbors.add(four);
		two.neighbors.add(one);
		four.neighbors.add(two);
		four.neighbors.add(three);
		three.neighbors.add(four);
		three.neighbors.add(five);
		five.neighbors.add(three);
		five.neighbors.add(seven);
		five.neighbors.add(one);
		six.neighbors.add(one);
		seven.neighbors.add(five);

		System.out.println(dfs(one, three));

	}

	public static boolean dfs(Node source, Node target) {
		Set<Node> visited = new HashSet<>();
		Stack<Node> stack = new Stack<>();
		stack.add(source);
		visited.add(source);

		while(!stack.isEmpty()) {
			System.out.println("stack "+stack);
			Node curr=stack.pop();
			if(curr==target) {
				return true;
			}
			for(Node n: curr.neighbors) {
				if(!visited.contains(n)) {
					visited.add(n);
					stack.push(n);
				}
			}
		}
		return false;
	}
}

class Node {
	int val;
	List<Node> neighbors;

	public Node(int val) {
		this.val = val;
		this.neighbors = new ArrayList<>();
	}

	public String toString() {
		return ""+val;
	}
}