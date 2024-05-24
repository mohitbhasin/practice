import java.util.*;

class LowestCommonAncestorLevelOrder {
	public static void main (String args[]) {
		TreeNodeDefault root = new TreeNodeDefault(1);

		int a = levelOrder(root.getTree());
		System.out.println(a);
	}

	public static int levelOrder(TreeNodeDefault root) {
		ArrayList<ArrayList<TreeNodeDefault>> list = new ArrayList<ArrayList<TreeNodeDefault>>();
		Queue<TreeNodeDefault> que = new LinkedList<TreeNodeDefault>();
		HashMap<TreeNodeDefault, TreeNodeDefault> map = new HashMap<TreeNodeDefault, TreeNodeDefault>();
		que.offer(root);

		while(!que.isEmpty()) {
			int size=que.size();
			ArrayList<TreeNodeDefault> tempList = new ArrayList<>();
			for(int i=0; i<size; i++) {
				TreeNodeDefault temp = que.poll();
				if(temp.left!=null) {
					map.put(temp.left, temp);
					que.offer(temp.left);
				}
				if(temp.right!=null) {
					map.put(temp.right, temp);
					que.offer(temp.right);
				}
				tempList.add(temp);
			}
			list.add(tempList);
		}

		int ans=-1;
		List<TreeNodeDefault> leastElements = list.get(list.size()-1);
		TreeNodeDefault a = leastElements.get(0);
		TreeNodeDefault b = leastElements.get(leastElements.size()-1);
		while(a!=null || b!=null) {
			if(map.get(a)==map.get(b)) {
				return map.get(a).val;
			}
			a=map.get(a);
			b=map.get(b);
		}
		return 0;
	}
}