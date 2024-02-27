class TreeNodeQ98 {
    int val;
    TreeNodeQ129 left;
    TreeNodeQ129 right;
    TreeNodeQ98() {}
    TreeNodeQ98(int val) { this.val = val; }
    TreeNodeQ98(int val, TreeNodeQ129 left, TreeNodeQ129 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class ValidateBinarySearchTree_Q98 {
    public boolean isValid(TreeNodeQ129 node, double left , double right){
        if(node == null){
            return true ;
        }
        if(!(node.val > left && node.val < right)){
            return false;
        }

        return isValid(node.left, left, node.val) && isValid(node.right, node.val, right) ;
    }
    public boolean isValidBST(TreeNodeQ129 root) {
        return isValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree_Q98 validator = new ValidateBinarySearchTree_Q98();

        // Test Case 1: Valid BST
        //     2
        //    / \
        //   1   3
        TreeNodeQ129 root1 = new TreeNodeQ129(2);
        root1.left = new TreeNodeQ129(1);
        root1.right = new TreeNodeQ129(3);
        System.out.println("Test Case 1: " + (validator.isValidBST(root1) ? "Passed" : "Failed"));

        // Test Case 2: Invalid BST
        //     5
        //    / \
        //   1   4
        //      / \
        //     3   6
        TreeNodeQ129 root2 = new TreeNodeQ129(5);
        root2.left = new TreeNodeQ129(1);
        root2.right = new TreeNodeQ129(4);
        root2.right.left = new TreeNodeQ129(3);
        root2.right.right = new TreeNodeQ129(6);
        System.out.println("Test Case 2: " + (!validator.isValidBST(root2) ? "Passed" : "Failed"));

        // Test Case 3: Valid BST
        //      10
        //     /  \
        //    5    15
        //        / \
        //       12  20
        TreeNodeQ129 root3 = new TreeNodeQ129(10);
        root3.left = new TreeNodeQ129(5);
        root3.right = new TreeNodeQ129(15);
        root3.right.left = new TreeNodeQ129(12);
        root3.right.right = new TreeNodeQ129(20);
        System.out.println("Test Case 3: " + (validator.isValidBST(root3) ? "Passed" : "Failed"));
    }

}
