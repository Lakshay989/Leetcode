import java.util.HashMap;
import java.util.Map;

public class FindTheNumberOfGoodPairsII_Q3164 {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> nm = new HashMap<>();
        for(int i : nums2)
        {
            int val = i * k;
            nm.put(val, nm.getOrDefault(val, 0) + 1);
        }
        long ans=0;
        for(int i : nums1)
        {
            for(int j=1;j*j<=i;j++)
            {
                if(i%j==0)
                {
                    if(nm.containsKey(j))
                    {
                        ans += nm.get(j);
                    }
                    int val=i/j;
                    if(j!=val && nm.containsKey(val))
                    {
                        ans += nm.get(val);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindTheNumberOfGoodPairsII_Q3164 solution = new FindTheNumberOfGoodPairsII_Q3164();

        // Test Case 1: Basic test case
        int[] nums1_test1 = {4, 8, 12};
        int[] nums2_test1 = {2, 3, 4};
        int k_test1 = 2;
        System.out.println("Test Case 1: " + solution.numberOfPairs(nums1_test1, nums2_test1, k_test1)); // Expected Output: 5

        // Test Case 2: nums2 elements not multiples of k
        int[] nums1_test2 = {5, 10, 15};
        int[] nums2_test2 = {1, 2, 3};
        int k_test2 = 5;
        System.out.println("Test Case 2: " + solution.numberOfPairs(nums1_test2, nums2_test2, k_test2)); // Expected Output: 3

        // Test Case 3: Large k value
        int[] nums1_test3 = {100, 200, 300};
        int[] nums2_test3 = {5, 10, 20};
        int k_test3 = 50;
        System.out.println("Test Case 3: " + solution.numberOfPairs(nums1_test3, nums2_test3, k_test3)); // Expected Output: 0

        // Test Case 4: Edge case with one element in each array
        int[] nums1_test4 = {6};
        int[] nums2_test4 = {2};
        int k_test4 = 3;
        System.out.println("Test Case 4: " + solution.numberOfPairs(nums1_test4, nums2_test4, k_test4)); // Expected Output: 1

        // Test Case 5: All elements are 1
        int[] nums1_test5 = {1, 1, 1};
        int[] nums2_test5 = {1, 1, 1};
        int k_test5 = 1;
        System.out.println("Test Case 5: " + solution.numberOfPairs(nums1_test5, nums2_test5, k_test5)); // Expected Output: 9

        // Test Case 6: No valid pairs
        int[] nums1_test6 = {2, 4, 6};
        int[] nums2_test6 = {5, 7, 9};
        int k_test6 = 3;
        System.out.println("Test Case 6: " + solution.numberOfPairs(nums1_test6, nums2_test6, k_test6)); // Expected Output: 0
    }
}
