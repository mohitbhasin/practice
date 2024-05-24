class ConvertBinarySearchTreeToSortedDoublyLinkedList {
	public static void main(String args[]) {
		TreeNode root = new TreeNode();
		root = root.bstNode();
		TreeNode result = treeToDoublyList(root);

		root = result;
		int count = 10;
		while(count>=0) {
			System.out.print(root.val+"->");
			root=root.right;
			count--;
		}
		System.out.println();
		root = result;
		count = 10;
		while(count>=0) {
			System.out.print(root.val+"<-");
			root=root.left;
			count--;
		}
	}

	static TreeNode head;
    static TreeNode tail;
    
    public static TreeNode treeToDoublyList(TreeNode root) {
        if(root==null) return null;
        inorder(root);
        tail.right= head;
        head.left = tail;
        return head;
    }
    
    public static void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        if(head==null) {
            head=root;
        } else {
            root.left = tail;
            tail.right = root;
        }
        tail=root;
        System.out.println(head.val+": "+tail.val);
        inorder(root.right);
    }
}