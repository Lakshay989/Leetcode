import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFrequency_Q2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int result = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>() ;
        // Use two pointers to maintain a sliding window
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1) ;

            while( map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left ++ ;
            }
            result = Math.max(result, right - left + 1);  // right - left + 1 represents the current window size
        }
        return result ;
    }

    public static void main(String[] args) {
        LengthOfLongestSubarrayWithAtMostKFrequency_Q2958 solution = new LengthOfLongestSubarrayWithAtMostKFrequency_Q2958();

        // Test case 1: nums = [1,2,1,2,3], k = 2
        int[] nums1 = {1, 2, 1, 2, 3};
        int k1 = 2;
        System.out.println("Test case 1:");
        System.out.println("Input nums: " + Arrays.toString(nums1));
        System.out.println("k: " + k1);
        System.out.println("Output: " + solution.maxSubarrayLength(nums1, k1)); // Expected output: 4

        // Test case 2: nums = [1,2,1,3,4], k = 1
        int[] nums2 = {1, 2, 1, 3, 4};
        int k2 = 1;
        System.out.println("\nTest case 2:");
        System.out.println("Input nums: " + Arrays.toString(nums2));
        System.out.println("k: " + k2);
        System.out.println("Output: " + solution.maxSubarrayLength(nums2, k2)); // Expected output: 3
    }

}
