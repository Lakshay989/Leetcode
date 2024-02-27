class TreeNodeQ108 {
    int val;
    TreeNodeQ129 left;
    TreeNodeQ129 right;
    TreeNodeQ108() {}
    TreeNodeQ108(int val) { this.val = val; }
    TreeNodeQ108(int val, TreeNodeQ129 left, TreeNodeQ129 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConvertSortedArrayToBinarySearchTree_Q108 {
    int[] nums;
    public TreeNodeQ129 helper(int left, int right){
        if (left > right){
            return null ;
        }
        int mid = (left + right) /2 ;

        TreeNodeQ129 root = new TreeNodeQ129(nums[mid]);
        root.left = helper(left, mid -1);
        root.right = helper(mid + 1, right);
        return root ;
    }
    public TreeNodeQ129 sortedArrayToBST(int[] nums) {
        this.nums = nums ;
        return helper(0, nums.length-1) ;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree_Q108 solution = new ConvertSortedArrayToBinarySearchTree_Q108();

        // Test Case 2: General case with sorted array of even length
        int[] nums2 = {1, 2, 3, 4};
        TreeNodeQ129 root2 = solution.sortedArrayToBST(nums2);
        // Check if the tree is balanced
        boolean isBalanced2 = isBalanced(root2);
        System.out.println("Test Case 2: " + (isBalanced2 ? "Check" : "Error"));

        // Test Case 3: General case with sorted array of odd length
        int[] nums3 = {1, 2, 3, 4, 5};
        TreeNodeQ129 root3 = solution.sortedArrayToBST(nums3);
        // Check if the tree is balanced
        boolean isBalanced3 = isBalanced(root3);
        System.out.println("Test Case 3: " + (isBalanced3 ? "Check" : "Error"));
    }

    // Helper method to check if a binary tree is balanced
    private static boolean isBalanced(TreeNodeQ129 node) {
        if (node == null) {
            return true;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    // Helper method to calculate the height of a binary tree
    private static int getHeight(TreeNodeQ129 node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
