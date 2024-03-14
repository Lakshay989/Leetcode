public class BinarySubarraysWithSum_Q930 {
    // Helper function to count the number of subarrays with sum at most the given goal
    private int slidingWindowAtMost(int[] nums, int goal) {
        int start = 0, currentSum = 0, totalCount = 0;

        // Iterate through the array using a sliding window approach
        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];

            // Adjust the window by moving the start pointer to the right
            // until the sum becomes less than or equal to the goal
            while (start <= end && currentSum > goal) {
                currentSum -= nums[start++];
            }

            // Update the total count by adding the length of the current subarray
            totalCount += end - start + 1;
        }
        return totalCount;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindowAtMost(nums, goal) - slidingWindowAtMost(nums, goal - 1);
    }
    public static void main(String[] args) {
        BinarySubarraysWithSum_Q930 solution = new BinarySubarraysWithSum_Q930();

        // Test case 1: nums = [1, 0, 1, 0, 1], goal = 2
        int[] nums1 = {1, 0, 1, 0, 1};
        int goal1 = 2;
        // Expected output: 4 (Explanation: [1, 0, 1], [1, 0, 1, 0], [0, 1, 0, 1], [1, 0, 1])
        System.out.println("Test case 1: " + solution.numSubarraysWithSum(nums1, goal1));

        // Test case 2: nums = [0, 0, 0, 0, 0], goal = 0
        int[] nums2 = {0, 0, 0, 0, 0};
        int goal2 = 0;
        // Expected output: 15 (Explanation: [0], [0, 0], [0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0, 0])
        System.out.println("Test case 2: " + solution.numSubarraysWithSum(nums2, goal2));

        // Test case 3: nums = [1, 1, 1, 1, 1], goal = 3
        int[] nums3 = {1, 1, 1, 1, 1};
        int goal3 = 3;
        // Expected output: 3 (Explanation: [1, 1, 1], [1, 1, 1], [1, 1, 1, 1])
        System.out.println("Test case 3: " + solution.numSubarraysWithSum(nums3, goal3));
    }
}
