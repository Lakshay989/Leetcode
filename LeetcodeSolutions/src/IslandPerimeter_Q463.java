public class IslandPerimeter_Q463 {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0 ;

        for(int i = 0  ; i < grid.length ; i++){
            for(int j = 0 ;j < grid[0].length ; j++){
                if(grid[i][j] == 1 ){
                    perimeter +=4 ;

                    if(i > 0 && grid[i-1][j] == 1){
                        perimeter -= 2;
                    }

                    if(j > 0 && grid[i][j-1] == 1){
                        perimeter -=2 ;
                    }
                }

            }
        }
        return perimeter ;
    }

    public static void main(String[] args) {
        IslandPerimeter_Q463 solution = new IslandPerimeter_Q463();

        // Test cases
        int[][] grid1 = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println("Perimeter of island: " + solution.islandPerimeter(grid1)); // Expected: 16

        int[][] grid2 = {
                {1, 0},
                {1, 1}
        };
        System.out.println("Perimeter of island: " + solution.islandPerimeter(grid2)); // Expected: 8

        int[][] grid3 = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        };
        System.out.println("Perimeter of island: " + solution.islandPerimeter(grid3)); // Expected: 12
    }
}
