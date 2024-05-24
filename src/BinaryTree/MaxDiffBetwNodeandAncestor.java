class MaxDiffBetwNodeandAncestor {
    static int max_val;

    public static void main(String args[]) {
        TreeNode tree = new TreeNode();
        TreeNode root = tree.maxDiffAncestor();
        System.out.println(maxAncestorDiff(root));
    }

    public static int maxAncestorDiff(TreeNode root) {
        max_val=0;
        preOrder(root);
        return max_val;
    }

    public static void preOrder(TreeNode root) {
        if(root==null) return;

        diff(root.val, root);
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void diff(int val, TreeNode root) {
        if(root==null) return;
        int abDiff = Math.abs(val-root.val);
        max_val=Math.max(abDiff, max_val);
        diff(val, root.left);
        diff(val, root.right);
    }
}