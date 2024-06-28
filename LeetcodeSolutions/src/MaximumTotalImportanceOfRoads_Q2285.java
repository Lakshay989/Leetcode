import java.util.Arrays;

public class MaximumTotalImportanceOfRoads_Q2285 {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];

        for (int[] edge : roads) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Arrays.sort(degree);

        long value = 1;
        long totalImportance = 0;
        for (long d : degree) {
            totalImportance += (value * d);
            value++;
        }

        return totalImportance;
    }

    public static void main(String[] args) {
        MaximumTotalImportanceOfRoads_Q2285 solution = new MaximumTotalImportanceOfRoads_Q2285();

        // Test 1: Basic test case
        int n1 = 5;
        int[][] roads1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(solution.maximumImportance(n1, roads1)); // Expected output: 43

        // Test 2: All nodes connected to a single node
        int n2 = 4;
        int[][] roads2 = {{0, 1}, {0, 2}, {0, 3}};
        System.out.println(solution.maximumImportance(n2, roads2)); // Expected output: 20

        // Test 3: No roads
        int n3 = 3;
        int[][] roads3 = {};
        System.out.println(solution.maximumImportance(n3, roads3)); // Expected output: 0

        // Test 4: Multiple roads connecting the same nodes
        int n4 = 4;
        int[][] roads4 = {{0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 2}};
        System.out.println(solution.maximumImportance(n4, roads4)); // Expected output: 30

        // Test 5: Nodes connected in a line
        int n5 = 6;
        int[][] roads5 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(solution.maximumImportance(n5, roads5)); // Expected output: 56

        // Test 6: All nodes connected to every other node (complete graph)
        int n6 = 3;
        int[][] roads6 = {{0, 1}, {0, 2}, {1, 2}};
        System.out.println(solution.maximumImportance(n6, roads6)); // Expected output: 17

        // Test 7: Disconnected graph
        int n7 = 4;
        int[][] roads7 = {{0, 1}, {2, 3}};
        System.out.println(solution.maximumImportance(n7, roads7)); // Expected output: 10

        // Test 8: Smallest case
        int n8 = 1;
        int[][] roads8 = {};
        System.out.println(solution.maximumImportance(n8, roads8)); // Expected output: 0
    }
}
