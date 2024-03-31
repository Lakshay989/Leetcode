public class CountSubarraysWithFixedBounds_Q2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minI = -1, maxI = -1, left = -1, right = 0;
        long count = 0;
        while(right < nums.length){
            if(nums[right] < minK || nums[right] > maxK){
                minI = right;
                maxI = right;
                left = right;
            }
            minI = nums[right] == minK ? right : minI;
            maxI = nums[right] == maxK ?  right : maxI;
            count += Math.min(minI, maxI) - left;
            right++;
        }
        return count;
    }
    public static void main(String[] args) {
        CountSubarraysWithFixedBounds_Q2444 solution = new CountSubarraysWithFixedBounds_Q2444();

        // Test case 1
        int[] nums1 = {2, 3, 1, 4, 5};
        int minK1 = 2;
        int maxK1 = 4;
        long result1 = solution.countSubarrays(nums1, minK1, maxK1);
        System.out.println("Test case 1 result: " + result1); // Expected output: 0

        // Test case 2
        int[] nums2 = {1, 2, 3, 4, 5};
        int minK2 = 2;
        int maxK2 = 4;
        long result2 = solution.countSubarrays(nums2, minK2, maxK2);
        System.out.println("Test case 2 result: " + result2); // Expected output: 1

        // Test case 3
        int[] nums3 = {2, 3, 1, 4, 5};
        int minK3 = 1;
        int maxK3 = 5;
        long result3 = solution.countSubarrays(nums3, minK3, maxK3);
        System.out.println("Test case 3 result: " + result3); // Expected output: 3
    }

}
