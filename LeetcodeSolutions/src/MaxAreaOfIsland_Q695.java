public class MaxAreaOfIsland_Q695 {
    int dfs(int[][] grid, int r, int c){
        int numRows = grid.length ;
        int numCols = grid[0].length ;

        if(r < 0 || c < 0 || r >= numRows || c >= numCols || grid[r][c] ==0 ){
            return 0;
        }
        grid[r][c] = 0 ;
        return dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1) + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {

        if(grid.length == 0 || grid == null){
            return 0 ;
        }

        int maxArea = 0 ;

        for(int r = 0 ; r < grid.length ; r++){
            for(int c = 0 ; c < grid[0].length ; c++){
                if(grid[r][c] == 1){
                    maxArea = Math.max(maxArea, dfs(grid, r, c)) ;
                }
            }
        }

        return maxArea ;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland_Q695 solver = new MaxAreaOfIsland_Q695();

        // Test case 1: Grid with a single island
        int[][] grid1 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        int result1 = solver.maxAreaOfIsland(grid1);
        System.out.println("Result for grid1: " + result1); // Expected output: 6

        // Test case 2: Grid with multiple islands
        int[][] grid2 = {
                {1, 0, 1, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 1, 0, 1}
        };
        int result2 = solver.maxAreaOfIsland(grid2);
        System.out.println("Result for grid2: " + result2); // Expected output: 5
    }
}
