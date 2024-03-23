import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class TreeNodeQ297 {
    int val;
    TreeNodeQ297 left;
    TreeNodeQ297 right;
    TreeNodeQ297() {}
    TreeNodeQ297(int val) { this.val = val; }
    TreeNodeQ297(int val, TreeNodeQ297 left, TreeNodeQ297 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SerializeAndDeserializeBinaryTree_Q297 {
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNodeQ297 root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNodeQ297 node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNodeQ297 deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNodeQ297 buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNodeQ297 node = new TreeNodeQ297(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    public static void main(String[] args) {
        // Create a binary tree for testing
        TreeNodeQ297 root = new TreeNodeQ297(1);
        root.left = new TreeNodeQ297(2);
        root.right = new TreeNodeQ297(3);
        root.right.left = new TreeNodeQ297(4);
        root.right.right = new TreeNodeQ297(5);

        // Serialize the binary tree
        SerializeAndDeserializeBinaryTree_Q297 codec = new SerializeAndDeserializeBinaryTree_Q297();
        String serialized = codec.serialize(root);
        System.out.println("Serialized tree: " + serialized);

        // Deserialize the binary tree
        TreeNodeQ297 deserializedRoot = codec.deserialize(serialized);

        // Print the deserialized tree
        System.out.println("Deserialized tree: " + codec.serialize(deserializedRoot));
    }
}
