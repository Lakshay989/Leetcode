
import java.util.LinkedList;
import java.util.Queue;

class TreeNodeQ1609 {
        int val;
    TreeNodeQ1609 left;
    TreeNodeQ1609 right;
    TreeNodeQ1609() {}
    TreeNodeQ1609(int val) { this.val = val; }
    TreeNodeQ1609(int val, TreeNodeQ1609 left, TreeNodeQ1609 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class EvenOddTree_Q1609 {
    public boolean isEvenOddTree(TreeNodeQ1609 root) {
        Queue<TreeNodeQ1609> queue = new LinkedList<>();

        queue.add(root);
        boolean even = true ;

        while(!queue.isEmpty()){
            int size = queue.size();

            int prev = even ? Integer.MIN_VALUE : Integer.MAX_VALUE ;

            while(size > 0){
                TreeNodeQ1609 node = queue.poll() ;

                if (even && (node.val % 2 == 0 || node.val <= prev)){
                    return false ;
                }
                else if(!even && (node.val % 2 == 1 || node.val >= prev)){
                    return false ;
                }

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                prev = node.val ;
                size -- ;
            }
            even = !even ;
        }
        return true ;
    }
    public static void main(String[] args) {
        // Create test trees
        TreeNodeQ1609 root1 = new TreeNodeQ1609(1);
        root1.left = new TreeNodeQ1609(10);
        root1.right = new TreeNodeQ1609(4);
        root1.left.left = new TreeNodeQ1609(3);
        root1.left.right = new TreeNodeQ1609(7);
        root1.right.left = new TreeNodeQ1609(9);

        TreeNodeQ1609 root2 = new TreeNodeQ1609(5);
        root2.left = new TreeNodeQ1609(4);
        root2.right = new TreeNodeQ1609(2);
        root2.left.left = new TreeNodeQ1609(3);
        root2.left.right = new TreeNodeQ1609(3);
        root2.right.left = new TreeNodeQ1609(7);

        // Test case 1: Expected output: true
        System.out.println("Test Case 1: " + (new EvenOddTree_Q1609().isEvenOddTree(root1) ? "Passed" : "Failed"));

        // Test case 2: Expected output: false
        System.out.println("Test Case 2: " + (!new EvenOddTree_Q1609().isEvenOddTree(root2) ? "Passed" : "Failed"));
    }
}
