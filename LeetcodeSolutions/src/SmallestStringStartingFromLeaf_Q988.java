class TreeNodeQ988 {
    int val;
    TreeNodeQ988 left;
    TreeNodeQ988 right;

    TreeNodeQ988() {
    }

    TreeNodeQ988(int val) {
        this.val = val;
    }

    TreeNodeQ988(int val, TreeNodeQ988 left, TreeNodeQ988 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SmallestStringStartingFromLeaf_Q988 {
    public String smallestFromLeaf(TreeNodeQ988 root) {
        StringBuilder smallest = new StringBuilder();
        dfs(root, new StringBuilder(), smallest);
        return smallest.toString();
    }

    private void dfs(TreeNodeQ988 node, StringBuilder path, StringBuilder smallest) {
        if (node == null) return;

        // Append current node's character to the path
        path.append((char)('a' + node.val));

        // If it's a leaf node, compare and update smallest
        if (node.left == null && node.right == null) {
            String currentString = path.reverse().toString();
            if (smallest.length() == 0 || currentString.compareTo(smallest.toString()) < 0) {
                smallest.setLength(0);
                smallest.append(currentString);
            }
            path.reverse(); // backtrack by reversing again
        }

        // Recursively traverse left and right subtrees
        dfs(node.left, path, smallest);
        dfs(node.right, path, smallest);

        // Backtrack: remove the current node's character from the path
        path.setLength(path.length() - 1);
    }
    public static void main(String[] args) {
        SmallestStringStartingFromLeaf_Q988 solution = new SmallestStringStartingFromLeaf_Q988();

        // Test cases
        TreeNodeQ988 root1 = new TreeNodeQ988(0);
        root1.left = new TreeNodeQ988(1);
        root1.right = new TreeNodeQ988(2);
        root1.left.left = new TreeNodeQ988(3);
        root1.left.right = new TreeNodeQ988(4);
        root1.right.left = new TreeNodeQ988(3);
        root1.right.right = new TreeNodeQ988(4);

        System.out.println("Smallest string from leaf: " + solution.smallestFromLeaf(root1));

        TreeNodeQ988 root2 = new TreeNodeQ988(25);
        root2.left = new TreeNodeQ988(1);
        root2.right = new TreeNodeQ988(3);
        root2.left.left = new TreeNodeQ988(1);
        root2.left.right = new TreeNodeQ988(3);
        root2.right.left = new TreeNodeQ988(0);
        root2.right.right = new TreeNodeQ988(2);

        System.out.println("Smallest string from leaf: " + solution.smallestFromLeaf(root2));
    }
}
