class TreeNodeQ129 {
    int val;
    TreeNodeQ129 left;
    TreeNodeQ129 right;
    TreeNodeQ129() {}
    TreeNodeQ129(int val) { this.val = val; }
    TreeNodeQ129(int val, TreeNodeQ129 left, TreeNodeQ129 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumRootToLeafNumbers_Q129 {
    int dfs(TreeNodeQ129 node, int sum){
        if(node == null){
            return 0 ;
        }

        sum = sum *10 + node.val ;

        if(node.left == null && node.right == null){
            return sum ;
        }

        return dfs(node.left , sum) + dfs(node.right, sum) ;
    }
    public int sumNumbers(TreeNodeQ129 root) {
        return dfs(root, 0) ;
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers_Q129 calculator = new SumRootToLeafNumbers_Q129();

        // Test Case 1: Valid tree with single digit numbers
        //     1
        //    / \
        //   2   3
        TreeNodeQ129 root1 = new TreeNodeQ129(1);
        root1.left = new TreeNodeQ129(2);
        root1.right = new TreeNodeQ129(3);
        System.out.println("Test Case 1: " + (calculator.sumNumbers(root1) == 25 ? "Passed" : "Failed"));

        // Test Case 2: Valid tree with double digit numbers
        //      4
        //     / \
        //    9   0
        //   / \
        //  5   1
        TreeNodeQ129 root2 = new TreeNodeQ129(4);
        root2.left = new TreeNodeQ129(9);
        root2.right = new TreeNodeQ129(0);
        root2.left.left = new TreeNodeQ129(5);
        root2.left.right = new TreeNodeQ129(1);
        System.out.println("Test Case 2: " + (calculator.sumNumbers(root2) == 1026 ? "Passed" : "Failed"));

        // Test Case 3: Empty tree
        System.out.println("Test Case 3: " + (calculator.sumNumbers(null) == 0 ? "Passed" : "Failed"));
    }
}
