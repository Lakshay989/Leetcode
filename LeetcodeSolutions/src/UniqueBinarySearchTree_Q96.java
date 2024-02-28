class TreeNodeQ96 {
    int val;
    TreeNodeQ96 left;
    TreeNodeQ96 right;
    TreeNodeQ96() {}
    TreeNodeQ96(int val) { this.val = val; }
    TreeNodeQ96(int val, TreeNodeQ96 left, TreeNodeQ96 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class UniqueBinarySearchTree_Q96 {
    public int numTrees(int n) {
        int[] numT = new int[n+1];

        for(int i = 0 ; i < numT.length ; i++){
            numT[i] = 1 ;
        }

        for(int i = 2 ; i < numT.length ; i++){
            int total = 0 ;
            for(int j = 1 ; j <= i ; j++){
                int left = j - 1;
                int right = i - j ;
                total += numT[left] * numT[right] ;
            }
            numT[i] = total ;
        }
        return numT[n] ;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTree_Q96 counter = new UniqueBinarySearchTree_Q96();

        // Test Case 1: n = 1
        // Only one unique BST can be formed with a single node
        System.out.println("Test Case 1: " + (counter.numTrees(1) == 1 ? "Passed" : "Failed"));

        // Test Case 2: n = 2
        // Two unique BSTs can be formed with two nodes
        System.out.println("Test Case 2: " + (counter.numTrees(2) == 2 ? "Passed" : "Failed"));

        // Test Case 3: n = 3
        // Five unique BSTs can be formed with three nodes
        System.out.println("Test Case 3: " + (counter.numTrees(3) == 5 ? "Passed" : "Failed"));

        // Test Case 4: n = 4
        // Fourteen unique BSTs can be formed with four nodes
        System.out.println("Test Case 4: " + (counter.numTrees(4) == 14 ? "Passed" : "Failed"));

        // Test Case 5: n = 5
        // Forty-two unique BSTs can be formed with five nodes
        System.out.println("Test Case 5: " + (counter.numTrees(5) == 42 ? "Passed" : "Failed"));
    }
}
