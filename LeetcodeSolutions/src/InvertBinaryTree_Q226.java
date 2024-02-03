
  //Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }


public class InvertBinaryTree_Q226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root ;
        }
        else{
            invertTree(root.left) ;
            invertTree(root.right) ;

            TreeNode temp = root.left ;
            root.left = root.right ;
            root.right = temp ;
        }
        return root ;
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        InvertBinaryTree_Q226 solution = new InvertBinaryTree_Q226();

        // Invert the binary tree
        TreeNode invertedRoot = solution.invertTree(root);

        // Display the inverted binary tree (you can use a traversal method)
        System.out.println("Inverted Binary Tree:");
        // Perform a traversal (e.g., in-order, pre-order, or post-order) to display the tree
        // For example, using in-order traversal:
        preOrderTraversal(invertedRoot);
    }

    // In-order traversal method (can use other traversal methods as needed)
    private static void preOrderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
}
