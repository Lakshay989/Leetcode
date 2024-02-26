class TreeNodeQ617 {
    int val;
    TreeNodeQ98 left;
    TreeNodeQ98 right;
    TreeNodeQ617() {}
    TreeNodeQ617(int val) { this.val = val; }
    TreeNodeQ617(int val, TreeNodeQ98 left, TreeNodeQ98 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class MergeTwoBinaryTrees_Q617 {
    public TreeNodeQ98 mergeTrees(TreeNodeQ98 root1, TreeNodeQ98 root2) {
        TreeNodeQ98 node = new TreeNodeQ98() ;

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
            node = new TreeNodeQ98(val1 + val2);

            node.left = mergeTrees(root1 != null ?root1.left : null, root2 != null ?root2.left : null);
            node.right = mergeTrees(root1 != null ?root1.right : null, root2 != null ?root2.right : null);
        }
        return node ;
    }
    public static void main(String[] args) {
        MergeTwoBinaryTrees_Q617 solution = new MergeTwoBinaryTrees_Q617();

        // Test Case 1: General case
        TreeNodeQ98 root1 = new TreeNodeQ98(1);
        root1.left = new TreeNodeQ98(3);
        root1.right = new TreeNodeQ98(2);
        root1.left.left = new TreeNodeQ98(5);

        TreeNodeQ98 root2 = new TreeNodeQ98(2);
        root2.left = new TreeNodeQ98(1);
        root2.right = new TreeNodeQ98(3);
        root2.left.right = new TreeNodeQ98(4);
        root2.right.right = new TreeNodeQ98(7);

        TreeNodeQ98 expected1 = new TreeNodeQ98(3);
        expected1.left = new TreeNodeQ98(4);
        expected1.right = new TreeNodeQ98(5);
        expected1.left.left = new TreeNodeQ98(5);
        expected1.left.right = new TreeNodeQ98(4);
        expected1.right.right = new TreeNodeQ98(7);

        System.out.println("Test Case 1: " + (isSameTree(solution.mergeTrees(root1, root2), expected1) ? "Check" : "Error"));

        // Test Case 2: One tree is null
        TreeNodeQ98 root3 = null;
        TreeNodeQ98 root4 = new TreeNodeQ98(1);
        TreeNodeQ98 expected2 = new TreeNodeQ98(1);

        System.out.println("Test Case 2: " + (isSameTree(solution.mergeTrees(root3, root4), expected2) ? "Check" : "Error"));

        // Test Case 3: Both trees are null
        TreeNodeQ98 root5 = null;
        TreeNodeQ98 root6 = null;

        System.out.println("Test Case 3: " + (solution.mergeTrees(root5, root6) == null ? "Check" : "Error"));
    }

    // Helper method to check if two binary trees are the same
    private static boolean isSameTree(TreeNodeQ98 p, TreeNodeQ98 q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
