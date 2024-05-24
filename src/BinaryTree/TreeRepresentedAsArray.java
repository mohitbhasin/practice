import java.util.*;

class TreeRepresentedAsArray {
	public static void main(String args[]) {
		TreeNodeDefault t = new TreeNodeDefault(1);

		representInArrayList(t.getTree());
	}

	public static void representInArrayList(TreeNodeDefault t) {
		int[] result = new int[15];
		inorder(t, result, 0);
		for(int i: result) {
			System.out.print(i+"\t");
		}
	}

	public static void inorder(TreeNodeDefault t, int[] result, int index) {
		if(t==null) {
			return;
		}
		if(t.left!=null) {
			inorder(t.left, result, (2*index+1));
		}
		result[index] = t.val;
		if(t.right!=null) {
			inorder(t.right, result, (2*index+2));
		}
	}
}