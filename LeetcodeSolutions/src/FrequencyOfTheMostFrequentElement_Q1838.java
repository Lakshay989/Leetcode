import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement_Q1838 {
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, currSum = 0, res = 0;

        for(int right = 0; right < nums.length; right++){
            int target = nums[right];
            currSum += nums[right];

            while((right - left + 1)*target - currSum > k){
                currSum -= nums[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {3, 9, 6, 3, 7}; // Example input
        int k1 = 2;
        int result1 = maxFrequency(nums1, k1);
        System.out.println("Test Case 1 Result: " + result1);
        // Expected: 2

        // Test Case 2
        int[] nums2 = {1, 2, 4}; // Another example input
        int k2 = 5;
        int result2 = maxFrequency(nums2, k2);
        System.out.println("Test Case 2 Result: " + result2);
        // Expected: 3

        // Add more test cases as needed
    }
}
