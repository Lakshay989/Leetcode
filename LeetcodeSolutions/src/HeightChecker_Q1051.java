import java.util.Arrays;

public class HeightChecker_Q1051 {
    public int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];

        for(int i = 0 ; i < expected.length ; i++ ){
            expected[i] = heights[i] ;
        }

        Arrays.sort(expected);
        int count = 0 ;

        for(int i = 0 ; i < heights.length ; i++){
            if(expected[i] != heights[i]) count++ ;
        }
        return count ;
    }

    public static void main(String[] args) {
        HeightChecker_Q1051 solution = new HeightChecker_Q1051();

        // Test cases
        int[] heights1 = {1, 1, 4, 2, 1, 3};
        int[] heights2 = {5, 1, 2, 3, 4};
        int[] heights3 = {1, 2, 3, 4, 5};

        System.out.println(solution.heightChecker(heights1)); // Expected: 3
        System.out.println(solution.heightChecker(heights2)); // Expected: 5
        System.out.println(solution.heightChecker(heights3)); // Expected: 0
    }
}
