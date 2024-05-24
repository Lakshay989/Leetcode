import java.util.Arrays;

public class RedundantConnection_Q684 {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (!union(from, to)) {
                return edge;
            }
        }

        return new int[]{0, 0};
    }

    public int find(int cur) {
        int curParent = parent[cur];
        while (curParent != parent[curParent]) {
            // path compression
            parent[curParent] = parent[parent[curParent]];
            curParent = parent[curParent];
        }
        return curParent;
    }

    public boolean union(int v1, int v2) {
        int parent1 = find(v1);
        int parent2 = find(v2);

        // if the parents are the same, return false because it is a redundant edge
        if (parent1 == parent2) {
            return false;
        }
        if (rank[parent1] > rank[parent2]) {
            rank[parent1] += rank[parent2];
            parent[parent2] = parent1;
        } else {
            rank[parent2] += rank[parent1];
            parent[parent1] = parent2;
        }

        return true;
    }

    public static void main(String[] args) {
        RedundantConnection_Q684 solution = new RedundantConnection_Q684();

        // Test case 1
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        int[] result1 = solution.findRedundantConnection(edges1);
        System.out.println(Arrays.toString(result1));  // Expected output: [2, 3]

        // Test case 2
        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] result2 = solution.findRedundantConnection(edges2);
        System.out.println(Arrays.toString(result2));  // Expected output: [1, 4]
    }
}
