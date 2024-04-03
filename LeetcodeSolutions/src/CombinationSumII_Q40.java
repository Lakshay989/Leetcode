import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_Q40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>() ;
        Arrays.sort(candidates);
        helper(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    public void helper(int index, int[] candidates, int target, List<Integer> tempDS, List<List<Integer>> result){

        if(target == 0){
            result.add(new ArrayList<>(tempDS)) ;
            return ;
        }
        //return;
        if (target < 0) return;
        // pick
        for(int i = index ; i < candidates.length ; i++){
            if(i > index && candidates[i]== candidates[i-1]) continue ; // skips duplicates
            if(candidates[i] > target) break ;
            tempDS.add(candidates[i]);
            helper(i + 1, candidates, target - candidates[i], tempDS, result);
            tempDS.remove(tempDS.size() - 1);
        }
    }
    public static void main(String[] args) {
        CombinationSumII_Q40 solution = new CombinationSumII_Q40();

        // Test case 1
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        List<List<Integer>> result1 = solution.combinationSum2(candidates1, target1);
        System.out.println("Test case 1 result: " + result1); // Expected output: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]

        // Test case 2
        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        List<List<Integer>> result2 = solution.combinationSum2(candidates2, target2);
        System.out.println("Test case 2 result: " + result2); // Expected output: [[1, 2, 2], [5]]

        // Test case 3
        int[] candidates3 = {1, 2, 3};
        int target3 = 10;
        List<List<Integer>> result3 = solution.combinationSum2(candidates3, target3);
        System.out.println("Test case 3 result: " + result3); // Expected output: []
    }
}
