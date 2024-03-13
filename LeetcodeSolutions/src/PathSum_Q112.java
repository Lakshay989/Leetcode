class TreeNodeQ112 {
    int val;
    TreeNodeQ112 left;
    TreeNodeQ112 right;
    TreeNodeQ112() {}
    TreeNodeQ112(int val) { this.val = val; }
    TreeNodeQ112(int val, TreeNodeQ112 left, TreeNodeQ112 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class PathSum_Q112 {
    public boolean hasPathSum(TreeNodeQ112 root, int targetSum) {
        if(root == null){
            return false ;
        }
        targetSum-= root.val ;
        if(root.left == null && root.right == null){
            if(targetSum == 0){
                return true;
            }else{
                return false ;
            }
        }

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
    public static void main(String[] args) {
        // Test case 1: Target sum is 22
        //       5
        //      / \
        //     4   8
        //    /   / \
        //   11  13  4
        //  /  \      \
        // 7    2      1
        TreeNodeQ112 root1 = new TreeNodeQ112(5);
        root1.left = new TreeNodeQ112(4);
        root1.right = new TreeNodeQ112(8);
        root1.left.left = new TreeNodeQ112(11);
        root1.left.left.left = new TreeNodeQ112(7);
        root1.left.left.right = new TreeNodeQ112(2);
        root1.right.left = new TreeNodeQ112(13);
        root1.right.right = new TreeNodeQ112(4);
        root1.right.right.right = new TreeNodeQ112(1);
        int targetSum1 = 22;
        // Expected output: true (5 -> 4 -> 11 -> 2)
        System.out.println("Test case 1: " + (new PathSum_Q112().hasPathSum(root1, targetSum1) ? "Passed" : "Failed"));

        // Test case 2: Target sum is 1
        //       1
        //      / \
        //     2   3
        TreeNodeQ112 root2 = new TreeNodeQ112(1);
        root2.left = new TreeNodeQ112(2);
        root2.right = new TreeNodeQ112(3);
        int targetSum2 = 1;
        // Expected output: false (No path sums up to 1)
        System.out.println("Test case 2: " + (!new PathSum_Q112().hasPathSum(root2, targetSum2) ? "Passed" : "Failed"));

        // Test case 3: Target sum is 1
        //       1
        //      / \
        //     2   3
        TreeNodeQ112 root3 = new TreeNodeQ112(1);
        root3.left = new TreeNodeQ112(2);
        root3.right = new TreeNodeQ112(3);
        int targetSum3 = 4;
        // Expected output: true (1 -> 3)
        System.out.println("Test case 3: " + (new PathSum_Q112().hasPathSum(root3, targetSum3) ? "Passed" : "Failed"));
    }
}
