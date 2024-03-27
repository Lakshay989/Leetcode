public class SubarrayProductLessThanK_Q713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Handle edge cases where k is 0 or 1 (no subarrays possible)
        if (k <= 1) return 0;

        int totalCount = 0;
        int product = 1;

        // Use two pointers to maintain a sliding window
        for (int left = 0, right = 0; right < nums.length; right++) {
            // Expand the window by including the element at the right pointer
            product *= nums[right];

            // Shrink the window from the left while the product is greater than or equal to k
            while (product >= k) {
                // Remove the element at the left pointer from the product
                product /= nums[left++];
            }

            // Update the total count by adding the number of valid subarrays with the current window size
            totalCount += right - left + 1;  // right - left + 1 represents the current window size
        }

        return totalCount;
    }
    public static void main(String[] args) {
        SubarrayProductLessThanK_Q713 solution = new SubarrayProductLessThanK_Q713();

        // Test case 1: Example from the problem statement
        int[] nums1 = {10, 5, 2, 6};
        int k1 = 100;
        System.out.println("Test Case 1: " + solution.numSubarrayProductLessThanK(nums1, k1)); // Expected output: 8

        // Test case 2: All elements less than k
        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 10;
        System.out.println("Test Case 2: " + solution.numSubarrayProductLessThanK(nums2, k2)); // Expected output: 9

        // Test case 3: All elements greater than k
        int[] nums3 = {6, 7, 8, 9};
        int k3 = 5;
        System.out.println("Test Case 3: " + solution.numSubarrayProductLessThanK(nums3, k3)); // Expected output: 0

        // Test case 4: Empty array
        int[] nums4 = {};
        int k4 = 5;
        System.out.println("Test Case 4: " + solution.numSubarrayProductLessThanK(nums4, k4)); // Expected output: 0
    }
}
