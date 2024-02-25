public class FindTheLargestAreaOfSquareInsideTwoRectangles_Q3047 {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxArea = 0;

        for (int i = 0; i < bottomLeft.length; i++) {
            for (int j = i + 1; j < bottomLeft.length; j++) {
                int x1 = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int y1 = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int x2 = Math.min(topRight[i][0], topRight[j][0]);
                int y2 = Math.min(topRight[i][1], topRight[j][1]);

                if (x1 < x2 && y1 < y2) {
                    int sideLength = Math.min(x2 - x1, y2 - y1);
                    maxArea = Math.max(maxArea, (long)sideLength * sideLength);
                }
            }
        }

        return maxArea;
    }
    public static void main(String[] args) {
        FindTheLargestAreaOfSquareInsideTwoRectangles_Q3047 solution = new FindTheLargestAreaOfSquareInsideTwoRectangles_Q3047();

        // Test Case 1: General case with valid input
        int[][] bottomLeft1 = {{1, 1}, {2, 2}};
        int[][] topRight1 = {{3, 3}, {4, 4}};
        System.out.println("Test Case 1: " + (solution.largestSquareArea(bottomLeft1, topRight1) == 1 ? "Check" : "Error"));

        // Test Case 2: General case with invalid input (no overlapping area)
        int[][] bottomLeft2 = {{1, 1}, {2, 2}};
        int[][] topRight2 = {{3, 3}, {4, 4}};
        System.out.println("Test Case 2: " + (solution.largestSquareArea(bottomLeft2, topRight2) == 1 ? "Check" : "Error"));

        // Test Case 3: General case with valid input (square area within one rectangle)
        int[][] bottomLeft3 = {{1, 1}, {1, 1}};
        int[][] topRight3 = {{3, 3}, {4, 4}};
        System.out.println("Test Case 3: " + (solution.largestSquareArea(bottomLeft3, topRight3) == 4 ? "Check" : "Error"));

        // Test Case 4: General case with valid input (one rectangle inside another)
        int[][] bottomLeft4 = {{1, 1}, {0, 0}};
        int[][] topRight4 = {{3, 3}, {4, 4}};
        System.out.println("Test Case 4: " + (solution.largestSquareArea(bottomLeft4, topRight4) == 4 ? "Check" : "Error"));
    }
}
