import java.util.*;

class LowestCommonAncestorOfBinaryTreeIII {
	public static void main(String args[]) {
		int[] nodes = {1,2,3,4,5,6,7};
		Tree tree = new Tree(nodes);
		TreeNode p = tree.find(6);
		TreeNode q = tree.find(7);

		System.out.println(p.data+" : "+ q.data);

		System.out.println(lowestCommonAncestor(p,q).data);
	}

	public static TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
        TreeNode a = p;
        TreeNode b = q;
        
        while(a!=b) {
          a=a.parent;
          b=b.parent;
          if(a==null) {
            a=q;
          }
          if(b==null) {
            b=p;
          }
        }
        return a;
    }

    public static TreeNode lowestCommonAncestor_alternate(TreeNode p, TreeNode q) {
        TreeNode a = p;
        TreeNode b = q;
        
        while(a!=b) {
          if(a==null) {
            a=q;
          }
          else if(b==null) {
            b=p;
          } else {
            a=a.parent;
            b=b.parent;
          }
        }
        return a;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    TreeNode(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

class Tree {
	TreeNode root;

	public Tree() {
		this.root = null;
	}

	public Tree(int[] nodes) {
		this.root = createTree(nodes);
	}

	public TreeNode createTree(int[] nodes) {
		if(nodes.length==0 || nodes[0]==0) {
			return null;
		}
		this.root = new TreeNode(nodes[0]);
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);

		int i = 1;

		while(i<nodes.length) {
			TreeNode curr = que.poll();
			if(i<nodes.length && nodes[i]!=0) {
				curr.left = new TreeNode(nodes[i]);
				curr.left.parent = curr;
				que.offer(curr.left);
			}
			i++;
			if(i<nodes.length && nodes[i]!=0) {
				curr.right = new TreeNode(nodes[i]);
				curr.right.parent = curr;
				que.offer(curr.right);
			}
			i++;
		}
		return root;
	}

	public TreeNode find(int value) {
		return search(this.root, value);
	}

	private TreeNode search(TreeNode curr, int value) {
		if(curr==null) return null;
		if(curr.data==value) return curr;
		TreeNode result = search(curr.left, value);
		if(result!=null) return result;
		else return search(curr.right, value);
	}
}