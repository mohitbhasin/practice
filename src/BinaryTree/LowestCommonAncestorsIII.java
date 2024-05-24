class LowestCommonAncestorsIII {
	public static void main(String args[]) {
		// TreeNode tree = new TreeNode(1);
		// TreeNode p = tree.getTree();
		// TreeNode q = tree.getTree().right.left.left;
		System.out.println();
	}

	// Node with Parent
	public Node lowestCommonAncestor(Node p, Node q) {
    	Node left=p;
        Node right=q;
        Set<Integer> set = new HashSet<>();
        while(left.parent!=null || right.parent!=null) {
            if(set.contains(right.val)) {
                return right;
            }            
            if(set.contains(left.val)) {
                return left;
            }
            if(left.val==right.val) {
                return left;
            }
            if(left.parent!=null) {
                set.add(left.val);
                left=left.parent;
            }
            if(right.parent!=null) {
                set.add(right.val);   
                right=right.parent;
            }
        }
        return left.parent==null ? left : right;
    }
}