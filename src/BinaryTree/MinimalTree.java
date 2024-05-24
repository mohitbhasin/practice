import java.util.Queue;
import java.util.LinkedList;

class MinimalTree {
	public static void main(String args[]) {
		int[] data = {1,2,3,5,6,7,8,9};
		Node root = create(data, 0, data.length - 1);
		// System.out.println("----------");
		// System.out.println(root.left.data);
		// System.out.println(root.right.data);
		// System.out.println("-----------");
		// print(root);
		printBFS(root);
	}

	public static void printBFS(Node t) {
        Queue<Node> nodesQueue = new LinkedList<Node>();
        nodesQueue.offer(t);

        while(!nodesQueue.isEmpty()) {
            Node curr = nodesQueue.poll();
            System.out.println(curr.data);
            if(curr.left!=null) nodesQueue.offer(curr.left);
            if(curr.right!=null) nodesQueue.offer(curr.right);
        }
    }

//print function not working correctly
	public static void print(Node root) {
		if(root==null) {
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);

		while(!q.isEmpty()) {
			Node temp=null;
			for(int i=0; i<q.size(); i++) {
				temp = q.poll();
				System.out.print(temp.data + "\t");
			}
			if(temp.left!=null) q.offer(temp.left);
			if(temp.right!=null) q.offer(temp.right);
			System.out.println();
		}
	}

	public static Node create(int[] data, int start, int end) {
		if(end<start) {
			return null;
		}
		int mid = (start + end) / 2;
		Node node = new Node(data[mid]);
		node.left = create(data, start, mid - 1);
		node.right = create(data, mid + 1, end);
		return node;
	}
}

