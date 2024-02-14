import java.util.Arrays;

public class RearrangeArrayElementsBySign_Q2149 {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        // Initializing an answer array of size n
        int[] ans = new int[n];

        // Initializing two pointers to track even and
        // odd indices for positive and negative integers respectively
        int posIndex = 0, negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                // Placing the positive integer at the
                // desired index in ans and incrementing posIndex by 2
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                // Placing the negative integer at the
                // desired index in ans and incrementing negIndex by 2
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        RearrangeArrayElementsBySign_Q2149 solution = new RearrangeArrayElementsBySign_Q2149();

        // Test Case 1: Even-sized array with equal number of positive and negative integers
        int[] nums1 = {1, -2, 3, -4};
        int[] expected1 = {1, -2, 3, -4};
        int[] result1 = solution.rearrangeArray(nums1);
        System.out.println("Test Case 1 Result: " + Arrays.toString(result1) + ", Expected: " + Arrays.toString(expected1) + ", Check: " + Arrays.equals(result1, expected1));

        // Test Case 2: Another even-sized array with equal number of positive and negative integers
        int[] nums2 = {-1, 2, -3, 4};
        int[] expected2 = {2, -1, 4, -3};
        int[] result2 = solution.rearrangeArray(nums2);
        System.out.println("Test Case 2 Result: " + Arrays.toString(result2) + ", Expected: " + Arrays.toString(expected2) + ", Check: " + Arrays.equals(result2, expected2));
    }
}
