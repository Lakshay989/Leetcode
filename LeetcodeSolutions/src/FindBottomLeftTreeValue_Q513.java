import java.util.ArrayDeque;
import java.util.Deque;

class TreeNodeQ513 {
    int val;
    TreeNodeQ513 left;
    TreeNodeQ513 right;
    TreeNodeQ513() {}
    TreeNodeQ513(int val) { this.val = val; }
    TreeNodeQ513(int val, TreeNodeQ513 left, TreeNodeQ513 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class FindBottomLeftTreeValue_Q513 {
    public int findBottomLeftValue(TreeNodeQ513 root) {
        Deque<TreeNodeQ513> deque = new ArrayDeque<>() ;
        TreeNodeQ513 node  = new TreeNodeQ513();
        deque.addFirst(root);
        while(deque.size() != 0){
            node = deque.pollFirst() ;

            if(node.right != null)
                deque.addLast(node.right);
            if(node.left != null)
                deque.addLast(node.left);
        }
        return node.val ;
    }

    public static void main(String[] args) {
        FindBottomLeftTreeValue_Q513 finder = new FindBottomLeftTreeValue_Q513();

        // Test Case 1: Single node tree
        //   5
        TreeNodeQ513 root1 = new TreeNodeQ513(5);
        System.out.println("Test Case 1: " + (finder.findBottomLeftValue(root1) == 5 ? "Passed" : "Failed"));

        // Test Case 2: Binary tree with multiple levels
        //         2
        //        / \
        //       1   3
        //      / \   \
        //     4   5   6
        TreeNodeQ513 root2 = new TreeNodeQ513(2);
        root2.left = new TreeNodeQ513(1);
        root2.right = new TreeNodeQ513(3);
        root2.left.left = new TreeNodeQ513(4);
        root2.left.right = new TreeNodeQ513(5);
        root2.right.right = new TreeNodeQ513(6);
        System.out.println("Test Case 2: " + (finder.findBottomLeftValue(root2) == 4 ? "Passed" : "Failed"));

        // Test Case 3: Binary tree with multiple levels, bottom-left value not on the last level
        //         3
        //        / \
        //       9   20
        //          / \
        //         15  7
        TreeNodeQ513 root3 = new TreeNodeQ513(3);
        root3.left = new TreeNodeQ513(9);
        root3.right = new TreeNodeQ513(20);
        root3.right.left = new TreeNodeQ513(15);
        root3.right.right = new TreeNodeQ513(7);
        System.out.println("Test Case 3: " + (finder.findBottomLeftValue(root3) == 15 ? "Passed" : "Failed"));
    }
}
