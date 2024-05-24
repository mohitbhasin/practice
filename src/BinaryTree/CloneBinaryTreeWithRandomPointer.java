import java.util.*;

class CloneBinaryTreeWithRandomPointer {
	public static void main(String[] args) {
		Node n1 = new Node(2);
		Node n2 = new Node(4);
		Node n3 = new Node(7);
		Node n4 = new Node(8);
		Node n5 = new Node(5);
		n1.left = n2;
		n1.right = n3;
		n3.right = n4;
		n2.left = n5;

		NodeCopy copy = copyRandomBinaryTree(n1);

		Queue<NodeCopy> que = new LinkedList<>();
		que.offer(copy);

		while(!que.isEmpty()) {
			NodeCopy n = que.poll();
			System.out.print(n.val+" -> ");
			if(n.left!=null) que.offer(n.left);
			if(n.right!=null) que.offer(n.right);
		}

	}

	public static NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> map = new HashMap<>();
        dfs(root, map);
        for(Node key: map.keySet()) {
            NodeCopy copy = map.get(key);
            copy.random = map.get(key.random);
        }
        return map.get(root);
    }
    
    public static NodeCopy dfs(Node root, Map<Node, NodeCopy> map) {
        if(root==null) return null;
        if(map.containsKey(root)) return map.get(root);
        NodeCopy copy = new NodeCopy(root.val);
        map.put(root, copy);
        copy.left = dfs(root.left, map);
        copy.right = dfs(root.right, map);
        return copy;
    }
}

class Node {
	int val;
    Node left;
    Node right;
    Node random;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node left, Node right, Node random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}

class NodeCopy {
	int val;
    NodeCopy left;
    NodeCopy right;
    NodeCopy random;
    NodeCopy() {}
    NodeCopy(int val) { this.val = val; }
    NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}