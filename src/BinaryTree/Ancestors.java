import java.util.*;

class Ancestors {
	
	public static Node lowestCommon(Node root, Node p, Node q) {
		if(root==null) {
			return null;
		}
		if(root==p || root==q) {
			return root;
		}

		Node left=lowestCommon(root.left, p, q);
		Node right=lowestCommon(root.right, p, q);

		if(left!=null && right!=null) {
			return root;
		} else if(left==null && right==null) {
			return null;
		} else {
			return left==null ? right : left;
		}
	}

	

	static Map<Node, List<Node>> map = new HashMap<>();
	public static void inorderFillMap(Node root) {
		List<Node> children = new ArrayList<Node>();
		if(root.left!=null) {
			children.add(root.left);
			inorderFillMap(root.left);
		}
		if(root.right!=null) {
			children.add(root.right);
			inorderFillMap(root.right);
		}
		map.put(root, children);
	}

	public static void main(String args[]) {
		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(31);
		root.left.left = new Node(4);
		root.left.right = new Node(8);
		root.left.right.left = new Node(11);
		root.left.right.right = new Node(5);
		root.right = new Node(31);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		// inorderFillMap(root);
		// for(Node n: map.keySet()) {
		// 	System.out.println("key="+n+" Values="+map.get(n));
		// }

		System.out.println(lowestCommon(root, root.left.right.left, root.left.right.right));
	}


	static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return val+"";
		}
	}	
}