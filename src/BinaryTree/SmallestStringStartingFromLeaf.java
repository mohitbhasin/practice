class SmallestStringStartingFromLeaf {
	public static void main(String args[]) {
		TreeNode tree = new TreeNode();
		TreeNode root = tree.getTree();
		System.out.println(smallestFromLeaf(root));
	}

	static String smallestString;
    public static String smallestFromLeaf(TreeNode root) {
        if(root==null) return "";

        smallestString="";
        preorder(root, "");
        return smallestString;
    }
    public static void preorder(TreeNode root, String currString) {
        if(root==null) return;
        currString=(char) ('a' + root.val)+currString;
        if(root.left==null && root.right==null) {
            if(smallestString.isEmpty()) smallestString = currString;
            //  the below string function compareTo() can also be used instead of defining a new own function
            // if(currString.compareTo(smallestString) < 0) {
            // 	smallestString=currString;
            // }
            compare(currString);
            return;
        }
        preorder(root.left, currString);
        preorder(root.right, currString);
    }

    public static void compare(String currString) {
        int i=0;
        while(i<smallestString.length() && i<currString.length()) {
            if(currString.charAt(i)<smallestString.charAt(i)) {
                smallestString=currString;
                return;
            }
            else if(currString.charAt(i)>smallestString.charAt(i)) {
                return;
            }
            i++;
        }
        if(currString.length()<smallestString.length()) {
            smallestString=currString;
        }
    }
}