public class FindTheNumberOfGoodPairs_Q3162 {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int result = 0 ;
        int n = nums1.length ;
        int m = nums2.length ;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(nums1[i] % (nums2[j] * k) == 0){
                    result ++ ;
                }
            }
        }

        return result ;
    }

    public static void main(String[] args) {
        FindTheNumberOfGoodPairs_Q3162 solution = new FindTheNumberOfGoodPairs_Q3162();

        // Test Case 1: Basic test case
        int[] nums1_1 = {10, 20, 30};
        int[] nums2_1 = {1, 2, 3};
        int k1 = 2;
        System.out.println("Test Case 1: " + solution.numberOfPairs(nums1_1, nums2_1, k1)); // Expected Output: 3

        // Test Case 2: No valid pairs
        int[] nums1_2 = {7, 11, 13};
        int[] nums2_2 = {2, 4, 6};
        int k2 = 3;
        System.out.println("Test Case 2: " + solution.numberOfPairs(nums1_2, nums2_2, k2)); // Expected Output: 0

        // Test Case 3: All pairs are valid
        int[] nums1_3 = {12, 24, 36};
        int[] nums2_3 = {1, 2, 3};
        int k3 = 1;
        System.out.println("Test Case 3: " + solution.numberOfPairs(nums1_3, nums2_3, k3)); // Expected Output: 9

        // Test Case 4: Large values of k
        int[] nums1_4 = {100, 200, 300};
        int[] nums2_4 = {10, 20, 30};
        int k4 = 5;
        System.out.println("Test Case 4: " + solution.numberOfPairs(nums1_4, nums2_4, k4)); // Expected Output: 6

        // Test Case 5: Array with zeros
        int[] nums1_5 = {0, 0, 0};
        int[] nums2_5 = {1, 2, 3};
        int k5 = 1;
        System.out.println("Test Case 5: " + solution.numberOfPairs(nums1_5, nums2_5, k5)); // Expected Output: 9

        // Test Case 6: Different sizes of nums1 and nums2
        int[] nums1_6 = {5, 10};
        int[] nums2_6 = {1, 2, 3, 4};
        int k6 = 2;
        System.out.println("Test Case 6: " + solution.numberOfPairs(nums1_6, nums2_6, k6)); // Expected Output: 2

        // Test Case 7: Edge case with minimum values
        int[] nums1_7 = {1};
        int[] nums2_7 = {1};
        int k7 = 1;
        System.out.println("Test Case 7: " + solution.numberOfPairs(nums1_7, nums2_7, k7)); // Expected Output: 1
    }
}
