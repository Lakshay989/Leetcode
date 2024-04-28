import java.util.Arrays;

public class FindTheIntegerAddedToArrayI_Q3131 {
    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0] ;

    }
    public static void main(String[] args) {
        FindTheIntegerAddedToArrayI_Q3131 finder = new FindTheIntegerAddedToArrayI_Q3131();

        // Test case 1: Arrays with positive integers
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        int addedInteger1 = finder.addedInteger(nums1, nums2);
        System.out.println("Integer added to make the arrays consecutive: " + addedInteger1); // Expected output: 1

        // Test case 2: Arrays with negative integers
        int[] nums3 = {-3, -1, 1};
        int[] nums4 = {-2, 0, 2};
        int addedInteger2 = finder.addedInteger(nums3, nums4);
        System.out.println("Integer added to make the arrays consecutive: " + addedInteger2); // Expected output: 1

        // Test case 3: Arrays with mixed positive and negative integers
        int[] nums5 = {-2, 0, 2};
        int[] nums6 = {1, 3, 5};
        int addedInteger3 = finder.addedInteger(nums5, nums6);
        System.out.println("Integer added to make the arrays consecutive: " + addedInteger3); // Expected output: 3
    }
}
