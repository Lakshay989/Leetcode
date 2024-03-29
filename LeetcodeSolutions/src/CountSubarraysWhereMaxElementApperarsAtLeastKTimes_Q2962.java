public class CountSubarraysWhereMaxElementApperarsAtLeastKTimes_Q2962 {
    public long countSubarrays(int[] nums, int k) {
        int maxNum = Integer.MIN_VALUE ;
        long result = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            maxNum = Integer.max(maxNum, nums[i]);
        }
        int count = 0 ;
        int left = 0 ;
        for(int right = 0 ; right < nums.length ; right ++){
            if (nums[right] == maxNum) {
                count++;
            }
            // Shrink the window
            while (k == count) {
                if (nums[left] == maxNum) {
                    count--;
                }
                left++;
            }
            result += left;
        }
        return result ;
    }
    public static void main(String[] args) {
        CountSubarraysWhereMaxElementApperarsAtLeastKTimes_Q2962 solution = new CountSubarraysWhereMaxElementApperarsAtLeastKTimes_Q2962();

        // Test case 1
        int[] nums1 = {2, 1, 4, 3};
        int k1 = 2;
        long result1 = solution.countSubarrays(nums1, k1);
        System.out.println("Test case 1 result: " + result1); // Expected output: 0

        // Test case 2
        int[] nums2 = {1, 2, 3, 4};
        int k2 = 2;
        long result2 = solution.countSubarrays(nums2, k2);
        System.out.println("Test case 2 result: " + result2); // Expected output: 0

        // Test case 3
        int[] nums3 = {5, 5, 5, 5, 5};
        int k3 = 2;
        long result3 = solution.countSubarrays(nums3, k3);
        System.out.println("Test case 3 result: " + result3); // Expected output: 10
    }
}
