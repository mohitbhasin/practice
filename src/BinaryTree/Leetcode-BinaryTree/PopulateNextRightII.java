class PopulateNextRightII {
	public static void main(String args[]) {

	}
	// solution is correct. it will not run as "next" variable is not define in TreeNode class;
	public Node connect(Node root) {
        if(root==null) return null;
        
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        List<List<Node>> levels = new ArrayList<>();
        while(!que.isEmpty()) {
            int size = que.size();
            List<Node> level = new ArrayList<>();
            for(int i=0; i<size; i++) {
                Node curr = que.poll();
                level.add(curr);
                if(curr.left!=null) que.offer(curr.left);
                if(curr.right!=null) que.offer(curr.right);
            }
            levels.add(level);
        }
        
        for(List<Node> level: levels) {
            for(int i=0; i<level.size()-1; i++) {
                level.get(i).next=level.get(i+1);
            }
        }
        return root;
    }
}