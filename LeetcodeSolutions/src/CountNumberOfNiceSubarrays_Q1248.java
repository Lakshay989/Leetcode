public class CountNumberOfNiceSubarrays_Q1248 {
    public int numberOfSubarrays(int[] A, int k) {
        int res = 0, i = 0, count = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            if (A[j] % 2 == 1) {
                --k;
                count = 0;
            }
            while (k == 0) {
                k += A[i++] & 1;
                ++count;
            }
            res += count;
        }
        return res;
    }
    public static void main(String[] args) {
        CountNumberOfNiceSubarrays_Q1248 obj = new CountNumberOfNiceSubarrays_Q1248();

        // Test case 1
        int[] A1 = {1, 1, 2, 1, 1};
        int k1 = 3;
        System.out.println(obj.numberOfSubarrays(A1, k1)); // Expected output: 2

        // Test case 2
        int[] A2 = {2, 4, 6};
        int k2 = 1;
        System.out.println(obj.numberOfSubarrays(A2, k2)); // Expected output: 0

        // Test case 3
        int[] A3 = {2, 2, 2, 1, 2, 2, 1, 1};
        int k3 = 2;
        System.out.println(obj.numberOfSubarrays(A3, k3)); // Expected output: 7

        // Test case 4
        int[] A4 = {1, 2, 3, 4, 5};
        int k4 = 1;
        System.out.println(obj.numberOfSubarrays(A4, k4)); // Expected output: 8

        // Test case 5
        int[] A5 = {1, 1, 1, 1, 1};
        int k5 = 2;
        System.out.println(obj.numberOfSubarrays(A5, k5)); // Expected output: 4

        // Test case 6
        int[] A6 = {1, 2, 1, 2, 1};
        int k6 = 3;
        System.out.println(obj.numberOfSubarrays(A6, k6)); // Expected output: 1

        // Test case 7
        int[] A7 = {2, 2, 2, 2, 2};
        int k7 = 1;
        System.out.println(obj.numberOfSubarrays(A7, k7)); // Expected output: 0

        // Test case 8
        int[] A8 = {2, 4, 6, 8, 10, 1};
        int k8 = 1;
        System.out.println(obj.numberOfSubarrays(A8, k8)); // Expected output: 6

        // Test case 9
        int[] A9 = {1, 2, 1, 2, 1, 2, 1, 2};
        int k9 = 4;
        System.out.println(obj.numberOfSubarrays(A9, k9)); // Expected output: 2

        // Test case 10
        int[] A10 = {1, 3, 5, 7, 9};
        int k10 = 2;
        System.out.println(obj.numberOfSubarrays(A10, k10)); // Expected output: 4
    }
}
