import java.util.*;

class FindLeavesOfBinaryTree {
	public static void main(String args[]) {
		System.out.println(findLeaves(new TreeNode().getTree()));
	}

	public static List<List<Integer>> findLeaves(TreeNode root) {
		if(root==null) {
			return null;
		}
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		int maxHeight = mapFromHeight(root, map);
		for(int i=1; i<maxHeight; i++) {
			result.add(map.get(i));
		}
		return result;
	}

	public static int mapFromHeight(TreeNode root, Map<Integer, List<Integer>> map) {
		if(root==null) {
			return 0;
		}
		int left = 1+mapFromHeight(root.left, map);
		int right = 1+mapFromHeight(root.right, map);

		int maxHeight = Math.max(left, right);
		if(!map.containsKey(maxHeight)) {
			map.put(maxHeight, new ArrayList<Integer>());
		}
		map.get(maxHeight).add(root.val);

		return maxHeight;
	}
}