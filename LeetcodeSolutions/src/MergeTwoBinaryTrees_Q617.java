class TreeNodeQ617 {
    int val;
    TreeNodeQ108 left;
    TreeNodeQ108 right;
    TreeNodeQ617() {}
    TreeNodeQ617(int val) { this.val = val; }
    TreeNodeQ617(int val, TreeNodeQ108 left, TreeNodeQ108 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class MergeTwoBinaryTrees_Q617 {
    public TreeNodeQ108 mergeTrees(TreeNodeQ108 root1, TreeNodeQ108 root2) {
        TreeNodeQ108 node = new TreeNodeQ108() ;

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
            node = new TreeNodeQ108(val1 + val2);

            node.left = mergeTrees(root1 != null ?root1.left : null, root2 != null ?root2.left : null);
            node.right = mergeTrees(root1 != null ?root1.right : null, root2 != null ?root2.right : null);
        }
        return node ;
    }
    public static void main(String[] args) {
        MergeTwoBinaryTrees_Q617 solution = new MergeTwoBinaryTrees_Q617();

        // Test Case 1: General case
        TreeNodeQ108 root1 = new TreeNodeQ108(1);
        root1.left = new TreeNodeQ108(3);
        root1.right = new TreeNodeQ108(2);
        root1.left.left = new TreeNodeQ108(5);

        TreeNodeQ108 root2 = new TreeNodeQ108(2);
        root2.left = new TreeNodeQ108(1);
        root2.right = new TreeNodeQ108(3);
        root2.left.right = new TreeNodeQ108(4);
        root2.right.right = new TreeNodeQ108(7);

        TreeNodeQ108 expected1 = new TreeNodeQ108(3);
        expected1.left = new TreeNodeQ108(4);
        expected1.right = new TreeNodeQ108(5);
        expected1.left.left = new TreeNodeQ108(5);
        expected1.left.right = new TreeNodeQ108(4);
        expected1.right.right = new TreeNodeQ108(7);

        System.out.println("Test Case 1: " + (isSameTree(solution.mergeTrees(root1, root2), expected1) ? "Check" : "Error"));

        // Test Case 2: One tree is null
        TreeNodeQ108 root3 = null;
        TreeNodeQ108 root4 = new TreeNodeQ108(1);
        TreeNodeQ108 expected2 = new TreeNodeQ108(1);

        System.out.println("Test Case 2: " + (isSameTree(solution.mergeTrees(root3, root4), expected2) ? "Check" : "Error"));

        // Test Case 3: Both trees are null
        TreeNodeQ108 root5 = null;
        TreeNodeQ108 root6 = null;

        System.out.println("Test Case 3: " + (solution.mergeTrees(root5, root6) == null ? "Check" : "Error"));
    }

    // Helper method to check if two binary trees are the same
    private static boolean isSameTree(TreeNodeQ108 p, TreeNodeQ108 q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
