class TreeNodeQ1325 {
    int val;
    TreeNodeQ1325 left;
    TreeNodeQ1325 right;
    TreeNodeQ1325() {}
    TreeNodeQ1325(int val) { this.val = val; }
    TreeNodeQ1325(int val, TreeNodeQ1325 left, TreeNodeQ1325 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DeleteLeavesWithAGivenValue_Q1325 {
    public TreeNodeQ1325 removeLeafNodes(TreeNodeQ1325 root, int target) {

        if(root == null) return null;

        root.left = removeLeafNodes(root.left, target) ;
        root.right = removeLeafNodes(root.right, target);

        if(root.val == target && root.left == null && root.right == null) return null ;

        return root ;
    }


    public static void main(String[] args) {
        DeleteLeavesWithAGivenValue_Q1325 solution = new DeleteLeavesWithAGivenValue_Q1325();

        // Create a test tree:
        //       1
        //      / \
        //     2   3
        //    /   / \
        //   2   2   4
        //  / \
        // 2   2
        TreeNodeQ1325 root = new TreeNodeQ1325(1);
        root.left = new TreeNodeQ1325(2, new TreeNodeQ1325(2, new TreeNodeQ1325(2), new TreeNodeQ1325(2)), null);
        root.right = new TreeNodeQ1325(3, new TreeNodeQ1325(2), new TreeNodeQ1325(4));

        int target = 2;
        TreeNodeQ1325 newRoot = solution.removeLeafNodes(root, target);

        // Print the modified tree
        printTree(newRoot);
    }

    public static void printTree(TreeNodeQ1325 root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
}
