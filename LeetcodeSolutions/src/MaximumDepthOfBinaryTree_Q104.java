
 // Definition for a binary tree node.
   class TreeNodeQ104 {
      int val;
      TreeNodeQ104 left;
      TreeNodeQ104 right;
      TreeNodeQ104() {}
      TreeNodeQ104(int val) { this.val = val; }
      TreeNodeQ104(int val, TreeNodeQ104 left, TreeNodeQ104 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}


public class MaximumDepthOfBinaryTree_Q104 {
    public int maxDepth(TreeNodeQ104 root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNodeQ104 root = new TreeNodeQ104(1);
        root.left = new TreeNodeQ104(2);
        root.right = new TreeNodeQ104(3);
        root.left.left = new TreeNodeQ104(4);
        root.left.right = new TreeNodeQ104(5);
        root.right.right = new TreeNodeQ104(6);

        MaximumDepthOfBinaryTree_Q104 solution = new MaximumDepthOfBinaryTree_Q104();

        // Find the maximum depth of the binary tree
        int maxDepth = solution.maxDepth(root);

        // Display the result
        System.out.println("Maximum Depth of Binary Tree: " + maxDepth);
    }
}
