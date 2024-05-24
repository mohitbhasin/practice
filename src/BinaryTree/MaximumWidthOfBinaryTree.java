import java.util.*;

class Pair {
    TreeNode node;
    int index;
    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
class MaximumWidthOfBinaryTree {
    public static void main(String args[]) {
        TreeNode tree = new TreeNode();
        System.out.println(widthOfBinaryTree(tree.getTree()));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        LinkedList<Pair> que = new LinkedList<>();
        que.offer(new Pair(root, 0));
        int maxWidth = 1;

        while(!que.isEmpty()) {
            int size = que.size();
            int parent_index = que.getFirst().index;
            Pair curr = null;
            for(int i=0; i<size; i++) {
                curr = que.removeFirst();
                TreeNode currNode = curr.node;
                if(currNode.left!=null) {
                    que.addLast(new Pair(currNode.left, 2*curr.index));
                }
                if(currNode.right!=null) {
                    que.addLast(new Pair(currNode.right, 2*curr.index+1));
                }
            }
            maxWidth=Math.max(maxWidth, curr.index - parent_index + 1);
        }
        return maxWidth;

    }
}