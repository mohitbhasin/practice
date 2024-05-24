import java.util.*;

class TreeTraversal {
	public static void main(String args[]) {
		TreeNodeDefault tree = new TreeNodeDefault(44);
		preOrder(tree.getTree());
		System.out.println();
		preOrder_mirror(tree.getTree());
		System.out.println();
		List<List<Integer>> result = levelOrder(tree.getTree());
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
		System.out.print("lead nodes = ");
		leafNodes(tree);
		System.out.println();
		System.out.println("leaf nodes count --> "+countLeafNodes(tree));
		System.out.println("depth --> "+findDepth(tree));
	}



	public static void preOrder(TreeNodeDefault root) {
		if(root==null) {
			return;
		}

		System.out.print(root.val + ", ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void preOrder_mirror(TreeNodeDefault root) {
		if(root==null) {
			return;
		}

		System.out.print(root.val + ", ");
		preOrder(root.right);
		preOrder(root.left);
	}

	public static List<List<Integer>> levelOrder(TreeNodeDefault root) {
		Queue<TreeNodeDefault> queue = new LinkedList<TreeNodeDefault>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp;
		TreeNodeDefault curr = root;
		queue.offer(curr);
		while(!queue.isEmpty()) {
			int size = queue.size();
			temp = new ArrayList<Integer>();
			for(int i=0; i<size; i++) {
				curr = queue.poll();
				temp.add(curr.val);
				if(curr.left!=null) {
					queue.offer(curr.left);
				}
				if(curr.right!=null) {
					queue.offer(curr.right);
				}
			}
			result.add(temp);

		}
		return result;
	}

	public static void leafNodes(TreeNodeDefault root) {
		if(root==null) {
			return;
		}
		if(root.left==null && root.right==null) {
			System.out.print(root.val+", ");
			return;
		}
		leafNodes(root.left);
		leafNodes(root.right);
	}

	public static int countLeafNodes(TreeNodeDefault root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return 1;
		}
		return countLeafNodes(root.left) + countLeafNodes(root.right);
	}

	public static int findDepth(TreeNodeDefault root) {
		if(root==null) {
			return 0;
		}

		return 1 + Math.max(findDepth(root.left), findDepth(root.right));
	}
}













