class ConvertSortedArrayToBinarySearchTree {
	public static void main(String args[]) {
		int[] nums = {-10,-3,0,5,9};
		TreeNode result = sortedArrayToBST(nums);
		result.print(result);
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }
    
    public static TreeNode construct(int[] nums, int left, int right) {
        if(left>right) return null;
        
        int mid = (left + right) / 2;
        
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = construct(nums, left, mid-1);
        root.right = construct(nums, mid+1, right);
        
        return root;
    }
}