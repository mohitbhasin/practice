import java.util.*;

class SerializeAndDeserialize {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		// String serialized = serialize(tree.getTree());
		StringBuilder sb = new StringBuilder();
		serializePreOrder(tree.getTree(), sb);
		System.out.println(sb.toString());
		index = 0;
		String serial = sb.toString();
		TreeNode deserializedRoot = deserialize(serial.split(","));
		deserializedRoot.print(deserializedRoot);
	}

	public static void serializePreOrder(TreeNode root, StringBuilder sb) {
		if(root==null) {
			sb.append("null,");
			return;
		}
		sb.append(root.val+",");
		serializePreOrder(root.left, sb);
		serializePreOrder(root.right, sb);
	}

	static int index;

	public static TreeNode deserialize(String[] preorder) {
		if(preorder[index].equals("null")) {
			index++;
			return null;
		}

		TreeNode root = new TreeNode(Integer.parseInt(preorder[index]));
		index++;
		root.left = deserialize(preorder);
		root.right = deserialize(preorder);

		return root;
	}
}