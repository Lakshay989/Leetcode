import java.util.Stack;

class TreeNodeQ1038 {
    int val;
    TreeNodeQ1038 left;
    TreeNodeQ1038 right;
    TreeNodeQ1038() {}
    TreeNodeQ1038(int val) { this.val = val; }
    TreeNodeQ1038(int val, TreeNodeQ1038 left, TreeNodeQ1038 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTreeToGreaterSumTree_Q1038 {
    public TreeNodeQ1038 bstToGst(TreeNodeQ1038 root) {
        int nodeSum = 0;
        Stack<TreeNodeQ1038> st = new Stack<>();
        TreeNodeQ1038 node = root;

        while (!st.empty() || node != null) {
            while (node != null) {
                st.push(node);
                node = node.right;
            }

            // Store the top value of stack in node and pop it.
            node = st.pop();

            // Update value of node.
            nodeSum += node.val;
            node.val = nodeSum;

            // Move to the left child of node.
            node = node.left;
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTreeToGreaterSumTree_Q1038 converter = new BinarySearchTreeToGreaterSumTree_Q1038();

        // Test case 1: Single node tree
        TreeNodeQ1038 root1 = new TreeNodeQ1038(1);
        TreeNodeQ1038 gst1 = converter.bstToGst(root1);
        printTreeInOrder(gst1); // Expected output: 1

        // Test case 2: Simple tree with two levels
        TreeNodeQ1038 root2 = new TreeNodeQ1038(2, new TreeNodeQ1038(1), new TreeNodeQ1038(3));
        TreeNodeQ1038 gst2 = converter.bstToGst(root2);
        printTreeInOrder(gst2); // Expected output: 5 5 3 (nodes with values 2 and 3 swapped to 5 and 3, respectively)

        // Test case 3: Larger tree
        TreeNodeQ1038 root3 = new TreeNodeQ1038(4);
        root3.left = new TreeNodeQ1038(1, null, new TreeNodeQ1038(2));
        root3.right = new TreeNodeQ1038(6, new TreeNodeQ1038(5), new TreeNodeQ1038(7, null, new TreeNodeQ1038(8)));
        TreeNodeQ1038 gst3 = converter.bstToGst(root3);
        printTreeInOrder(gst3); // Expected output: 36 36 35 33 30 26 21 15 8

        // Test case 4: Unbalanced tree
        TreeNodeQ1038 root4 = new TreeNodeQ1038(3);
        root4.left = new TreeNodeQ1038(2);
        root4.left.left = new TreeNodeQ1038(1);
        root4.right = new TreeNodeQ1038(5);
        root4.right.left = new TreeNodeQ1038(4);
        root4.right.right = new TreeNodeQ1038(6);
        TreeNodeQ1038 gst4 = converter.bstToGst(root4);
        printTreeInOrder(gst4); // Expected output: 21 20 18 15 11 6

        // Test case 5: Empty tree
        TreeNodeQ1038 root5 = null;
        TreeNodeQ1038 gst5 = converter.bstToGst(root5);
        printTreeInOrder(gst5); // Expected output: (empty)

        // Test case 6: Tree with duplicate values
        TreeNodeQ1038 root6 = new TreeNodeQ1038(2, new TreeNodeQ1038(2), new TreeNodeQ1038(2));
        TreeNodeQ1038 gst6 = converter.bstToGst(root6);
        printTreeInOrder(gst6); // Expected output: 6 6 4
    }

    // Helper method to print the tree in-order
    private static void printTreeInOrder(TreeNodeQ1038 root) {
        if (root == null) return;
        printTreeInOrder(root.left);
        System.out.print(root.val + " ");
        printTreeInOrder(root.right);
        System.out.println();
    }
}
