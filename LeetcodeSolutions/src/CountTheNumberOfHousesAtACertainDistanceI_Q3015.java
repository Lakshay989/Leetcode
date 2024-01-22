import java.util.Arrays;

public class CountTheNumberOfHousesAtACertainDistanceI_Q3015 {
    public int[] countOfPairs(int n, int x, int y) {
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int dist = findMin(Math.abs(i - j), Math.abs(i - x) + Math.abs(j - y) + 1,
                        Math.abs(i - y) + Math.abs(j - x) + 1);
                result[dist]++;
            }
        }

        return Arrays.copyOfRange(result, 1, result.length);
    }

    public int findMin(int a, int b, int c){
        int min = a;

        if (b < min) {
            min = b;
        }

        if (c < min) {
            min = c;
        }

        return min;
    }

    public static void main(String[] args) {
        CountTheNumberOfHousesAtACertainDistanceI_Q3015 solution = new CountTheNumberOfHousesAtACertainDistanceI_Q3015();

        // Test Case 1
        int n1 = 3, x1 = 1, y1 = 3;
        int[] result1 = solution.countOfPairs(n1, x1, y1);
        printTestResult("Test Case 1", result1, new int[]{6, 0, 0 });

        // Test Case 2
        int n2 = 4, x2 = 1, y2 = 1;
        int[] result2 = solution.countOfPairs(n2, x2, y2);
        printTestResult("Test Case 2", result2, new int[]{6, 4, 2, 0});

        // Add more test cases as needed
    }

    private static void printTestResult(String testName, int[] actual, int[] expected) {
        System.out.println(testName + ": " + (Arrays.equals(actual, expected) ? "Passed" : "Failed"));
        System.out.println("  Actual: " + Arrays.toString(actual));
        System.out.println("  Expected: " + Arrays.toString(expected));
        System.out.println();
    }
}
