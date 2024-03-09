class TreeNodeQ235 {
    int val;
    TreeNodeQ235 left;
    TreeNodeQ235 right;
    TreeNodeQ235() {}
    TreeNodeQ235(int val) { this.val = val; }
}

public class LowestCommonAncestorOfABinarySearchTree_Q235 {
    public TreeNodeQ235 lowestCommonAncestor(TreeNodeQ235 root, TreeNodeQ235 p, TreeNodeQ235 q) {
        if((p.val < root.val && q.val > root.val) || p.val > root.val && q.val < root.val){
            return root ;
        }

        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        // if(p.val== root.val || q.val == root.val){
        //     return root ;
        // }
        return root ;
    }
    public static void main(String[] args) {
        // Example 1
        TreeNodeQ235 root1 = new TreeNodeQ235(6);
        root1.left = new TreeNodeQ235(2);
        root1.right = new TreeNodeQ235(8);
        root1.left.left = new TreeNodeQ235(0);
        root1.left.right = new TreeNodeQ235(4);
        root1.left.right.left = new TreeNodeQ235(3);
        root1.left.right.right = new TreeNodeQ235(5);
        root1.right.left = new TreeNodeQ235(7);
        root1.right.right = new TreeNodeQ235(9);
        TreeNodeQ235 p1 = root1.left;
        TreeNodeQ235 q1 = root1.right;
        LowestCommonAncestorOfABinarySearchTree_Q235 solution = new LowestCommonAncestorOfABinarySearchTree_Q235();
        TreeNodeQ235 result1 = solution.lowestCommonAncestor(root1, p1, q1);
        System.out.println("Example 1 Result: " + (result1.val == 6));

        // Example 2
        TreeNodeQ235 root2 = new TreeNodeQ235(2);
        root2.left = new TreeNodeQ235(1);
        root2.right = new TreeNodeQ235(3);
        TreeNodeQ235 p2 = root2.left;
        TreeNodeQ235 q2 = root2.right;
        TreeNodeQ235 result2 = solution.lowestCommonAncestor(root2, p2, q2);
        System.out.println("Example 2 Result: " + (result2.val == 2));
    }
}
