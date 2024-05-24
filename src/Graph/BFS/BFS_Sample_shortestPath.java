import java.util.*;

class BFS_Sample_shortestPath {
	public static void main(String args[]) {
		Node a = new Node('A');
		Node b = new Node('B');
		Node c = new Node('C');
		Node d = new Node('D');
		Node e = new Node('E');
		Node f = new Node('F');
		Node g = new Node('G');

		a.update(b);
		a.update(c);
		a.update(d);
		b.update(e);
		c.update(e);
		c.update(f);
		f.update(g);
		d.update(g);

		System.out.println(getShortestSteps(a, g));
	}


	public static int getShortestSteps(Node a, Node g) {
		Queue<Node> que = new LinkedList<>();
		Set<Node> visited = new HashSet<>();
		visited.add(a);
		que.offer(a);
		int steps=0;
		while(!que.isEmpty()) {
			int size=que.size();
			System.out.println(que);
			for(int i=0; i<size; i++) {
				Node curr = que.poll();
				if(curr.val==g.val) {
					return steps;
				}
				for(Node n: curr.neighbors) {
					if(!visited.contains(n)) {
						que.offer(n);
						visited.add(n);
					}
				}
			}
			steps++;
		}
		return steps;
	}
}


class Node {
	char val;
	List<Node> neighbors;

	Node(char val) {
		this.val=val;
		this.neighbors = new ArrayList<>();
	}

	public void update(Node n) {
		neighbors.add(n);
	}
	public String toString() {
		return String.valueOf(val);
	}
}