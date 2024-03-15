class TreeNodeQ124 {
    int val;
    TreeNodeQ124 left;
    TreeNodeQ124 right;
    TreeNodeQ124() {}
    TreeNodeQ124(int val) { this.val = val; }
    TreeNodeQ124(int val, TreeNodeQ124 left, TreeNodeQ124 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeMaximumPathSum_Q124 {
    int result = Integer.MIN_VALUE ;
    public int maxPathSum(TreeNodeQ124 root) {
        dfs(root);
        return result ;

    }
    public int dfs(TreeNodeQ124 node){
        if(node == null){
            return 0 ;
        }

        int leftMax = Integer.max(dfs(node.left), 0);
        int rightMax = Integer.max(dfs(node.right), 0);

        result = Math.max(result, leftMax + rightMax + node.val);

        return Math.max(leftMax + node.val, rightMax + node.val);
    }

    public static void main(String[] args) {
        // Create a binary tree
        TreeNodeQ124 root = new TreeNodeQ124(-10);
        root.left = new TreeNodeQ124(9);
        root.right = new TreeNodeQ124(20);
        root.right.left = new TreeNodeQ124(15);
        root.right.right = new TreeNodeQ124(7);

        // Create an instance of the BinaryTreeMaximumPathSum_Q124 class
        BinaryTreeMaximumPathSum_Q124 solution = new BinaryTreeMaximumPathSum_Q124();

        // Test the maxPathSum method
        int maxSum = solution.maxPathSum(root);
        System.out.println("Maximum path sum: " + maxSum); // Expected output: 42
    }
}
