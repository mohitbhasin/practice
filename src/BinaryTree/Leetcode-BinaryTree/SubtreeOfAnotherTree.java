class SubtreeOfAnotherTree {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		System.out.println(isSubtree_serialize(tree.getTree(), tree.getTree().left));
		System.out.println(isSubtree_recursion(tree.getTree(), tree.getTree().left));
	}

	// better than recursive. Time Complexity: O(|n| + |m|), i.e. O(n) + o(m) for serializing 
	// as every node is visited once for each root and subroot trees.
	// space complexity is also O(n + m). for creating strings.
	public static boolean isSubtree_serialize(TreeNode root, TreeNode subRoot) {
        StringBuilder sb1 = new StringBuilder();
        serialize(root, sb1);
        String root_string = sb1.toString();
        StringBuilder sb2 = new StringBuilder();
        serialize(subRoot, sb2);
        String subroot_string = sb2.toString();
        return root_string.contains(subroot_string);
    }

    public static void serialize(TreeNode node, StringBuilder sb) {
        if(node==null) {
            sb.append(",null");
            return;
        }
        sb.append(","+node.val);
        serialize(node.left, sb);
        serialize(node.right, sb);
    }


    //Time complexity is O(m*n). every matching duplicate node from root is traversed with subroot.
    //space complextiy is O(m + n)
    public static boolean isSubtree_recursion(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;

        if(sameTree(root, subRoot)) {
            return true;
        }
        return isSubtree_recursion(root.left, subRoot) || isSubtree_recursion(root.right, subRoot);
    }

    public static boolean sameTree(TreeNode r1, TreeNode r2) {
        if(r1==null || r2==null) {
            return r1==null && r2==null;
        }        
        return r1.val==r2.val && sameTree(r1.left, r2.left) && sameTree(r1.right, r2.right);

    }
}