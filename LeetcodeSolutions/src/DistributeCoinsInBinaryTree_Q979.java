class TreeNodeQ979 {
    int val;
    TreeNodeQ979 left;
    TreeNodeQ979 right;
    TreeNodeQ979() {}
    TreeNodeQ979(int val) { this.val = val; }
    TreeNodeQ979(int val, TreeNodeQ979 left, TreeNodeQ979 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class DistributeCoinsInBinaryTree_Q979 {
    private int moves;

    public int distributeCoins(TreeNodeQ979 root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNodeQ979 current) {
        if (current == null)
            return 0;

        // Calculate the coins each subtree has available to exchange
        int leftCoins = dfs(current.left);
        int rightCoins = dfs(current.right);

        // Add the total number of exchanges to moves
        moves += Math.abs(leftCoins) + Math.abs(rightCoins);

        // The number of coins current has available to exchange
        return (current.val - 1) + leftCoins + rightCoins;
    }

    public static void main(String[] args) {
        // Test case
        TreeNodeQ979 root = new TreeNodeQ979(3);
        root.left = new TreeNodeQ979(0);
        root.right = new TreeNodeQ979(0);
        root.left.left = new TreeNodeQ979(0);
        root.left.right = new TreeNodeQ979(0);
        root.right.left = new TreeNodeQ979(0);
        root.right.right = new TreeNodeQ979(2);

        DistributeCoinsInBinaryTree_Q979 solution = new DistributeCoinsInBinaryTree_Q979();
        int result = solution.distributeCoins(root);
        System.out.println("Minimum number of moves: " + result); // Output: Minimum number of moves: 4
    }
}
