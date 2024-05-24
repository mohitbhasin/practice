import java.util.*;

class VerticalOrderTraversal {
	public static void main(String args[]) {
		TreeNode t = new TreeNode();
		TreeNode root = t.verticalOrder();
		t.print(root);
		// incorrect sol, along with col, row is also required and the output needs to be sorted with respect to row number.
		System.out.println(verticalOrder(root));
		System.out.println("-----------------");
		// BFS is the efficient O(N) solution
		System.out.println(verticalOrder_withBFS(root));

	}
	// incorrect solution. the output needs to be sorted with respect to row order
	public static List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer,List<Integer>> map = new HashMap<>();

		int index = mapBalance(root, map, 0);

		while(map.containsKey(index)) {
			result.add(map.get(index++));
		}

		return result;
	}

	public static int mapBalance(TreeNode root, Map<Integer, List<Integer>> map, int balance) {
		if(root==null) {
			return balance+1;
		}
		int min=0;
		List<Integer> list;
		if(!map.containsKey(balance)) {
			list = new ArrayList<>();
			list.add(root.val);
			map.put(balance, list);
		} else {
			map.get(balance).add(root.val);
		}
		min = Math.min(min, mapBalance(root.left, map, balance-1));
		mapBalance(root.right, map, balance+1);
		return min;
	}

	public static List<List<Integer>> verticalOrder_withBFS(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer,List<Integer>> map = new HashMap<>();

		int index = columnMap_bfs_returnMin(root, map);

		while(map.containsKey(index)) {
			result.add(map.get(index++));
		}

		return result;
	}

	public static int columnMap_bfs_returnMin(TreeNode root, Map<Integer, List<Integer>> map) {
		List<Integer> elements;
		Queue<Pair> que = new LinkedList<>();
		int min = 0;
		Pair curr = new Pair(root, 0);
		que.offer(curr);
		int size = 0;
		while(!que.isEmpty()) {
			size = que.size();
			for(int i=0; i<size; i++) {
				curr = que.poll();
				if(curr.node!=null) {
					min = Math.min(min, curr.index);
					if(!map.containsKey(curr.index)) {
						elements = new ArrayList<>();
						elements.add(curr.node.val);
						map.put(curr.index, elements);
					} else {
						map.get(curr.index).add(curr.node.val);
					}
					que.offer(new Pair(curr.node.left, curr.index - 1));
					que.offer(new Pair(curr.node.right, curr.index + 1));
				}
			}
		}
		return min;
	}
}