 class UnionFind {
    private int[] parent;

    // For efficiency, we aren't using makeset, but instead initialising
    // all the sets at the same time in the constructor.
    public UnionFind(int n) {
        parent = new int[n];
        for (int node = 0; node < n; node++) {
            parent[node] = node;
        }
    }

    // The find method, without any optimizations. It traces up the parent
    // links until it finds the root node for A, and returns that root.
    public int find(int A) {
        while (parent[A] != A) {
            A = parent[A];
        }
        return A;
    }

    // The union method, without any optimizations. It returns True if a
    // merge happened, False if otherwise.
    public boolean union(int A, int B) {
        // Find the roots for A and B.
        int rootA = find(A);
        int rootB = find(B);
        // Check if A and B are already in the same set.
        if (rootA == rootB) {
            return false;
        }
        // Merge the sets containing A and B.
        parent[rootA] = rootB;
        return true;
    }
}

 public class GraphValidTree_Q261 {
        public boolean validTree(int n, int[][] edges) {

            // Condition 1: The graph must contain n - 1 edges.
            if (edges.length != n - 1) return false;

            // Condition 2: The graph must contain a single connected component.
            // Create a new UnionFind object with n nodes.
            UnionFind unionFind = new UnionFind(n);
            // Add each edge. Check if a merge happened, because if it
            // didn't, there must be a cycle.
            for (int[] edge : edges) {
                int A = edge[0];
                int B = edge[1];
                if (!unionFind.union(A, B)) {
                    return false;
                }
            }

            // If we got this far, there's no cycles!
            return true;
        }

     public static void main(String[] args) {
         GraphValidTree_Q261 solution = new GraphValidTree_Q261();

         // Test case 1
         int n1 = 5;
         int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
         boolean isValidTree1 = solution.validTree(n1, edges1);
         System.out.println("Test Case 1 Result:");
         System.out.println("Is Valid Tree: " + isValidTree1);
         // Expected output: true

         // Test case 2
         int n2 = 5;
         int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
         boolean isValidTree2 = solution.validTree(n2, edges2);
         System.out.println("Test Case 2 Result:");
         System.out.println("Is Valid Tree: " + isValidTree2);
         // Expected output: false

         // Add more test cases as needed
     }
}
