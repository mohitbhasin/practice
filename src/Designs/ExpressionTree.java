import java.util.Stack;

public class ExpressionTree {
    public static void main(String args[]) {
//        String[] postfix = {"3","4","+","2","*","7","/"};
        String[] postfix = {"4","5","2","7","+","-","*"};
        TreeBuilder obj = new TreeBuilder();
        Node expTree = obj.buildTree(postfix);
        int ans = expTree.evaluate();
        System.out.println(ans);
    }
}


abstract class Node{
    public abstract int evaluate();
};

class TreeBuilder {
    String operators = "/*+-";
    Stack<TreeNode> stack = new Stack<>();

    public Node buildTree(String[] postfix) {
        for(String str: postfix) {
            TreeNode curr = new TreeNode(str);
            if(operators.contains(str)) {
                curr.right = stack.pop();
                curr.left = stack.pop();

            }
            stack.push(curr);
        }
        return stack.peek();
    }
};

class TreeNode extends Node {
    String val;
    TreeNode left;
    TreeNode right;

    public TreeNode(String val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public int dfs(TreeNode root) {
        if(root.left!=null && root.right!=null) {
            int left = dfs(root.left);
            int right = dfs(root.right);
            if(root.val.equals("/")) {
                return left/right;
            } else if(root.val.equals("*")) {
                return left*right;
            } else if(root.val.equals("+")) {
                return left+right;
            } else {
                return left-right;
            }
        }
        return Integer.parseInt(root.val);
    }

    @Override
    public int evaluate() {
        return dfs(this);
    }
}
