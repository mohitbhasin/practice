import java.util.*;

class LevelOrderTraversal {
	public static void main(String args[]) {
		TreeNodeDefault root = new TreeNodeDefault(1);

		List<ArrayList<Integer>> list = levelOrder(root.getTree());

		int size=list.size();
		for(int i=size; i>0; i--) {
			for(int j=0; j<i; j++) {
				System.out.print("\t");
			}
			System.out.println(list.get(list.size()-i));
		}
	}

	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNodeDefault root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Queue<TreeNodeDefault> que = new LinkedList<TreeNodeDefault>();
		que.offer(root);
		while(!que.isEmpty()) {
			int size=que.size();
			ArrayList<Integer> tempList = new ArrayList<>();
			for(int i=0; i<size; i++) {
				TreeNodeDefault node = que.poll();
				if(node.left!=null) {
					que.offer(node.left);
				}
				if(node.right!=null) {
					que.offer(node.right);
				}
				tempList.add(node.val);
			}
			result.add(tempList);
		}
		return result;
	}
}