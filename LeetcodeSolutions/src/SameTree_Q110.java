class TreeNodeQ100 {
    int val;
    TreeNodeQ100 left;
    TreeNodeQ100 right;
    TreeNodeQ100() {}
    TreeNodeQ100(int val) { this.val = val; }
    TreeNodeQ100(int val, TreeNodeQ100 left, TreeNodeQ100 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SameTree_Q110 {
    public boolean isSameTree(TreeNodeQ100 p, TreeNodeQ100 q) {
        if (p == null && q == null) {
            return true;
        }
        // If one node is null and the other is not, they are not equal
        if (p == null || q == null) {
            return false;
        }
        // If the values of the current nodes are different, they are not equal
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args) {
        SameTree_Q110 solution = new SameTree_Q110();

        // Test Case 1: Identical trees
        TreeNodeQ100 p1 = new TreeNodeQ100(1);
        p1.left = new TreeNodeQ100(2);
        p1.right = new TreeNodeQ100(3);

        TreeNodeQ100 q1 = new TreeNodeQ100(1);
        q1.left = new TreeNodeQ100(2);
        q1.right = new TreeNodeQ100(3);

        System.out.println("Test Case 1: " + (solution.isSameTree(p1, q1) ? "Passed" : "Failed"));

        // Test Case 2: Different trees
        TreeNodeQ100 p2 = new TreeNodeQ100(1);
        p2.left = new TreeNodeQ100(2);

        TreeNodeQ100 q2 = new TreeNodeQ100(1);
        q2.right = new TreeNodeQ100(2);

        System.out.println("Test Case 2: " + (!solution.isSameTree(p2, q2) ? "Passed" : "Failed"));
    }
}
