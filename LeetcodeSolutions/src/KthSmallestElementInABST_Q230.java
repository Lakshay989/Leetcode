import java.util.LinkedList;

class TreeNodeQ230 {
    int val;
    TreeNodeQ230 left;
    TreeNodeQ230 right;
    TreeNodeQ230() {}
    TreeNodeQ230(int val) { this.val = val; }
    TreeNodeQ230(int val, TreeNodeQ230 left, TreeNodeQ230 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class KthSmallestElementInABST_Q230 {
    public int kthSmallest(TreeNodeQ230 root, int k) {
        LinkedList<TreeNodeQ230> stack = new LinkedList<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

    public static void main(String[] args) {
        KthSmallestElementInABST_Q230 solution = new KthSmallestElementInABST_Q230();

        // Test case 1
        TreeNodeQ230 root1 = new TreeNodeQ230(3);
        root1.left = new TreeNodeQ230(1);
        root1.right = new TreeNodeQ230(4);
        root1.left.right = new TreeNodeQ230(2);
        int k1 = 1;
        System.out.println("Test case 1: " + (solution.kthSmallest(root1, k1) == 1 ? "Passed" : "Failed"));

        // Test case 2
        TreeNodeQ230 root2 = new TreeNodeQ230(5);
        root2.left = new TreeNodeQ230(3);
        root2.right = new TreeNodeQ230(6);
        root2.left.left = new TreeNodeQ230(2);
        root2.left.right = new TreeNodeQ230(4);
        root2.left.left.left = new TreeNodeQ230(1);
        int k2 = 3;
        System.out.println("Test case 2: " + (solution.kthSmallest(root2, k2) == 3 ? "Passed" : "Failed"));

        // Test case 3
        TreeNodeQ230 root3 = new TreeNodeQ230(5);
        int k3 = 1;
        System.out.println("Test case 3: " + (solution.kthSmallest(root3, k3) == 5 ? "Passed" : "Failed"));
    }
}
