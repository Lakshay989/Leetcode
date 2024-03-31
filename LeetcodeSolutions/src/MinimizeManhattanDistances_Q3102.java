public class MinimizeManhattanDistances_Q3102 {
    public int minimumDistance(int[][] points) {
        int[] result1 = maxDistance(points);
        int[] result2 = maxDistance(points, result1[1]);
        int[] result3 = maxDistance(points, result1[2]);
        return Math.min(result2[0], result3[0]);
    }

    static int[] maxDistance(int[][] ps) {
        return maxDistance(ps, -1);
    }

    static int[] maxDistance(int[][] points, int skip) {
        int[] sum = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] sum_i = {0, 0};
        int[] diff = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] diff_i = {0, 0};

        for (int i = 0; i < points.length; ++i) {
            if (i == skip)
                continue;
            if (sum[0] > points[i][0] + points[i][1]) {
                sum[0] = points[i][0] + points[i][1];
                sum_i[0] = i;
            }
            if (sum[1] < points[i][0] + points[i][1]) {
                sum[1] = points[i][0] + points[i][1];
                sum_i[1] = i;
            }
            if (diff[0] > points[i][0] - points[i][1]) {
                diff[0] = points[i][0] - points[i][1];
                diff_i[0] = i;
            }
            if (diff[1] < points[i][0] - points[i][1]) {
                diff[1] = points[i][0] - points[i][1];
                diff_i[1] = i;
            }
        }

        if (sum[1] - sum[0] > diff[1] - diff[0])
            return new int[]{sum[1] - sum[0], sum_i[0], sum_i[1]};
        return new int[]{diff[1] - diff[0], diff_i[0], diff_i[1]};
    }

    public static void main(String[] args) {
        MinimizeManhattanDistances_Q3102 solution = new MinimizeManhattanDistances_Q3102();

        // Test case 1
        int[][] points1 = {{1, 1}, {3, 4}, {-1, 0}};
        int result1 = solution.minimumDistance(points1);
        System.out.println("Test case 1 result: " + result1); // Expected output: 3

        // Test case 2
        int[][] points2 = {{1, 1}, {0, 1}, {1, 0}, {0, 0}};
        int result2 = solution.minimumDistance(points2);
        System.out.println("Test case 2 result: " + result2); // Expected output: 2

        // Test case 3
        int[][] points3 = {{0, 0}, {1, 1}, {1, 0}, {2, 0}, {1, 3}, {1, 4}};
        int result3 = solution.minimumDistance(points3);
        System.out.println("Test case 3 result: " + result3); // Expected output: 4
    }
}
