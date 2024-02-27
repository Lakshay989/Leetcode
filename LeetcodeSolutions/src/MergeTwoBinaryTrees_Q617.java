class TreeNodeQ617 {
    int val;
    TreeNodeQ129 left;
    TreeNodeQ129 right;
    TreeNodeQ617() {}
    TreeNodeQ617(int val) { this.val = val; }
    TreeNodeQ617(int val, TreeNodeQ129 left, TreeNodeQ129 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class MergeTwoBinaryTrees_Q617 {
    public TreeNodeQ129 mergeTrees(TreeNodeQ129 root1, TreeNodeQ129 root2) {
        TreeNodeQ129 node = new TreeNodeQ129() ;

        if(root1 == null && root2 == null){
            return null;
        }
        else if(root1==null && root2!=null){
            return root2;
        }
        else if(root1!=null && root2==null){
            return root1;
        }
        else{

            int val1 = root1 != null ? root1.val : 0 ;
            int val2 = root2 != null ? root2.val : 0 ;
            node = new TreeNodeQ129(val1 + val2);

            node.left = mergeTrees(root1 != null ?root1.left : null, root2 != null ?root2.left : null);
            node.right = mergeTrees(root1 != null ?root1.right : null, root2 != null ?root2.right : null);
        }
        return node ;
    }
    public static void main(String[] args) {
        MergeTwoBinaryTrees_Q617 solution = new MergeTwoBinaryTrees_Q617();

        // Test Case 1: General case
        TreeNodeQ129 root1 = new TreeNodeQ129(1);
        root1.left = new TreeNodeQ129(3);
        root1.right = new TreeNodeQ129(2);
        root1.left.left = new TreeNodeQ129(5);

        TreeNodeQ129 root2 = new TreeNodeQ129(2);
        root2.left = new TreeNodeQ129(1);
        root2.right = new TreeNodeQ129(3);
        root2.left.right = new TreeNodeQ129(4);
        root2.right.right = new TreeNodeQ129(7);

        TreeNodeQ129 expected1 = new TreeNodeQ129(3);
        expected1.left = new TreeNodeQ129(4);
        expected1.right = new TreeNodeQ129(5);
        expected1.left.left = new TreeNodeQ129(5);
        expected1.left.right = new TreeNodeQ129(4);
        expected1.right.right = new TreeNodeQ129(7);

        System.out.println("Test Case 1: " + (isSameTree(solution.mergeTrees(root1, root2), expected1) ? "Check" : "Error"));

        // Test Case 2: One tree is null
        TreeNodeQ129 root3 = null;
        TreeNodeQ129 root4 = new TreeNodeQ129(1);
        TreeNodeQ129 expected2 = new TreeNodeQ129(1);

        System.out.println("Test Case 2: " + (isSameTree(solution.mergeTrees(root3, root4), expected2) ? "Check" : "Error"));

        // Test Case 3: Both trees are null
        TreeNodeQ129 root5 = null;
        TreeNodeQ129 root6 = null;

        System.out.println("Test Case 3: " + (solution.mergeTrees(root5, root6) == null ? "Check" : "Error"));
    }

    // Helper method to check if two binary trees are the same
    private static boolean isSameTree(TreeNodeQ129 p, TreeNodeQ129 q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
