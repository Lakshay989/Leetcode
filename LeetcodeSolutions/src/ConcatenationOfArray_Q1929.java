import java.util.Arrays;

public class ConcatenationOfArray_Q1929 {
    public static int[] getConcatenation(int[] nums) {

        int[] ans = new int[2*nums.length];

        for (int i = 0 ; i < nums.length ; i ++){
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] input, result;

        // Empty Array Test
        input = new int[]{};
        result = getConcatenation(input);
        printTestCase(input, result);

        // Single Element Array Test
        input = new int[]{5};
        result = getConcatenation(input);
        printTestCase(input, result);

        // Multiple Element Array Test
        input = new int[]{1, 2, 3};
        result = getConcatenation(input);
        printTestCase(input, result);

        // Array with Zeroes Test
        input = new int[]{0, 0, 0};
        result = getConcatenation(input);
        printTestCase(input, result);

        // Array with Negative Numbers Test
        input = new int[]{-1, -2, -3};
        result = getConcatenation(input);
        printTestCase(input, result);

        // Large Array Test
        int size = 100000; // Adjust the size as needed
        input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = i + 1;
        }
        result = getConcatenation(input);
        System.out.println("Large Array Test: First 10 elements of result:");
        for (int i = 0; i < 10 && i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

        // Performance Test - Measure performance here (if needed)
    }

    private static void printTestCase(int[] input, int[] result) {
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Output: " + Arrays.toString(result));
        System.out.println("---------------------------");
    }
}
