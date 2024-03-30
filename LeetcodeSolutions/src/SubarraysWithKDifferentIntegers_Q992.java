public class SubarraysWithKDifferentIntegers_Q992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    private int helper(int nums[], int k) {
        if (k == 0) {
            return 0;
        } else {
            int count[] = new int[nums.length + 1];
            int windowStart = 0, windowEnd = 0, res = 0;
            int currCount = 0;

            while (windowEnd != nums.length) {
                int curr = nums[windowEnd++];

                if (count[curr] == 0) {
                    currCount++;
                }
                count[curr]++;

                while (currCount > k) {
                    if (--count[nums[windowStart++]] == 0) {
                        currCount--;
                    }
                }

                res += windowEnd - windowStart;
            }

            return res;
        }
    }
    public static void main(String[] args) {
        SubarraysWithKDifferentIntegers_Q992 solution = new SubarraysWithKDifferentIntegers_Q992();

        // Test case 1
        int[] nums1 = {1, 2, 1, 2, 3};
        int k1 = 2;
        int result1 = solution.subarraysWithKDistinct(nums1, k1);
        System.out.println("Test case 1 result: " + result1); // Expected output: 7

        // Test case 2
        int[] nums2 = {1, 2, 1, 3, 4};
        int k2 = 3;
        int result2 = solution.subarraysWithKDistinct(nums2, k2);
        System.out.println("Test case 2 result: " + result2); // Expected output: 3

        // Test case 3
        int[] nums3 = {1, 2, 1, 2, 3};
        int k3 = 3;
        int result3 = solution.subarraysWithKDistinct(nums3, k3);
        System.out.println("Test case 3 result: " + result3); // Expected output: 3
    }

}
