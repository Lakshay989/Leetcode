import java.util.Arrays;

public class CountPairsInTwoArrays_Q1885 {
    public long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        if (n < 2)              // If can't make any pairs good or bad.
            return 0;

        boolean positiveOnly = true;
        for (int i = n - 1; i >= 0; i--)
            if ((nums1[i] -= nums2[i]) <= 0)
                positiveOnly = false;
        if (positiveOnly)       // If all pairs are valid.
            return ((long)(n - 1) * n) / 2;

        Arrays.sort(nums1);

        long result = 0;
        int left = 0;
        int leftNum = nums1[0];
        int right = n - 1;
        int rightNum = nums1[right];
        while (left < right) {
            if (leftNum + rightNum <= 0)
                leftNum = nums1[++left];
            else {
                result += right - left;
                rightNum = nums1[--right];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CountPairsInTwoArrays_Q1885 counter = new CountPairsInTwoArrays_Q1885();

        // Test case 1: Empty arrays
        int[] nums1_1 = {};
        int[] nums2_1 = {};
        System.out.println("Test case 1:");
        System.out.println("Number of pairs: " + counter.countPairs(nums1_1, nums2_1));

        // Test case 2: Arrays with single elements
        int[] nums1_2 = {1};
        int[] nums2_2 = {2};
        System.out.println("\nTest case 2:");
        System.out.println("Number of pairs: " + counter.countPairs(nums1_2, nums2_2));

        // Test case 3: Arrays with multiple elements
        int[] nums1_3 = {1, 2, 3};
        int[] nums2_3 = {1, 2, 3};
        System.out.println("\nTest case 3:");
        System.out.println("Number of pairs: " + counter.countPairs(nums1_3, nums2_3));

        // Test case 4: Arrays with negative elements
        int[] nums1_4 = {1, -2, 3};
        int[] nums2_4 = {-1, 2, -3};
        System.out.println("\nTest case 4:");
        System.out.println("Number of pairs: " + counter.countPairs(nums1_4, nums2_4));
    }
}
