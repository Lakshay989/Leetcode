public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray_Q3105 {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;

        int maxLength = 1;
        int incLength = 1;
        int decLength = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                incLength++;
                decLength = 1;
            } else if (nums[i] < nums[i - 1]) {
                decLength++;
                incLength = 1;
            } else {
                incLength = 1; // Reset both lengths if current number is equal to the previous one
                decLength = 1;
            }

            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestStrictlyIncreasingOrStrictlyDecreasingSubarray_Q3105 solution = new LongestStrictlyIncreasingOrStrictlyDecreasingSubarray_Q3105();

        // Test case 1: Increasing sequence
        int[] nums1 = {1, 2, 3, 4, 5};
        int result1 = solution.longestMonotonicSubarray(nums1);
        System.out.println("Test case 1 result: " + result1); // Expected output: 5

        // Test case 2: Decreasing sequence
        int[] nums2 = {5, 4, 3, 2, 1};
        int result2 = solution.longestMonotonicSubarray(nums2);
        System.out.println("Test case 2 result: " + result2); // Expected output: 5

        // Test case 3: Mixed sequence
        int[] nums3 = {1, 3, 2, 4, 6, 5, 7, 9};
        int result3 = solution.longestMonotonicSubarray(nums3);
        System.out.println("Test case 3 result: " + result3); // Expected output: 3

        // Test case 4: Single element sequence
        int[] nums4 = {7};
        int result4 = solution.longestMonotonicSubarray(nums4);
        System.out.println("Test case 4 result: " + result4); // Expected output: 1

        // Test case 5: Empty sequence
        int[] nums5 = {};
        int result5 = solution.longestMonotonicSubarray(nums5);
        System.out.println("Test case 5 result: " + result5); // Expected output: 0
    }
}
