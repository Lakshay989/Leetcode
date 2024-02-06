// Definition for a binary tree node.
class TreeNodeQ543 {
    int val;
    TreeNodeQ543 left;
    TreeNodeQ543 right;
    TreeNodeQ543() {}
    TreeNodeQ543(int val) { this.val = val; }
    TreeNodeQ543(int val, TreeNodeQ543 left, TreeNodeQ543 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DiameterOfBinaryTree_Q543 {
    private int diameter;
    public int diameterOfBinaryTree(TreeNodeQ543 root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }
    private int longestPath(TreeNodeQ543 node){
        if(node == null) return 0;
        // recursively find the longest path in
        // both left child and right child
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        // update the diameter if left_path plus right_path is larger
        diameter = Math.max(diameter, leftPath + rightPath);

        // return the longest one between left_path and right_path;
        // remember to add 1 for the path connecting the node and its parent
        return Math.max(leftPath, rightPath) + 1;
    }

    public static void main(String[] args) {
        // Test Case 1: Balanced binary tree with diameter 3
        TreeNodeQ543 root1 = new TreeNodeQ543(1);
        root1.left = new TreeNodeQ543(2);
        root1.right = new TreeNodeQ543(3);
        root1.left.left = new TreeNodeQ543(4);
        root1.left.right = new TreeNodeQ543(5);
        root1.right.left = new TreeNodeQ543(6);
        root1.right.right = new TreeNodeQ543(7);

        // Test Case 2: Skewed binary tree with diameter 4
        TreeNodeQ543 root2 = new TreeNodeQ543(1);
        root2.left = null;
        root2.right = new TreeNodeQ543(2);
        root2.right.right = new TreeNodeQ543(3);
        root2.right.right.right = new TreeNodeQ543(4);
        root2.right.right.right.right = new TreeNodeQ543(5);

        // Test Case 3: Single node binary tree with diameter 0
        TreeNodeQ543 root3 = new TreeNodeQ543(1);

        DiameterOfBinaryTree_Q543 solution = new DiameterOfBinaryTree_Q543();

        // Calculate diameter for each test case
        int diameter1 = solution.diameterOfBinaryTree(root1);
        int diameter2 = solution.diameterOfBinaryTree(root2);
        int diameter3 = solution.diameterOfBinaryTree(root3);

        // Display results
        System.out.println("Test Case 1: Diameter of Binary Tree: " + diameter1);
        System.out.println("Test Case 2: Diameter of Binary Tree: " + diameter2);
        System.out.println("Test Case 3: Diameter of Binary Tree: " + diameter3);
    }
}
