import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNodeQ102 {
    int val;
    TreeNodeQ102 left;
    TreeNodeQ102 right;
    TreeNodeQ102() {}
    TreeNodeQ102(int val) { this.val = val; }
    TreeNodeQ102(int val, TreeNodeQ102 left, TreeNodeQ102 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeLevelOrderTraversal_Q102 {
    public List<List<Integer>> levelOrder(TreeNodeQ102 root) {

        Queue<TreeNodeQ102> que = new LinkedList<>() ;
        List<List<Integer>> result = new ArrayList<>() ;

        que.add(root);
        while(!que.isEmpty()){
            int size = que.size() ;
            List<Integer> innerList = new ArrayList<>();
            for(int i = 0 ; i< size ; i++){
                TreeNodeQ102 curr = que.poll() ;
                if(curr != null){
                    innerList.add(curr.val) ;
                    if(curr.left!=null){
                        que.add(curr.left);
                    }
                    if(curr.right != null){
                        que.add(curr.right);
                    }
                }
                else{
                    return result ;
                }
            }
            result.add(innerList) ;
        }
        return result ;
    }
    public static void main(String[] args) {
        // Example 1
        TreeNodeQ102 root1 = new TreeNodeQ102(3);
        root1.left = new TreeNodeQ102(9);
        root1.right = new TreeNodeQ102(20);
        root1.right.left = new TreeNodeQ102(15);
        root1.right.right = new TreeNodeQ102(7);
        List<List<Integer>> result1 = new BinaryTreeLevelOrderTraversal_Q102().levelOrder(root1);
        System.out.println("Example 1 Result: " + result1);

        // Example 2
        TreeNodeQ102 root2 = new TreeNodeQ102(1);
        root2.left = new TreeNodeQ102(2);
        root2.right = new TreeNodeQ102(3);
        root2.left.left = new TreeNodeQ102(4);
        root2.left.right = new TreeNodeQ102(5);
        List<List<Integer>> result2 = new BinaryTreeLevelOrderTraversal_Q102().levelOrder(root2);
        System.out.println("Example 2 Result: " + result2);
    }
}
