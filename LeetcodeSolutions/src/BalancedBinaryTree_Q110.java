// Definition for a binary tree node.
class TreeNodeQ110 {
    int val;
    TreeNodeQ110 left;
    TreeNodeQ110 right;
    TreeNodeQ110() {}
    TreeNodeQ110(int val) { this.val = val; }
    TreeNodeQ110(int val, TreeNodeQ110 left, TreeNodeQ110 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BalancedBinaryTree_Q110 {
    public boolean isBalanced(TreeNodeQ110 root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNodeQ110 node) {
        if (node == null) return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        // left, right subtree is unbalanced or cur tree is unbalanced
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree_Q110 solution = new BalancedBinaryTree_Q110();

        // Test Case 1: Balanced binary tree
        TreeNodeQ110 root1 = new TreeNodeQ110(1);
        root1.left = new TreeNodeQ110(2);
        root1.right = new TreeNodeQ110(3);
        root1.left.left = new TreeNodeQ110(4);
        root1.left.right = new TreeNodeQ110(5);
        root1.right.right = new TreeNodeQ110(6);

        System.out.println("Test Case 1: " + (solution.isBalanced(root1) ? "Passed" : "Failed"));

        // Test Case 2: Unbalanced binary tree
        TreeNodeQ110 root2 = new TreeNodeQ110(1);
        root2.left = new TreeNodeQ110(2);
        root2.left.left = new TreeNodeQ110(3);
        root2.left.left.left = new TreeNodeQ110(4);

        System.out.println("Test Case 2: " + (!solution.isBalanced(root2) ? "Passed" : "Failed"));
    }
}
