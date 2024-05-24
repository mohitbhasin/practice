import java.util.*;

class RightSideView {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		System.out.println(rightSideView(tree.getTree()));
		System.out.println(rightSideView_recur(tree.getTree()));
	}

	public static List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        List<Integer> result = new ArrayList<>();
        while(!que.isEmpty()) {
            int size=que.size();
            for(int i=1; i<=size; i++) {
                TreeNode curr = que.poll();
                if(curr.left!=null) que.offer(curr.left);
                if(curr.right!=null) que.offer(curr.right);
                if(i==size) result.add(curr.val);
            }
        }
        return result;
    }

    public static List<Integer> rightSideView_recur(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	if(root==null) return result;
    	rightSideView_helper(root, result, 0);
    	return result;
    }

    public static void rightSideView_helper(TreeNode root, List<Integer> result, int level) {
    	if(root==null) return;
    	if(result.size()==level) {
    		result.add(root.val);
    	}
    	rightSideView_helper(root.right, result, level+1);
    	rightSideView_helper(root.left, result, level+1);
    }
}