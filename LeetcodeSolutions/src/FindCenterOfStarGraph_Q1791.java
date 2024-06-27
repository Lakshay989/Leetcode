public class FindCenterOfStarGraph_Q1791 {
    public int findCenter(int[][] edges) {
        int[] firstEdge = edges[0];
        int[] secondEdge = edges[1];

        return (firstEdge[0] == secondEdge[0] || firstEdge[0] == secondEdge[1])
                ? firstEdge[0]
                : firstEdge[1];
    }

    public static void main(String[] args) {
        FindCenterOfStarGraph_Q1791 finder = new FindCenterOfStarGraph_Q1791();

        // Test case 1: Simple star graph
        int[][] edges1 = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(finder.findCenter(edges1)); // Expected output: 2

        // Test case 2: Star graph with center at 1
        int[][] edges2 = {{1, 2}, {1, 3}, {1, 4}};
        System.out.println(finder.findCenter(edges2)); // Expected output: 1

        // Test case 3: Star graph with center at 5
        int[][] edges3 = {{5, 1}, {5, 2}, {5, 3}, {5, 4}};
        System.out.println(finder.findCenter(edges3)); // Expected output: 5

        // Test case 4: Star graph with minimum nodes
        int[][] edges4 = {{1, 2}, {1, 3}};
        System.out.println(finder.findCenter(edges4)); // Expected output: 1

        // Test case 5: Star graph with center at a larger value
        int[][] edges5 = {{10, 11}, {11, 12}, {13, 11}, {14, 11}};
        System.out.println(finder.findCenter(edges5)); // Expected output: 11

        // Test case 6: Star graph with mixed order of edges
        int[][] edges6 = {{7, 8}, {6, 7}, {7, 9}, {10, 7}};
        System.out.println(finder.findCenter(edges6)); // Expected output: 7

        // Test case 7: Star graph with duplicate edges
        int[][] edges7 = {{2, 3}, {3, 4}, {2, 3}, {5, 3}};
        System.out.println(finder.findCenter(edges7)); // Expected output: 3
    }
}
