import java.util.ArrayList;
import java.util.List;

public class Subsets_Q78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(ans, 0, nums, list);
        return ans;
    }

    public void helper(
            List<List<Integer>> ans,
            int start,
            int[] nums,
            List<Integer> list
    ) {
        if (start >= nums.length) {
            ans.add(new ArrayList<>(list));
        } else {
            // add the element and start the  recursive call
            list.add(nums[start]);
            helper(ans, start + 1, nums, list);
            // remove the element and do the backtracking call.
            list.remove(list.size() - 1);
            helper(ans, start + 1, nums, list);
        }
    }
    public static void main(String[] args) {
        Subsets_Q78 solution = new Subsets_Q78();

        // Test case 1
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = solution.subsets(nums1);
        System.out.println("Test case 1 result: " + result1); // Expected output: [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]

        // Test case 2
        int[] nums2 = {0};
        List<List<Integer>> result2 = solution.subsets(nums2);
        System.out.println("Test case 2 result: " + result2); // Expected output: [[],[0]]

        // Test case 3
        int[] nums3 = {4, 5, 6, 7};
        List<List<Integer>> result3 = solution.subsets(nums3);
        System.out.println("Test case 3 result: " + result3); // Expected output: [[],[4],[4,5],[4,5,6],[4,5,6,7],[4,5,7],[4,6],[4,6,7],[4,7],[5],[5,6],[5,6,7],[5,7],[6],[6,7],[7]]
    }
}
