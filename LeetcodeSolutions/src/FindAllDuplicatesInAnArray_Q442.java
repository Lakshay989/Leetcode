import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray_Q442 {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        // Use cycle sort to place elements
        // at corresponding index to value
        int i = 0;
        while (i < n) {
            int correctIdx = nums[i] - 1;
            if (nums[i] != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            } else {
                i++;
            }
        }

        // Any elements not at the index that corresponds to their value are duplicates
        List<Integer> duplicates = new ArrayList<>();
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                duplicates.add(nums[i]);
            }
        }

        return duplicates;
    }

    // Swaps two elements in nums
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public static void main(String[] args) {
        FindAllDuplicatesInAnArray_Q442 solution = new FindAllDuplicatesInAnArray_Q442();

        // Test cases
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Duplicates in nums1: " + solution.findDuplicates(nums1));

        int[] nums2 = {1, 1, 2, 2, 3, 3};
        System.out.println("Duplicates in nums2: " + solution.findDuplicates(nums2));

        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("Duplicates in nums3: " + solution.findDuplicates(nums3));
    }
}
