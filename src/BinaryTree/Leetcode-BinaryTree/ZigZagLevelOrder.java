import java.util.*;

class ZigZagLevelOrder {
	public static void main(String args[]) {
		TreeNode root = new TreeNode();
		System.out.println(zigzagLevelOrder(root.getForZigZag()));
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean even=true;

        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> currList = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode curr = que.poll();
                System.out.println(curr.val);
                if(even) {
                    currList.add(curr.val);
                } else {
                    currList.add(0, curr.val);
                }
                if(curr.left!=null) que.offer(curr.left);
                if(curr.right!=null) que.offer(curr.right);
            }
			even=!even;
            result.add(currList);
        }
        return result;
    }
}