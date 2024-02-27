import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_Q120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1] ;

        for(int i = triangle.size() - 1 ; i >= 0 ; i-- ){
            for(int j = 0 ; j < triangle.get(i).size() ; j++){

                dp[j] = triangle.get(i).get(j) + Integer.min(dp[j], dp[j+1]) ;
            }
        }
        return dp[0] ;
    }

    public static void main(String[] args) {
        Triangle_Q120 triangleSolver = new Triangle_Q120();

        // Test Case 1: Triangle with three rows
        //     2
        //    3 4
        //   6 5 7
        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(Arrays.asList(2));
        triangle1.add(Arrays.asList(3, 4));
        triangle1.add(Arrays.asList(6, 5, 7));
        System.out.println("Test Case 1: " + (triangleSolver.minimumTotal(triangle1) == 10 ? "Passed" : "Failed"));

        // Test Case 2: Triangle with four rows
        //      2
        //     3 4
        //    6 5 7
        //   4 1 8 3
        List<List<Integer>> triangle2 = new ArrayList<>();
        triangle2.add(Arrays.asList(2));
        triangle2.add(Arrays.asList(3, 4));
        triangle2.add(Arrays.asList(6, 5, 7));
        triangle2.add(Arrays.asList(4, 1, 8, 3));
        System.out.println("Test Case 2: " + (triangleSolver.minimumTotal(triangle2) == 11 ? "Passed" : "Failed"));

        // Test Case 3: Empty triangle
        List<List<Integer>> triangle3 = new ArrayList<>();
        System.out.println("Test Case 3: " + (triangleSolver.minimumTotal(triangle3) == 0 ? "Passed" : "Failed"));
    }
}
