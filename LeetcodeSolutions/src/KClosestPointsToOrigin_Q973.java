import java.util.Arrays;

public class KClosestPointsToOrigin_Q973 {
    public int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    
    public static void main(String[] args) {
        KClosestPointsToOrigin_Q973 kClosestPoints = new KClosestPointsToOrigin_Q973();

        // Test case 1
        int[][] points1 = {{1, 3}, {-2, 2}};
        int K1 = 1;
        int[][] result1 = kClosestPoints.kClosest(points1, K1);
        System.out.println("Test Case 1:");
        System.out.println("Expected Output: [[-2,2]]");
        System.out.println("Actual Output: " + Arrays.deepToString(result1));

        // Test case 2
        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int K2 = 2;
        int[][] result2 = kClosestPoints.kClosest(points2, K2);
        System.out.println("\nTest Case 2:");
        System.out.println("Expected Output: [[3,3],[-2,4]]");
        System.out.println("Actual Output: " + Arrays.deepToString(result2));
    }
}
