
  //Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNodeQ104 left;
      TreeNodeQ104 right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }TreeNode(int val, TreeNodeQ104 left, TreeNodeQ104 right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }


public class InvertBinaryTree_Q226 {
    public TreeNodeQ104 invertTree(TreeNodeQ104 root) {
        if(root == null){
            return root ;
        }
        else{
            invertTree(root.left) ;
            invertTree(root.right) ;

            TreeNodeQ104 temp = root.left ;
            root.left = root.right ;
            root.right = temp ;
        }
        return root ;
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNodeQ104 root = new TreeNodeQ104(1);
        root.left = new TreeNodeQ104(2);
        root.right = new TreeNodeQ104(3);
        root.left.left = new TreeNodeQ104(4);
        root.left.right = new TreeNodeQ104(5);
        root.right.left = new TreeNodeQ104(6);
        root.right.right = new TreeNodeQ104(7);

        InvertBinaryTree_Q226 solution = new InvertBinaryTree_Q226();

        // Invert the binary tree
        TreeNodeQ104 invertedRoot = solution.invertTree(root);

        // Display the inverted binary tree (you can use a traversal method)
        System.out.println("Inverted Binary Tree:");
        // Perform a traversal (e.g., in-order, pre-order, or post-order) to display the tree
        // For example, using in-order traversal:
        preOrderTraversal(invertedRoot);
    }

    // In-order traversal method (can use other traversal methods as needed)
    private static void preOrderTraversal(TreeNodeQ104 node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
}
