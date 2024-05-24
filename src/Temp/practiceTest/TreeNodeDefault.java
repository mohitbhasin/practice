public class TreeNodeDefault {
    public int val;
    public TreeNodeDefault left;
    public TreeNodeDefault right;

    public TreeNodeDefault(int x) {
        val = x;
    }

    public TreeNodeDefault getTree() {
        TreeNodeDefault t = this;
        t.left=new TreeNodeDefault(2);
        t.right=new TreeNodeDefault(7);
        t.right.right=new TreeNodeDefault(15);
        t.right.right.left=new TreeNodeDefault(10);
        t.right.right.right=new TreeNodeDefault(19);
        t.left.left = new TreeNodeDefault(3);
        t.left.left.left = new TreeNodeDefault(13);
        t.left.right = new TreeNodeDefault(4);
        t.left.right.left = new TreeNodeDefault(5);
        t.left.right.right = new TreeNodeDefault(6);
        return t;
    }

    public String toString() {
        return String.valueOf(val);
    }
}
