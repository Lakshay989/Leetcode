public class SortColors_Q75 {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        for (int i = 0; i <= r;)
            if (nums[i] == 0)
                swap(nums, i++, l++);
            else if (nums[i] == 1)
                ++i;
            else
                swap(nums, i, r--);
    }

    private void swap(int[] nums, int i, int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors_Q75 solution = new SortColors_Q75();

        // Test case
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);

        System.out.print("Sorted array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Expected output: 0 0 1 1 2 2
    }
}
