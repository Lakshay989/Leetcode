public class SurroundedRegions_Q130 {
    public void solve(char[][] board) {

        if(board == null){
            return;
        }

        int m = board.length ;
        int n = board[0].length ;

        char[][] grid = board ;

        for (int i = 0; i < m; i++) {
            if (board[i][0]=='O') {
                dfs(grid, i, 0);
            }
            if (board[i][n-1]=='O') {
                dfs(grid, i, n-1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j]=='O') {
                dfs(board, 0, j);
            }
            if (board[m-1][j]=='O') {
                dfs(board, m-1, j);
                //board[r-1][j]='a';
            }
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 'S'){
                    board[i][j] = 'O';
                }
                else{
                    board[i][j] = 'X' ;
                }
            }
        }
    }

    public void dfs(char[][] grid , int r, int c){

        int m = grid.length ;
        int n = grid[0].length ;

        if(r < 0 || r>=m || c<0 || c>=n || grid[r][c] == 'S' || grid[r][c] == 'X'){
            return;
        }

        if(grid[r][c] == 'O'){
            grid[r][c] = 'S';
            dfs(grid, r + 1, c);
            dfs(grid, r - 1, c);
            dfs(grid, r, c + 1);
            dfs(grid, r, c - 1);
        }

        return ;
    }

    public static void main(String[] args) {
        SurroundedRegions_Q130 solution = new SurroundedRegions_Q130();

        // Test case 1
        char[][] board1 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solution.solve(board1);
        printBoard(board1);

        // Test case 2
        char[][] board2 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'}
        };
        solution.solve(board2);
        printBoard(board2);

        // Add more test cases as needed
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
