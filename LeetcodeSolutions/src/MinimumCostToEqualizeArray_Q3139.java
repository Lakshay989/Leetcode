import java.util.Arrays;

public class MinimumCostToEqualizeArray_Q3139 {
    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        int ma = nums[0], mi = nums[0], n = nums.length, mod = 1000000007;
        long total = 0;
        for (int a: nums) {
            mi = Math.min(mi, a);
            ma = Math.max(ma, a);
            total += a;
        }
        total = 1l * ma * n - total;

        // case 1
        if (cost1 * 2 <= cost2 || n <= 2) {
            return (int) ((total * cost1) % mod);
        }

        // case 2
        long op1 = Math.max(0L, (ma - mi) * 2L - total);
        long op2 = total - op1;
        long res = (op1 + op2 % 2) * cost1 + op2 / 2 * cost2;

        // case 3
        total += op1 / (n - 2) * n;
        op1 %= n - 2;
        op2 = total - op1;
        res = Math.min(res, (op1 + op2 % 2) * cost1 + op2 / 2 * cost2);

        // case 4
        for (int i = 0; i < 2; i++) {
            total += n;
            res = Math.min(res, total % 2 * cost1 + total / 2 * cost2);
        }
        return (int) (res % mod);
    }

    public static void main(String[] args) {
        MinimumCostToEqualizeArray_Q3139 solver = new MinimumCostToEqualizeArray_Q3139();

        // Test case 1
        int[] nums1 = {4, 1};
        int cost11 = 5;
        int cost12 = 2;
        System.out.println("Example 1:");
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", cost1 = " + cost11 + ", cost2 = " + cost12);
        System.out.println("Output: " + solver.minCostToEqualizeArray(nums1, cost11, cost12));

        // Test case 2
        int[] nums2 = {2, 3, 3, 3, 5};
        int cost21 = 2;
        int cost22 = 1;
        System.out.println("\nExample 2:");
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", cost1 = " + cost21 + ", cost2 = " + cost22);
        System.out.println("Output: " + solver.minCostToEqualizeArray(nums2, cost21, cost22));

        // Test case 3
        int[] nums3 = {3, 5, 3};
        int cost31 = 1;
        int cost32 = 3;
        System.out.println("\nExample 3:");
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", cost1 = " + cost31 + ", cost2 = " + cost32);
        System.out.println("Output: " + solver.minCostToEqualizeArray(nums3, cost31, cost32));
    }
}
