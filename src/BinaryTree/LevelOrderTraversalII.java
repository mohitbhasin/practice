import java.util.*;

class LevelOrderTraversalII {
	public static void main(String args[]) {
		TreeNodeDefault root = new TreeNodeDefault(1);

		List<List<Integer>> list = levelOrderBottom(root.getTree());

		int size=list.size();
		for(int i=size; i>0; i--) {
			for(int j=0; j<i; j++) {
				System.out.print("\t");
			}
			System.out.println(list.get(list.size()-i));
		}
	}

	public static List<List<Integer>> levelOrderBottom(TreeNodeDefault root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNodeDefault> que = new LinkedList<>();
        
        que.offer(root);
        
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++) {              
                TreeNodeDefault curr = que.poll();
                level.add(curr.val);
                if(curr.left!=null) que.offer(curr.left);
                if(curr.right!=null) que.offer(curr.right);
            }
            result.add(0, level);
        }
        return result;
    }
}