import java.util.Arrays;

public class FindTheIntegerAddedToArrayII_Q3132 {
    public boolean check(int[] nums1, int[] nums2, int k) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < nums1.length && j < nums2.length; i++) {
            if (nums1[i] + k != nums2[j]) count++;
            else j++;
        }
        return count <= 2;
    }

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int minEle = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            int x = nums2[0] - nums1[i];
            if (check(nums1, nums2, x)) {
                minEle = Math.min(minEle, x);
            }
        }
        return minEle;
    }
    public static void main(String[] args) {
        FindTheIntegerAddedToArrayII_Q3132 solution = new FindTheIntegerAddedToArrayII_Q3132();

        int[] nums1_1 = {4, 20, 16, 12, 8};
        int[] nums2_1 = {14, 18, 10};
        System.out.println("Output for Example 1: " + solution.minimumAddedInteger(nums1_1, nums2_1));

        int[] nums1_2 = {3, 5, 5, 3};
        int[] nums2_2 = {7, 7};
        System.out.println("Output for Example 2: " + solution.minimumAddedInteger(nums1_2, nums2_2));
    }
}
