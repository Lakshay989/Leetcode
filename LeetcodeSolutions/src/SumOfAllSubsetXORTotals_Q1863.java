public class SumOfAllSubsetXORTotals_Q1863 {
    public int subsetXORSum(int[] nums) {
        int result = 0;
        // Capture each bit that is set in any of the elements
        for (int num : nums) {
            result |= num;
        }
        // Multiply by the number of subset XOR totals that will have each bit set
        return result << (nums.length - 1);
    }

    public static void main(String[] args) {
        SumOfAllSubsetXORTotals_Q1863 solution = new SumOfAllSubsetXORTotals_Q1863();

        // Test case 1: Single element array
        int[] nums1 = {1};
        System.out.println(solution.subsetXORSum(nums1)); // True

        // Test case 2: Two element array
        int[] nums2 = {1, 3};
        System.out.println(solution.subsetXORSum(nums2)); // True

        // Test case 3: Multiple elements
        int[] nums3 = {5, 1, 6};
        System.out.println(solution.subsetXORSum(nums3)); // True

        // Test case 4: Zero in the array
        int[] nums4 = {0, 1, 2, 3, 4};
        System.out.println(solution.subsetXORSum(nums4)); // True

        // Test case 5: Larger numbers
        int[] nums5 = {7, 8, 9, 10};
        System.out.println(solution.subsetXORSum(nums5)); // True
    }
}
