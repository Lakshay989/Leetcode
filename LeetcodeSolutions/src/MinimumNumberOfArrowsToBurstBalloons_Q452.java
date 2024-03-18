import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons_Q452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // sort by x_end
        Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an
            // integer overflow for very large or small values.
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });

        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1];
        for (int[] p : points) {
            xStart = p[0];
            xEnd = p[1];

            // If the current balloon starts after the end of another one,
            // one needs one more arrow
            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons_Q452 solution = new MinimumNumberOfArrowsToBurstBalloons_Q452();

        // Test cases
        int[][] points1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int result1 = solution.findMinArrowShots(points1);
        System.out.println("Test Case 1: " + result1); // Expected output: 2

        int[][] points2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int result2 = solution.findMinArrowShots(points2);
        System.out.println("Test Case 2: " + result2); // Expected output: 4

        int[][] points3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int result3 = solution.findMinArrowShots(points3);
        System.out.println("Test Case 3: " + result3); // Expected output: 2
    }
}
