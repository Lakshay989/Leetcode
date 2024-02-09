class TreeNodeQ572 {
    int val;
    TreeNodeQ572 left;
    TreeNodeQ572 right;

    TreeNodeQ572() {
    }

    TreeNodeQ572(int val) {
        this.val = val;
    }

    TreeNodeQ572(int val, TreeNodeQ572 left, TreeNodeQ572 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class SubtreeOfAnotherTree_Q572 {
    public boolean isSubtree(TreeNodeQ572 root, TreeNodeQ572 subRoot) {
        // If this node is Empty, then no tree is rooted at this Node
        // Hence, "tree rooted at node" cannot be equal to "tree rooted at subRoot"
        // "tree rooted at subRoot" will always be non-empty, as per constraints
        if (root == null) {
            return false;
        }

        // Check if the "tree rooted at root" is identical to "tree roooted at subRoot"
        if (isIdentical(root, subRoot)) {
            return true;
        }

        // If not, check for "tree rooted at root.left" and "tree rooted at root.right"
        // If either of them returns true, return true
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNodeQ572 node1, TreeNodeQ572 node2) {

        // If any of the nodes is null, then both must be null
        if (node1 == null || node2 == null) {
            return node1 == null && node2 == null;
        }

        // If both nodes are non-empty, then they are identical only if
        // 1. Their values are equal
        // 2. Their left subtrees are identical
        // 3. Their right subtrees are identical
        return node1.val == node2.val && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }
    public static void main(String[] args) {
        SubtreeOfAnotherTree_Q572 solution = new SubtreeOfAnotherTree_Q572();

        // Test Case 1: Subtree exists
        TreeNodeQ572 root1 = new TreeNodeQ572(3);
        root1.left = new TreeNodeQ572(4);
        root1.right = new TreeNodeQ572(5);
        root1.left.left = new TreeNodeQ572(1);
        root1.left.right = new TreeNodeQ572(2);

        TreeNodeQ572 subRoot1 = new TreeNodeQ572(4);
        subRoot1.left = new TreeNodeQ572(1);
        subRoot1.right = new TreeNodeQ572(2);

        System.out.println("Test Case 1: " + (solution.isSubtree(root1, subRoot1) ? "Passed" : "Failed"));

        // Test Case 2: Subtree does not exist
        TreeNodeQ572 root2 = new TreeNodeQ572(3);
        root2.left = new TreeNodeQ572(4);
        root2.right = new TreeNodeQ572(5);
        root2.left.left = new TreeNodeQ572(1);
        root2.left.right = new TreeNodeQ572(2);
        root2.left.right.left = new TreeNodeQ572(0);

        TreeNodeQ572 subRoot2 = new TreeNodeQ572(4);
        subRoot2.left = new TreeNodeQ572(1);
        subRoot2.right = new TreeNodeQ572(2);

        System.out.println("Test Case 2: " + (!solution.isSubtree(root2, subRoot2) ? "Passed" : "Failed"));
    }
}
