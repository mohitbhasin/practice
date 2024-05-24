import java.util.*;

// ??? ref: SubtreeOfAnotherTree
class CheckSubTree {
	public static void main(String args[]) {
		TreeNodeDefault tree = new TreeNodeDefault(1).getTree();
		TreeNodeDefault subTree = tree.right.right.right;
		// TreeNodeDefault subTree = new TreeNodeDefault(1).getTree();


		boolean result = false;
		for(TreeNodeDefault r2: levelOrderTraversal(tree, subTree)) {
			if(inorderTraversal(subTree, r2)) {
				result=true;
			}
		}

		if(result) {
			System.out.println("it is a subtree");
		} else {
			System.out.println("it is not a subtree");
		}
	}


	public static boolean inorderTraversal(TreeNodeDefault r1, TreeNodeDefault r2) {
		if((r1==null && r2!=null) || (r2==null && r1!=null)) {
			return false;
		}

		if(r1==null && r2==null) {
			return true;
		}

		if(r1.val!=r2.val) {
			return false;
		}
		inorderTraversal(r1.left, r2.left);
		inorderTraversal(r1.right, r2.right);

		return true;
	}

	public static List<TreeNodeDefault> levelOrderTraversal(TreeNodeDefault root, TreeNodeDefault subTree) {
		Queue<TreeNodeDefault> que = new LinkedList<TreeNodeDefault>();
		que.offer(root);

		List<TreeNodeDefault> list = new ArrayList<TreeNodeDefault>();
		TreeNodeDefault temp;
		while(!que.isEmpty()) {
			temp = que.poll();
			if(temp.val == subTree.val) {
				list.add(temp);
			}
			if(temp.left!=null) {
				que.offer(temp.left);
			}
			if(temp.right!=null) {
				que.offer(temp.right);
			}
		}
		return list;
	}
}