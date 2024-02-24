
  //Definition for a binary tree node.
  class TreeNodeQ226 {
      int val;
      TreeNodeQ226 left;
      TreeNodeQ226 right;
      TreeNodeQ226() {}
      TreeNodeQ226(int val) { this.val = val; }

      TreeNodeQ226(int val, TreeNodeQ226 left, TreeNodeQ226 right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }


public class InvertBinaryTree_Q226 {
    public TreeNodeQ226 invertTree(TreeNodeQ226 root) {
        if(root == null){
            return root ;
        }
        else{
            invertTree(root.left) ;
            invertTree(root.right) ;

            TreeNodeQ226 temp = root.left ;
            root.left = root.right ;
            root.right = temp ;
        }
        return root ;
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNodeQ226 root = new TreeNodeQ226(1);
        root.left = new TreeNodeQ226(2);
        root.right = new TreeNodeQ226(3);
        root.left.left = new TreeNodeQ226(4);
        root.left.right = new TreeNodeQ226(5);
        root.right.left = new TreeNodeQ226(6);
        root.right.right = new TreeNodeQ226(7);

        InvertBinaryTree_Q226 solution = new InvertBinaryTree_Q226();

        // Invert the binary tree
        TreeNodeQ226 invertedRoot = solution.invertTree(root);

        // Display the inverted binary tree (you can use a traversal method)
        System.out.println("Inverted Binary Tree:");
        // Perform a traversal (e.g., in-order, pre-order, or post-order) to display the tree
        // For example, using in-order traversal:
        preOrderTraversal(invertedRoot);
    }

    // In-order traversal method (can use other traversal methods as needed)
    private static void preOrderTraversal(TreeNodeQ226 node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
}
