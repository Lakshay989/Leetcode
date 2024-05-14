public class PathWithMaximumGold_Q1219 {
    public int getMaximumGold(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0 ;
        }

        int m = grid.length ;
        int n = grid[0].length ;

        int maxArea = 0 ;

        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] != 0){
                    maxArea = Math.max(maxArea, dfs(grid, i , j));
                }
            }
        }
        return maxArea ;
    }

    int dfs(int[][] matrix, int r, int c){

        int rows = matrix.length ;
        int columns = matrix[0].length ;

        if(r < 0 || r >= rows || c < 0 || c >= columns || matrix[r][c] == 0){
            return 0 ;
        }

        int value = matrix[r][c] ;
        int maxGold = 0 ;
        matrix[r][c] = 0 ;


        maxGold = Math.max(maxGold, dfs(matrix, r + 1, c));
        maxGold = Math.max(maxGold, dfs(matrix, r - 1, c));
        maxGold = Math.max(maxGold, dfs(matrix, r, c + 1));
        maxGold = Math.max(maxGold, dfs(matrix, r, c - 1));

        matrix[r][c] = value ;
        return maxGold + value ;
    }


    public static void main(String[] args) {
        PathWithMaximumGold_Q1219 solution = new PathWithMaximumGold_Q1219();

        // Test case 1
        int[][] grid1 = {
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        };
        int maxGold1 = solution.getMaximumGold(grid1);
        System.out.println("Test Case 1 Result:");
        System.out.println("Maximum Gold: " + maxGold1);
        // Expected output: 24

        // Test case 2
        int[][] grid2 = {
                {1, 0, 7},
                {2, 0, 6},
                {3, 4, 5},
                {0, 3, 0},
                {9, 0, 20}
        };
        int maxGold2 = solution.getMaximumGold(grid2);
        System.out.println("Test Case 2 Result:");
        System.out.println("Maximum Gold: " + maxGold2);
        // Expected output: 60

        // Add more test cases as needed
    }
}
