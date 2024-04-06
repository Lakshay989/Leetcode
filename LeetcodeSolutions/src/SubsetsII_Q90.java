import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_Q90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //List<List>
        Arrays.sort(nums);
        helper(0, nums, result, new ArrayList<>());
        return result ;
    }

    public void helper(int index, int[] nums, List<List<Integer>> result, List<Integer> tempDS){
        if(index == nums.length){
            result.add(new ArrayList<>(tempDS));
            return ;
        }

        // pick
        tempDS.add(nums[index]);
        helper(index + 1, nums, result, tempDS);
        tempDS.remove(tempDS.size() - 1);

        // Not pick dupes and not pick in general
        while(index + 1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }
        helper(index + 1, nums, result, tempDS);
    }
    public static void main(String[] args) {
        SubsetsII_Q90 solution = new SubsetsII_Q90();

        // Test case 1
        int[] nums1 = {1, 2, 2};
        List<List<Integer>> result1 = solution.subsetsWithDup(nums1);
        System.out.println("Test case 1 result: " + result1); // Expected output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

        // Test case 2
        int[] nums2 = {0};
        List<List<Integer>> result2 = solution.subsetsWithDup(nums2);
        System.out.println("Test case 2 result: " + result2); // Expected output: [[],[0]]

        // Test case 3
        int[] nums3 = {4, 4, 4, 1, 4};
        List<List<Integer>> result3 = solution.subsetsWithDup(nums3);
        System.out.println("Test case 3 result: " + result3); // Expected output: [[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]
    }
}
