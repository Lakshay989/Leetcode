import java.util.Arrays;
import java.util.HashMap;

public class DivideArrayInSetsOfKConsecutiveNumbers_Q1296 {
    // Similar to Q846
    public boolean isPossibleDivide(int[] A, int k) {
        Arrays.sort(A);
        int[] buckets = new int[k];
        for (int i = 0; i < A.length; i++) {
            if (i % k != 0 && A[i] - A[i - 1] > 1) return false;
            buckets[A[i] % k]++;
        }

        for (int bucket: buckets) {
            if (bucket != buckets[0]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        DivideArrayInSetsOfKConsecutiveNumbers_Q1296 solution = new DivideArrayInSetsOfKConsecutiveNumbers_Q1296();

        // Test case 1
        int[] nums1 = {1, 2, 3, 3, 4, 4, 5, 6};
        int k1 = 4;
        System.out.println(solution.isPossibleDivide(nums1, k1)); // Expected: true

        // Test case 2
        int[] nums2 = {3, 3, 2, 2, 1, 1};
        int k2 = 3;
        System.out.println(solution.isPossibleDivide(nums2, k2)); // Expected: true

        // Test case 3
        int[] nums3 = {1, 2, 3, 4};
        int k3 = 3;
        System.out.println(solution.isPossibleDivide(nums3, k3)); // Expected: false

        // Test case 4
        int[] nums4 = {1, 2, 3, 4, 5, 6, 7, 8};
        int k4 = 4;
        System.out.println(solution.isPossibleDivide(nums4, k4)); // Expected: true
    }
}
