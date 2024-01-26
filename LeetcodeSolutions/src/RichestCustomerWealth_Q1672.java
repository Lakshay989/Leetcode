public class RichestCustomerWealth_Q1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0 ;
        for(int i = 0 ; i < accounts.length ; i++){
            int sum = 0 ;
            for(int j = 0 ; j < accounts[i].length ; j++){
                sum += accounts[i][j] ;
            }
            if(sum > max){
                max = sum ;
            }
        }
        return max ;
    }
    public static void main(String[] args) {
        RichestCustomerWealth_Q1672 solution = new RichestCustomerWealth_Q1672();

        // Test Case 1
        int[][] accounts1 = {{1, 2, 3}, {3, 2, 1}};
        int result1 = solution.maximumWealth(accounts1);
        System.out.println("Test Case 1: " + (result1 == 6 ? "Passed" : "Failed"));

        // Test Case 2
        int[][] accounts2 = {{1, 5}, {7, 3}, {3, 5}};
        int result2 = solution.maximumWealth(accounts2);
        System.out.println("Test Case 2: " + (result2 == 10 ? "Passed" : "Failed"));

        // Test Case 3
        int[][] accounts3 = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        int result3 = solution.maximumWealth(accounts3);
        System.out.println("Test Case 3: " + (result3 == 17 ? "Passed" : "Failed"));

        // Additional Test Case 4
        int[][] accounts4 = {{10, 5, 2}, {3, 8, 1}};
        int result4 = solution.maximumWealth(accounts4);
        System.out.println("Test Case 4: " + (result4 == 17 ? "Passed" : "Failed"));
    }
}
