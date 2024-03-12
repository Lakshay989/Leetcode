import java.util.HashMap;
import java.util.Map;

class TreeNodeQ105 {
    int val;
    TreeNodeQ105 left;
    TreeNodeQ105 right;
    TreeNodeQ105() {}
    TreeNodeQ105(int val) { this.val = val; }
    TreeNodeQ105(int val, TreeNodeQ105 left, TreeNodeQ105 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_Q105 {
    public TreeNodeQ105 buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNodeQ105 root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNodeQ105 buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNodeQ105 root = new TreeNodeQ105(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal_Q105 solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal_Q105();

        // Test Case 1
        int[] preorder1 = {3,9,20,15,7};
        int[] inorder1 = {9,3,15,20,7};
        TreeNodeQ105 root1 = solution.buildTree(preorder1, inorder1);
            System.out.print("Inorder traversal of constructed tree for Test Case 1: ");
            solution.inorderTraversal(root1);
            System.out.println();

        // Test Case 2
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNodeQ105 root2 = solution.buildTree(preorder2, inorder2);
            System.out.print("Inorder traversal of constructed tree for Test Case 2: ");
            solution.inorderTraversal(root2);
    }
    public void inorderTraversal(TreeNodeQ105 root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
}
