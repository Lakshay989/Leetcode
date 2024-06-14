public class MinimumIncrementToMakeArrayUnique_Q945 {
    public int minIncrementForUnique(int[] nums) {
        int min = 0 ;
        int n = nums.length ;
        int duplicates = 0 ;
        int max = 0 ;

        for(int i = 0 ; i < n ; i ++){
            max = Math.max(max, nums[i]);
        }

        int[] freq = new int[n + max] ;

        for(int val : nums){
            freq[val] ++;
        }

        for(int i = 0 ; i < freq.length ; i++){
            if(freq[i] <= 1) continue ;

            duplicates = freq[i] - 1;
            freq[i + 1] += duplicates ;
            freq[i] = 1 ;
            min += duplicates ;
        }

        return min ;
    }
    public static void main(String[] args) {
        MinimumIncrementToMakeArrayUnique_Q945 solution = new MinimumIncrementToMakeArrayUnique_Q945();

        // Test case 1
        int[] test1 = {1, 2, 2};
        int result1 = solution.minIncrementForUnique(test1);
        System.out.println("Test 1: " + (result1 == 1 ? "Passed" : "Failed") + ", Result: " + result1);

        // Test case 2
        int[] test2 = {3, 2, 1, 2, 1, 7};
        int result2 = solution.minIncrementForUnique(test2);
        System.out.println("Test 2: " + (result2 == 6 ? "Passed" : "Failed") + ", Result: " + result2);

        // Test case 3
        int[] test3 = {0, 0, 0};
        int result3 = solution.minIncrementForUnique(test3);
        System.out.println("Test 3: " + (result3 == 3 ? "Passed" : "Failed") + ", Result: " + result3);

        // Test case 4
        int[] test4 = {1, 1, 1, 1, 1};
        int result4 = solution.minIncrementForUnique(test4);
        System.out.println("Test 4: " + (result4 == 10 ? "Passed" : "Failed") + ", Result: " + result4);

        // Test case 5
        int[] test5 = {10, 20, 30};
        int result5 = solution.minIncrementForUnique(test5);
        System.out.println("Test 5: " + (result5 == 0 ? "Passed" : "Failed") + ", Result: " + result5);

    }
}
