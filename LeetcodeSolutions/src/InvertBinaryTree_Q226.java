
  //Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNodeQ543 left;
      TreeNodeQ543 right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }TreeNode(int val, TreeNodeQ543 left, TreeNodeQ543 right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }


public class InvertBinaryTree_Q226 {
    public TreeNodeQ543 invertTree(TreeNodeQ543 root) {
        if(root == null){
            return root ;
        }
        else{
            invertTree(root.left) ;
            invertTree(root.right) ;

            TreeNodeQ543 temp = root.left ;
            root.left = root.right ;
            root.right = temp ;
        }
        return root ;
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNodeQ543 root = new TreeNodeQ543(1);
        root.left = new TreeNodeQ543(2);
        root.right = new TreeNodeQ543(3);
        root.left.left = new TreeNodeQ543(4);
        root.left.right = new TreeNodeQ543(5);
        root.right.left = new TreeNodeQ543(6);
        root.right.right = new TreeNodeQ543(7);

        InvertBinaryTree_Q226 solution = new InvertBinaryTree_Q226();

        // Invert the binary tree
        TreeNodeQ543 invertedRoot = solution.invertTree(root);

        // Display the inverted binary tree (you can use a traversal method)
        System.out.println("Inverted Binary Tree:");
        // Perform a traversal (e.g., in-order, pre-order, or post-order) to display the tree
        // For example, using in-order traversal:
        preOrderTraversal(invertedRoot);
    }

    // In-order traversal method (can use other traversal methods as needed)
    private static void preOrderTraversal(TreeNodeQ543 node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
}
