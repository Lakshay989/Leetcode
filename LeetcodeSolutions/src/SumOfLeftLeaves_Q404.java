class TreeNodeQ404 {
    int val;
    TreeNodeQ404 left;
    TreeNodeQ404 right;
    TreeNodeQ404() {}
    TreeNodeQ404(int val) { this.val = val; }
    TreeNodeQ404(int val, TreeNodeQ404 left, TreeNodeQ404 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumOfLeftLeaves_Q404 {
    public int sumOfLeftLeaves(TreeNodeQ404 root) {
        return processSubtree(root, false);
    }

    private int processSubtree(TreeNodeQ404 subtree, boolean isLeft) {

        // Base case: This is an empty subtree.
        if (subtree == null) {
            return 0;
        }

        // Base case: This is a leaf node.
        if (subtree.left == null && subtree.right == null) {
            return isLeft ? subtree.val : 0;
        }

        // Recursive case: We need to add and return the results of the
        // left and right subtrees.
        return processSubtree(subtree.left, true) + processSubtree(subtree.right, false);
    }

    public static void main(String[] args) {
        // Construct the example binary tree
        TreeNodeQ404 root = new TreeNodeQ404(3);
        root.left = new TreeNodeQ404(9);
        root.right = new TreeNodeQ404(20);
        root.right.left = new TreeNodeQ404(15);
        root.right.right = new TreeNodeQ404(7);

        // Create an instance of SumOfLeftLeaves_Q404
        SumOfLeftLeaves_Q404 solution = new SumOfLeftLeaves_Q404();

        // Test the sumOfLeftLeaves method
        int result = solution.sumOfLeftLeaves(root);
        System.out.println("Sum of left leaves: " + result);
        // Expected output: 24 (9 + 15)
    }
}
