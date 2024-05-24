import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LowestCommonAncestorsForLastChildren {
    public static void main(String args[]) {
        TreeNodeDefault t = new TreeNodeDefault(1);
        List<List<TreeNodeDefault>> result = new ArrayList<>();

        result = levelOrder(t.getTree());

        for(List l : result) {
            System.out.println(l);
        }

        LinkedList<TreeNodeDefault> lastLevelElements = (LinkedList<TreeNodeDefault>) result.get(result.size()-1);
        System.out.println("Lowest Common Ancestor --> "+lowestCommAncestor(t.getTree(), lastLevelElements.getFirst(), lastLevelElements.getLast()));
        // System.out.println("Lowest Common Ancestor --> "+lowestCommAncestor(t.getTree(), 13, 6));
    }

    public static List<List<TreeNodeDefault>> levelOrder(TreeNodeDefault root) {
        List<List<TreeNodeDefault>> list = new ArrayList<>();

        Queue<TreeNodeDefault> q = new LinkedList<>();
        if(root!=null) {
            q.offer(root);
        }

        TreeNodeDefault temp;

        while(!q.isEmpty()) {
            int size = q.size();
            List<TreeNodeDefault> l = new ArrayList<>();
            for(int i = 0; i<size;i++) {
                temp = q.poll();
                if(temp.left!=null) {
                    q.offer(temp.left);
                }
                if(temp.right!=null) {
                    q.offer(temp.right);
                }
                l.add(temp);
            }
            list.add(l);
        }

        return list;

    }

    public static TreeNodeDefault lowestCommAncestor(TreeNodeDefault root, int a, int b) {
        if(root==null) {
            return null;
        }

        if(root.val==a || root.val==b) {
            return root;
        }

        TreeNodeDefault left = lowestCommAncestor(root.left, a, b);
        TreeNodeDefault right = lowestCommAncestor(root.right, a, b);

        if(left!=null && right!=null) {
            return root;
        }

        if(left==null) {
            return right;
        }
        else {
            return left;
        }
    }
}
