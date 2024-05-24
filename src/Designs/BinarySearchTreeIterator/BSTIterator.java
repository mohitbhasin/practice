class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        push(root);
    }
    
    public int next() {
        TreeNode curr = stack.pop();
        push(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void push(TreeNode root) {
        while(root!=null) {
            stack.push(root);
            root=root.left;
        }
    }
}