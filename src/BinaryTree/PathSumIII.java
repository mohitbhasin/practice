import java.util.*;

class PathSumIII {
    public static void main(String args[]) {
        TreeNode t = new TreeNode();
        // System.out.println(pathSum(t.pathSumIII(), 8));
        System.out.println(pathSum_cumulativeSum(t.pathSumIII(), 8));
    }



    public static int pathSum_cumulativeSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        count = 0;
        cumuSum = 0;
        preorder(root, map, targetSum);
        return count;
    }
    static int count;
    static int cumuSum;
    
    public static void preorder(TreeNode root, Map<Integer, Integer> map, int  k) {
        if(root!=null) {
            cumuSum+=root.val;
            if(map.containsKey(cumuSum-k)) {
                System.out.println(cumuSum);
                count+=map.get(cumuSum-k);
            }
            map.put(cumuSum, map.getOrDefault(cumuSum, 0) + 1);
            preorder(root.left, map, k);
            preorder(root.right, map, k);
            cumuSum-=root.val;
        }
    }

    static int result;
    static int target;
    public static int pathSum(TreeNode root, int targetSum) {
        result = 0;
        target=targetSum;
        preorder(root);
        return result;
    }

    public static void preorder(TreeNode root) {
        if(root==null) return;
        sumPath(root, 0);
        preorder(root.left);
        preorder(root.right);
    }

    public static void sumPath(TreeNode root, int sum) {
        if(root==null) {
            return;
        }
        if((sum>0 && Integer.MAX_VALUE - sum < root.val) || sum<0 && Integer.MIN_VALUE - sum > root.val) return;
        sum+=root.val;
        if(sum==target) {
            result++;
        }
        sumPath(root.left, sum);
        sumPath(root.right, sum);
    }
}