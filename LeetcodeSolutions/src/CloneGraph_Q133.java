import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class NodeQ133 {
    public int val;
    public List<NodeQ133> neighbors;
    public NodeQ133() {
        val = 0;
        neighbors = new ArrayList<NodeQ133>();
    }
    public NodeQ133(int _val) {
        val = _val;
        neighbors = new ArrayList<NodeQ133>();
    }
    public NodeQ133(int _val, ArrayList<NodeQ133> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph_Q133 {
    private HashMap<NodeQ133, NodeQ133> map = new HashMap<NodeQ133, NodeQ133>();
    public NodeQ133 cloneGraph(NodeQ133 node) {
        if(node == null) {
            return null;
        }
        if(map.containsKey(node)) {
            return map.get(node);
        }
        NodeQ133 clone = new NodeQ133(node.val);
        map.put(node, clone);
        for(NodeQ133 nei : node.neighbors) {
            clone.neighbors.add(cloneGraph(nei));
        }
        return clone;
    }

    public static void main(String[] args) {
        CloneGraph_Q133 solver = new CloneGraph_Q133();

        // Create a graph
        NodeQ133 node1 = new NodeQ133(1);
        NodeQ133 node2 = new NodeQ133(2);
        NodeQ133 node3 = new NodeQ133(3);
        NodeQ133 node4 = new NodeQ133(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone the graph
        NodeQ133 clonedNode = solver.cloneGraph(node1);

        // Print the cloned graph for verification
        printGraph(clonedNode);
    }

    public static void printGraph(NodeQ133 node) {
        if (node == null) return;

        System.out.println("Node: " + node.val);
        System.out.print("Neighbors: ");
        for (NodeQ133 neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        // Recursively print the neighbors of the current node
        for (NodeQ133 neighbor : node.neighbors) {
            printGraph(neighbor);
        }
    }
}
