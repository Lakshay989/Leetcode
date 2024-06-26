import java.util.ArrayList;
import java.util.List;

class TreeNodeQ1382 {
    int val;
    TreeNodeQ1382 left;
    TreeNodeQ1382 right;
    TreeNodeQ1382() {}
    TreeNodeQ1382(int val) { this.val = val; }
    TreeNodeQ1382(int val, TreeNodeQ1382 left, TreeNodeQ1382 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BalanceABinarySearchTree_Q1382 {
    public TreeNodeQ1382 balanceBST(TreeNodeQ1382 root) {
        // Create a list to store the inorder traversal of the BST
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        // Construct and return the balanced BST
        return createBalancedBST(inorder, 0, inorder.size() - 1);
    }

    private void inorderTraversal(TreeNodeQ1382 root, List<Integer> inorder) {
        // Perform an inorder traversal to store the elements in sorted order
        if (root == null) return;
        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }

    private TreeNodeQ1382 createBalancedBST(
            List<Integer> inorder,
            int start,
            int end
    ) {
        // Base case: if the start index is greater than the end index, return null
        if (start > end) return null;

        // Find the middle element of the current range
        int mid = start + (end - start) / 2;

        // Recursively construct the left and right subtrees
        TreeNodeQ1382 leftSubtree = createBalancedBST(inorder, start, mid - 1);
        TreeNodeQ1382 rightSubtree = createBalancedBST(inorder, mid + 1, end);

        // Create a new node with the middle element and attach the subtrees
        TreeNodeQ1382 node = new TreeNodeQ1382(
                inorder.get(mid),
                leftSubtree,
                rightSubtree
        );
        return node;
    }

    public static void main(String[] args) {
        BalanceABinarySearchTree_Q1382 balancer = new BalanceABinarySearchTree_Q1382();

        // Test case 1: Single node tree
        TreeNodeQ1382 root1 = new TreeNodeQ1382(1);
        TreeNodeQ1382 balanced1 = balancer.balanceBST(root1);
        printTreeInOrder(balanced1); // Expected output: 1

        // Test case 2: Already balanced tree
        TreeNodeQ1382 root2 = new TreeNodeQ1382(2);
        root2.left = new TreeNodeQ1382(1);
        root2.right = new TreeNodeQ1382(3);
        TreeNodeQ1382 balanced2 = balancer.balanceBST(root2);
        printTreeInOrder(balanced2); // Expected output: 1 2 3

        // Test case 3: Unbalanced tree with a left-heavy structure
        TreeNodeQ1382 root3 = new TreeNodeQ1382(3);
        root3.left = new TreeNodeQ1382(2);
        root3.left.left = new TreeNodeQ1382(1);
        TreeNodeQ1382 balanced3 = balancer.balanceBST(root3);
        printTreeInOrder(balanced3); // Expected output: 1 2 3

        // Test case 4: Unbalanced tree with a right-heavy structure
        TreeNodeQ1382 root4 = new TreeNodeQ1382(1);
        root4.right = new TreeNodeQ1382(2);
        root4.right.right = new TreeNodeQ1382(3);
        TreeNodeQ1382 balanced4 = balancer.balanceBST(root4);
        printTreeInOrder(balanced4); // Expected output: 1 2 3

        // Test case 5: Complex unbalanced tree
        TreeNodeQ1382 root5 = new TreeNodeQ1382(1);
        root5.right = new TreeNodeQ1382(2);
        root5.right.right = new TreeNodeQ1382(3);
        root5.right.right.right = new TreeNodeQ1382(4);
        root5.right.right.right.right = new TreeNodeQ1382(5);
        TreeNodeQ1382 balanced5 = balancer.balanceBST(root5);
        printTreeInOrder(balanced5); // Expected output: 1 2 3 4 5

        // Test case 6: Large tree
        TreeNodeQ1382 root6 = new TreeNodeQ1382(10);
        root6.left = new TreeNodeQ1382(5);
        root6.right = new TreeNodeQ1382(15);
        root6.left.left = new TreeNodeQ1382(3);
        root6.left.right = new TreeNodeQ1382(7);
        root6.right.left = new TreeNodeQ1382(12);
        root6.right.right = new TreeNodeQ1382(18);
        TreeNodeQ1382 balanced6 = balancer.balanceBST(root6);
        printTreeInOrder(balanced6); // Expected output: 3 5 7 10 12 15 18
    }

    // Helper method to print the tree in-order (sorted order)
    private static void printTreeInOrder(TreeNodeQ1382 root) {
        if (root == null) return;
        printTreeInOrder(root.left);
        System.out.print(root.val + " ");
        printTreeInOrder(root.right);
        System.out.println();
    }
}
