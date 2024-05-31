import java.util.Arrays;

public class SingleNumberIII_Q260 {
    public int[] singleNumber(int[] nums) {
        int XOR = 0 ;

        for(int i = 0 ; i < nums.length ; i++){
            XOR ^= nums[i] ;
        }

        int diff = XOR & (-XOR);
        int res = 0 ;
        for(int num : nums) if ((num & diff) != 0) res ^= num ;

        return new int[] {res, XOR ^res} ;
    }
    public static void main(String[] args) {
        SingleNumberIII_Q260 solution = new SingleNumberIII_Q260();

        // Test case 1
        int[] nums1 = {1, 2, 1, 3, 2, 5};
        int[] expected1 = {3, 5};
        System.out.println("Test Case 1 Passed: " + Arrays.equals(solution.singleNumber(nums1), expected1));

        // Test case 2
        int[] nums2 = {2, 4, 6, 8, 10, 2, 4, 6};
        int[] expected2 = {8, 10};
        System.out.println("Test Case 2 Passed: " + Arrays.equals(solution.singleNumber(nums2), expected2));

        // Test case 3
        int[] nums3 = {1, 2, 1, 2, 3, 4};
        int[] expected3 = {3, 4};
        System.out.println("Test Case 3 Passed: " + Arrays.equals(solution.singleNumber(nums3), expected3));

        // Test case 4
        int[] nums4 = {-1, 0, 0, -1, 4, 5};
        int[] expected4 = {4, 5};
        System.out.println("Test Case 4 Passed: " + Arrays.equals(solution.singleNumber(nums4), expected4));
    }
}
