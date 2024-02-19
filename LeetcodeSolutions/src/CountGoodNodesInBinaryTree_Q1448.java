class TreeNodeQ1448 {
    int val;
    TreeNodeQ1448 left;
    TreeNodeQ1448 right;
    TreeNodeQ1448() {}
    TreeNodeQ1448(int val) { this.val = val; }
    TreeNodeQ1448(int val, TreeNodeQ1448 left, TreeNodeQ1448 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class CountGoodNodesInBinaryTree_Q1448 {
    int res = 0 ;

    public int goodNodes(TreeNodeQ1448 root) {
        int max = Integer.MIN_VALUE ;
        dfs(root, max) ;

        return res ;

    }
    public void dfs(TreeNodeQ1448 node, int max){
        if(node == null){
            return;
        }

        if(node.val >= max){
            res += 1 ;
        }

        max =  Integer.max(max , node.val);

        dfs(node.left, max) ;
        dfs(node.right, max) ;
    }

    public static void main(String[] args) {
        CountGoodNodesInBinaryTree_Q1448 solution = new CountGoodNodesInBinaryTree_Q1448();

        // Test Case 1: Regular case with a few good nodes
        TreeNodeQ1448 root1 = new TreeNodeQ1448(3);
        root1.left = new TreeNodeQ1448(1);
        root1.right = new TreeNodeQ1448(4);
        root1.left.left = new TreeNodeQ1448(3);
        root1.right.left = new TreeNodeQ1448(1);
        root1.right.right = new TreeNodeQ1448(5);
        int expected1 = 4; // Good nodes: [3, 3, 4, 5]
        int result1 = solution.goodNodes(root1);
        System.out.println("Test Case 1 Result: " + (result1 == expected1 ? "Check" : "Error"));
    }
}