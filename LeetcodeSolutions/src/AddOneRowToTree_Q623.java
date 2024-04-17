class TreeNodeQ623 {
    int val;
    TreeNodeQ623 left;
    TreeNodeQ623 right;

    TreeNodeQ623() {
    }

    TreeNodeQ623(int val) {
        this.val = val;
    }

    TreeNodeQ623(int val, TreeNodeQ623 left, TreeNodeQ623 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class AddOneRowToTree_Q623 {
    public TreeNodeQ623 addOneRow(TreeNodeQ623 t, int v, int d) {
        if (d == 1) {
            TreeNodeQ623 n = new TreeNodeQ623(v);
            n.left = t;
            return n;
        }
        insert(v, t, 1, d);
        return t;
    }

    public void insert(int val, TreeNodeQ623 node, int depth, int n) {
        if (node == null)
            return;
        if (depth == n - 1) {
            TreeNodeQ623 t = node.left;
            node.left = new TreeNodeQ623(val);
            node.left.left = t;
            t = node.right;
            node.right = new TreeNodeQ623(val);
            node.right.right = t;
        } else {
            insert(val, node.left, depth + 1, n);
            insert(val, node.right, depth + 1, n);
        }
    }
    public static void main(String[] args) {
        AddOneRowToTree_Q623 solution = new AddOneRowToTree_Q623();

        // Test cases
        TreeNodeQ623 root1 = new TreeNodeQ623(4);
        root1.left = new TreeNodeQ623(2);
        root1.right = new TreeNodeQ623(6);
        root1.left.left = new TreeNodeQ623(3);
        root1.left.right = new TreeNodeQ623(1);
        root1.right.left = new TreeNodeQ623(5);

        System.out.println("Original Tree:");
        printTree(root1);

        TreeNodeQ623 modifiedTree1 = solution.addOneRow(root1, 1, 2);
        System.out.println("\n\nModified Tree (v=1, d=2):");
        printTree(modifiedTree1);

        TreeNodeQ623 root2 = new TreeNodeQ623(4);
        root2.left = new TreeNodeQ623(2);
        root2.right = new TreeNodeQ623(6);
        root2.left.left = new TreeNodeQ623(3);
        root2.left.right = new TreeNodeQ623(1);
        root2.right.left = new TreeNodeQ623(5);

        TreeNodeQ623 modifiedTree2 = solution.addOneRow(root2, 1, 3);
        System.out.println("\n\nModified Tree (v=1, d=3):");
        printTree(modifiedTree2);
    }

    public static void printTree(TreeNodeQ623 root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
