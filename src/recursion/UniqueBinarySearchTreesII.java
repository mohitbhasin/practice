import java.util.*;

class UniqueBinarySearchTreesII {
	public static void main(String args[]) {
		System.out.println(generateTrees(3));
	}

	public static List<TreeNode> generateTrees(int n) {
        return helper(1, n, new HashMap<>());
    }

    public static List<TreeNode> helper(int start, int end, Map<Pair<Integer, Integer>, List<TreeNode>> map) {
        List<TreeNode> list = new ArrayList<>();
        if(start>end) {
            list.add(null);
            return list;
        }
        Pair pair = new Pair(start, end);
        if(map.containsKey(pair)) return map.get(pair);
        for(int i=start; i<=end; i++) {
        	List<TreeNode> leftNodes = helper(i, end-1, map);
        	List<TreeNode> rightNodes = helper(i+1, end, map);
        	for(TreeNode left: leftNodes) {
	            for(TreeNode right: rightNodes) {
	                TreeNode root = new TreeNode(i, left, right);
	                list.add(root);
	            }   
	        }
        }
        
        return list; 
    }
}

class Pair<k,v> {
	k start;
	v end;
	Pair(k start, v end) {
		this.start = start;
		this.end = end;
	}
}