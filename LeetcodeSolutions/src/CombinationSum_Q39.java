import java.util.ArrayList;
import java.util.List;

public class CombinationSum_Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>() ;
        helper(0, candidates, target, result, new ArrayList<>());
        return result ;
    }
    public void helper(int index, int[] candidates,int target, List<List<Integer>> result, List<Integer> tempDS){
        if(index >= candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(tempDS)) ; // new ArrayList<>(tempDS)
            }
            return ;
        }
        // pick
        if(target >= candidates[index]){
            tempDS.add(candidates[index]);
            helper(index, candidates, target - candidates[index], result, tempDS);
            tempDS.remove(tempDS.size() - 1);
        }
        // not pick
        helper(index + 1, candidates, target, result, tempDS);
    }

    public static void main(String[] args) {
        CombinationSum_Q39 solution = new CombinationSum_Q39();

        // Test case 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        List<List<Integer>> result1 = solution.combinationSum(candidates1, target1);
        System.out.println("Test case 1 result: " + result1); // Expected output: [[2, 2, 3], [7]]

        // Test case 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        List<List<Integer>> result2 = solution.combinationSum(candidates2, target2);
        System.out.println("Test case 2 result: " + result2); // Expected output: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

        // Test case 3
        int[] candidates3 = {2};
        int target3 = 1;
        List<List<Integer>> result3 = solution.combinationSum(candidates3, target3);
        System.out.println("Test case 3 result: " + result3); // Expected output: []
    }
}
