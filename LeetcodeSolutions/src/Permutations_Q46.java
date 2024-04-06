import java.util.ArrayList;
import java.util.List;

public class Permutations_Q46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>() ;
        helper(0, nums, result) ;
        return result;
    }
    public void helper(int index, int[] nums, List<List<Integer>> result){
        if(index == nums.length){
            List<Integer> tempDS = new ArrayList<>();
            for(int i : nums){
                tempDS.add(i);
            }
            result.add(tempDS);
            return ;
        }

        for(int i = index ; i < nums.length ; i++){
            swap(i, index, nums);
            helper(index + 1, nums, result);
            swap(i, index, nums);
        }
    }

    public void swap(int i, int index, int[] nums){
        int t =  nums[i];
        nums[i] = nums[index] ;
        nums[index] = t ;
    }

    public static void main(String[] args) {
        Permutations_Q46 solution = new Permutations_Q46();

        // Test case 1
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = solution.permute(nums1);
        System.out.println("Test case 1 result: " + result1); // Expected output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]

        // Test case 2
        int[] nums2 = {0, 1};
        List<List<Integer>> result2 = solution.permute(nums2);
        System.out.println("Test case 2 result: " + result2); // Expected output: [[0, 1], [1, 0]]

        // Test case 3
        int[] nums3 = {1};
        List<List<Integer>> result3 = solution.permute(nums3);
        System.out.println("Test case 3 result: " + result3); // Expected output: [[1]]
    }
}



// public List<List<Integer>> permute(int[] nums) {
//     List<List<Integer>> result = new ArrayList<>() ;
//     boolean[] arr = new boolean[nums.length] ;
//     List<Integer> tempDS = new ArrayList<>();
//     helper(tempDS, result, arr, nums);
//     return result ;
// }

// void helper(List<Integer> tempDS, List<List<Integer>> result, boolean[] arr, int[] nums){
//     if(tempDS.size() == nums.length){
//         result.add(new ArrayList<>(tempDS));
//         return ;
//     }
//     for(int i = 0 ; i < nums.length; i++){
//         if(!arr[i]){
//             tempDS.add(nums[i]);
//             arr[i] = true;
//             helper(tempDS, result, arr, nums);
//             tempDS.remove(tempDS.size() - 1);
//             arr[i] = false ;
//         }
//     }
// }