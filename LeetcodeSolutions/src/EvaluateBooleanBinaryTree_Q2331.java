class TreeNodeQ2331 {
    int val;
    TreeNodeQ2331 left;
    TreeNodeQ2331 right;
    TreeNodeQ2331() {}
    TreeNodeQ2331(int val) { this.val = val; }
    TreeNodeQ2331(int val, TreeNodeQ2331 left, TreeNodeQ2331 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class EvaluateBooleanBinaryTree_Q2331 {
    public boolean evaluateTree(TreeNodeQ2331 root) {
        // Handles the case for leaf nodes.
        if (root.left == null && root.right == null) {
            return root.val != 0;
        }

        // Store the evaluations for the left subtree and right subtree.
        boolean evaluateLeftSubtree = evaluateTree(root.left);
        boolean evaluateRightSubtree = evaluateTree(root.right);
        boolean evaluateRoot;
        if (root.val == 2) {
            evaluateRoot = evaluateLeftSubtree | evaluateRightSubtree;
        } else {
            evaluateRoot = evaluateLeftSubtree & evaluateRightSubtree;
        }

        return evaluateRoot;
    }

    public static void main(String[] args) {
        EvaluateBooleanBinaryTree_Q2331 evaluator = new EvaluateBooleanBinaryTree_Q2331();

        // Test Case 1: A single leaf node with value 0 (false)
        TreeNodeQ2331 testCase1 = new TreeNodeQ2331(0);
        boolean result1 = evaluator.evaluateTree(testCase1);
        System.out.println("Test Case 1: Expected: false, Result: " + result1);

        // Test Case 2: A single leaf node with value 1 (true)
        TreeNodeQ2331 testCase2 = new TreeNodeQ2331(1);
        boolean result2 = evaluator.evaluateTree(testCase2);
        System.out.println("Test Case 2: Expected: true, Result: " + result2);

        // Test Case 3: A tree with a root OR operation (2) and two leaf nodes with values 1 and 0
        TreeNodeQ2331 testCase3 = new TreeNodeQ2331(2, new TreeNodeQ2331(1), new TreeNodeQ2331(0));
        boolean result3 = evaluator.evaluateTree(testCase3);
        System.out.println("Test Case 3: Expected: true, Result: " + result3);

        // Test Case 4: A tree with a root AND operation (3) and two leaf nodes with values 1 and 0
        TreeNodeQ2331 testCase4 = new TreeNodeQ2331(3, new TreeNodeQ2331(1), new TreeNodeQ2331(0));
        boolean result4 = evaluator.evaluateTree(testCase4);
        System.out.println("Test Case 4: Expected: false, Result: " + result4);

        // Test Case 5: A more complex tree with mixed operations
        TreeNodeQ2331 leftSubtree = new TreeNodeQ2331(2, new TreeNodeQ2331(1), new TreeNodeQ2331(0));
        TreeNodeQ2331 rightSubtree = new TreeNodeQ2331(3, new TreeNodeQ2331(1), new TreeNodeQ2331(1));
        TreeNodeQ2331 testCase5 = new TreeNodeQ2331(3, leftSubtree, rightSubtree);
        boolean result5 = evaluator.evaluateTree(testCase5);
        System.out.println("Test Case 5: Expected: true, Result: " + result5);

        // Additional test cases can be added here to cover more scenarios.
    }
}
