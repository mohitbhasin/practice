class PopulateNextRight {
	public static void main(String args[]) {

	}
	// solution is correct. it will not run as "next" variable is not define in TreeNode class;
	public static void populate(TreeNode root) {
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);

		int size=0;

		while(!que.isEmpty()) {
			size=que.size();
			for(int i=0; i<size; i++) {
				TreeNode curr = que.poll();
				if(i==size-1) {
					curr.next=null;
				} else {
					curr.next=que.peek();
				}

				if(curr.left!=null) que.offer(curr.left);
				if(curr.right!=null) que.offer(curr.right);
			}
		}
	}
}