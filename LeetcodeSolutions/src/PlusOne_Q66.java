import java.util.Arrays;

public class PlusOne_Q66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        //Move along the input array starting from the end
        for (int idx = n - 1; idx >= 0; --idx) {
            //Set all the nines at the end of the array to zeros
            if (digits[idx] == 9) {
                digits[idx] = 0;
            }

            //Here we have the rightmost not-nine
            else {
                // Increase this rightmost not-nine by 1
                digits[idx]++;

                // and the job is done
                return digits;
            }
        }

        // We're here because all the digits are nines
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
    public static void main(String[] args) {
        PlusOne_Q66 solution = new PlusOne_Q66();

        // Test case 1
        int[] digits1 = {1, 2, 3};
        int[] result1 = solution.plusOne(digits1);
        System.out.println("Test case 1 result: " + Arrays.toString(result1)); // Expected output: [1, 2, 4]

        // Test case 2
        int[] digits2 = {4, 3, 2, 1};
        int[] result2 = solution.plusOne(digits2);
        System.out.println("Test case 2 result: " + Arrays.toString(result2)); // Expected output: [4, 3, 2, 2]

        // Test case 3
        int[] digits3 = {9, 9, 9};
        int[] result3 = solution.plusOne(digits3);
        System.out.println("Test case 3 result: " + Arrays.toString(result3)); // Expected output: [1, 0, 0, 0]

        // Test case 4
        int[] digits4 = {0};
        int[] result4 = solution.plusOne(digits4);
        System.out.println("Test case 4 result: " + Arrays.toString(result4)); // Expected output: [1]
    }
}
