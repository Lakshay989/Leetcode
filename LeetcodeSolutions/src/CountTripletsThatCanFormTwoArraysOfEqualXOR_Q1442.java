public class CountTripletsThatCanFormTwoArraysOfEqualXOR_Q1442 {
    public int countTriplets(int[] nums) {

        int count = 0;

        for(int i = 0; i < nums.length; i++){
            int xor = 0;
            for(int j = i; j < nums.length; j++){
                xor ^= nums[j];
                if(xor == 0) count += (j - i);
            }
        }

        return count;
    }
        public static void main(String[] args) {
        CountTripletsThatCanFormTwoArraysOfEqualXOR_Q1442 solution = new CountTripletsThatCanFormTwoArraysOfEqualXOR_Q1442();

        // Test case 1: Example test case
        int[] nums1 = {2, 3, 1, 6, 7};
            System.out.println("Test Case 1: " + solution.countTriplets(nums1)); // Expected output: 4

        // Test case 2: No triplet forms two equal XOR arrays
        int[] nums2 = {1, 1, 1, 1};
            System.out.println("Test Case 2: " + solution.countTriplets(nums2)); // Expected output: 6

        // Test case 3: Array with all elements same
        int[] nums3 = {1, 1, 1};
            System.out.println("Test Case 3: " + solution.countTriplets(nums3)); // Expected output: 1

        // Test case 4: Array with one element
        int[] nums4 = {1};
            System.out.println("Test Case 4: " + solution.countTriplets(nums4)); // Expected output: 0

        // Test case 5: Mixed array with varying elements
        int[] nums5 = {5, 3, 2, 5, 7, 2};
            System.out.println("Test Case 5: " + solution.countTriplets(nums5)); // Expected output: 0

        // Test case 6: Another mixed array
        int[] nums6 = {4, 4, 4, 4};
            System.out.println("Test Case 6: " + solution.countTriplets(nums6)); // Expected output: 3

        // Test case 7: Larger array with random elements
        int[] nums7 = {1, 3, 5, 7, 9, 11, 13, 15};
            System.out.println("Test Case 7: " + solution.countTriplets(nums7)); // Expected output: 0
    }
}
