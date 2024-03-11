import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNodeQ199 {
    int val;
    TreeNodeQ199 left;
    TreeNodeQ199 right;
    TreeNodeQ199() {}
    TreeNodeQ199(int val) { this.val = val; }
    TreeNodeQ199(int val, TreeNodeQ199 left, TreeNodeQ199 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeRightSideView_Q199 {
    public List<Integer> rightSideView(TreeNodeQ199 root) {
        List<Integer> result = new ArrayList<>() ;
        if(root == null){
            return result ;
        }
        Deque<TreeNodeQ199> que = new ArrayDeque<>();
        que.add(root) ;

        while(!que.isEmpty()){
            TreeNodeQ199 curr = null;
            int size = que.size();

            for(int i = 0 ; i < size; i++){
                curr = que.poll();
                if(curr.left != null){
                    que.add(curr.left);
                }
                if(curr.right != null){
                    que.add(curr.right);
                }
            }
            result.add(curr.val);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        TreeNodeQ199 root1 = new TreeNodeQ199(1);
        root1.left = new TreeNodeQ199(2);
        root1.right = new TreeNodeQ199(3);
        root1.left.right = new TreeNodeQ199(5);
        root1.right.right = new TreeNodeQ199(4);
        // Expected output: [1, 3, 4]
        System.out.println("Test case 1: " + new BinaryTreeRightSideView_Q199().rightSideView(root1));

        // Test case 2
        TreeNodeQ199 root2 = new TreeNodeQ199(1);
        root2.left = new TreeNodeQ199(2);
        root2.right = new TreeNodeQ199(3);
        root2.left.right = new TreeNodeQ199(4);
        root2.right.right = new TreeNodeQ199(5);
        // Expected output: [1, 3, 5]
        System.out.println("Test case 2: " + new BinaryTreeRightSideView_Q199().rightSideView(root2));

        // Test case 3
        TreeNodeQ199 root3 = null;
        // Expected output: []
        System.out.println("Test case 3: " + new BinaryTreeRightSideView_Q199().rightSideView(root3));

        // Test case 4
        TreeNodeQ199 root4 = new TreeNodeQ199(1);
        // Expected output: [1]
        System.out.println("Test case 4: " + new BinaryTreeRightSideView_Q199().rightSideView(root4));

        // Test case 5
        TreeNodeQ199 root5 = new TreeNodeQ199(1);
        root5.left = new TreeNodeQ199(2);
        root5.left.left = new TreeNodeQ199(3);
        root5.left.left.left = new TreeNodeQ199(4);
        // Expected output: [1, 2, 3, 4]
        System.out.println("Test case 5: " + new BinaryTreeRightSideView_Q199().rightSideView(root5));
    }
}
