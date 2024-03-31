public class CountAlternatingSubarrays_Q3101 {
    public long countAlternatingSubarrays(int[] nums) {
        long count = 0;
        long consecutive = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                consecutive++;
            } else {
                count += (consecutive * (consecutive + 1)) / 2;
                consecutive = 1;
            }
        }
        count += (consecutive * (consecutive + 1)) / 2;
        return count;
    }

    public static void main(String[] args) {
        CountAlternatingSubarrays_Q3101 solution = new CountAlternatingSubarrays_Q3101();

        // Test case 1
        int[] nums1 = {1, 0, 1, 0, 1};
        long result1 = solution.countAlternatingSubarrays(nums1);
        System.out.println("Test case 1 result: " + result1); // Expected output: 15

        // Test case 2
        int[] nums2 = {0, 1, 0, 1, 0};
        long result2 = solution.countAlternatingSubarrays(nums2);
        System.out.println("Test case 2 result: " + result2); // Expected output: 15

        // Test case 3
        int[] nums3 = {1, 1, 1, 1, 1};
        long result3 = solution.countAlternatingSubarrays(nums3);
        System.out.println("Test case 3 result: " + result3); // Expected output: 5

        // Test case 4
        int[] nums4 = {0, 0, 0, 0, 0};
        long result4 = solution.countAlternatingSubarrays(nums4);
        System.out.println("Test case 4 result: " + result4); // Expected output: 5
    }
}
