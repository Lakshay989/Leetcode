import java.util.Arrays;

public class TwoSumII_Q167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0 ;
        int right = numbers.length - 1;
        int sum = 0;

        while (left <= right){
            sum = numbers[left] + numbers[right];
            if (sum == target){
                return new int[]{left +1, right + 1} ;
            }
            else if( sum < target){
                left ++;
            }
            else{
                right --;
            }
        }
        return new int[2] ;
    }

    public static void main(String[] args) {
        TwoSumII_Q167 twoSumSolver = new TwoSumII_Q167();

        // Test cases
        int[] test1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSumSolver.twoSum(test1, target1);
        // Expected output: [1, 2] (indices are 1-based in the returned array)
        System.out.println("Test 1: " + Arrays.toString(result1));

        int[] test2 = {2, 3, 4};
        int target2 = 6;
        int[] result2 = twoSumSolver.twoSum(test2, target2);
        // Expected output: [1, 3]
        System.out.println("Test 2: " + Arrays.toString(result2));

        int[] test3 = {-1, 0};
        int target3 = -1;
        int[] result3 = twoSumSolver.twoSum(test3, target3);
        // Expected output: [1, 2]
        System.out.println("Test 3: " + Arrays.toString(result3));

        int[] test4 = {2, 3, 4, 6, 8, 11, 15};
        int target4 = 9;
        int[] result4 = twoSumSolver.twoSum(test4, target4);
        // Expected output: [1, 4]
        System.out.println("Test 4: " + Arrays.toString(result4));

        int[] test5 = {1, 2, 3, 4, 5};
        int target5 = 10;
        int[] result5 = twoSumSolver.twoSum(test5, target5);
        // Expected output: [] (empty array as no pair adds up to 10)
        System.out.println("Test 5: " + Arrays.toString(result5));
    }
}
