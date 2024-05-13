public class ScoreAfterFlippingMatrix_Q861 {
    public int matrixScore(int[][] grid) {
        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0; i<row; i++){
            if(grid[i][0]==0){
                toggleRow(grid, i);
            }
        }
        for(int i=0; i<col; i++){
            int a=0, b=0;
            for(int j=0; j<row; j++){
                if(grid[j][i]==1){ // As we are checking for columns so
                    a++;
                }
                else{
                    b++;
                }
            }
            if(a<b){
                toggleCol(grid, i);
            }
        }
        for(int i=0; i<grid.length; i++){
            ans+=bintodec(grid[i]);
        }
        return ans;
    }
    public void toggleRow(int[][] grid, int row){
        for(int i=0; i<grid[0].length; i++){
            if(grid[row][i] == 1){
                grid[row][i]=0;
            }
            else{
                grid[row][i] = 1;
            }
        }
    }
    public void toggleCol(int[][] grid, int col){
        for(int i=0; i<grid.length; i++){
            if(grid[i][col] == 1){
                grid[i][col]=0;
            }
            else{
                grid[i][col] = 1;
            }
        }
    }
    public int bintodec(int[] arr){
        int dec = 0;
        for(int i=0; i<arr.length; i++){
            dec = dec*2+arr[i];
        }
        return dec;
    }

    public static void main(String[] args) {
        ScoreAfterFlippingMatrix_Q861 solution = new ScoreAfterFlippingMatrix_Q861();

        // Test case 1
        int[][] grid1 = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        int score1 = solution.matrixScore(grid1);
        System.out.println("Test Case 1 Result:");
        System.out.println("Score: " + score1);
        // Expected output: 39

        // Test case 2
        int[][] grid2 = {{0, 1}, {1, 1}};
        int score2 = solution.matrixScore(grid2);
        System.out.println("Test Case 2 Result:");
        System.out.println("Score: " + score2);
        // Expected output: 7

        // Add more test cases as needed
    }
}
