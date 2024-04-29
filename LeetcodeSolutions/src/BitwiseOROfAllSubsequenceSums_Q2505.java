public class BitwiseOROfAllSubsequenceSums_Q2505 {
    public long subsequenceSumOr(int[] nums) {
        long result = 0;
        long prefixSum = 0;

        // Iterate through each element in the input array
        for (int num : nums) {
            // Update the cumulative sum by adding the current element
            prefixSum += num;
            // Update the result by performing bitwise OR with the current element and the cumulative sum
            result |= num | prefixSum;
        }

        return result;
    }

    public static void main(String[] args) {
        BitwiseOROfAllSubsequenceSums_Q2505 solver = new BitwiseOROfAllSubsequenceSums_Q2505();

        // Test case 1: Array with single element
        int[] nums1 = {5};
        long result1 = solver.subsequenceSumOr(nums1);
        System.out.println("Result for nums1: " + result1); // Expected output: 5

        // Test case 2: Array with multiple elements
        int[] nums2 = {1, 2, 3};
        long result2 = solver.subsequenceSumOr(nums2);
        System.out.println("Result for nums2: " + result2); // Expected output: 7

        // Test case 3: Array with negative numbers
        int[] nums3 = {-1, -2, -3};
        long result3 = solver.subsequenceSumOr(nums3);
        System.out.println("Result for nums3: " + result3); // Expected output: -1
    }
}
