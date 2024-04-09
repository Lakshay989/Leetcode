import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens_Q51 {
    public List<List<String>> solveNQueens(int n) {
        //bounding condition is no same row, no same column and no diagnol so
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        backtrack(0, board, result);
        return result ;
    }

    void backtrack(int col, char[][] board, List < List < String >> result) {
        if(col == board.length){
            result.add(construct(board));
            return;
        }
        for(int row =0; row< board.length ; row ++){
            if(validate(board, row, col)){
                board[row][col] = 'Q' ;
                backtrack(col + 1, board, result);
                board[row][col] = '.' ;
            }
        }
    }

    static List < String > construct(char[][] board) {
        List < String > res = new LinkedList< String >();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }


    public static void main(String[] args) {
        NQueens_Q51 solution = new NQueens_Q51();

        // Test case 1
        int n1 = 4;
        List<List<String>> result1 = solution.solveNQueens(n1);
        System.out.println("Test case 1 result:");
        printResult(result1);

        // Test case 2
        int n2 = 1;
        List<List<String>> result2 = solution.solveNQueens(n2);
        System.out.println("Test case 2 result:");
        printResult(result2);

        // Test case 3
        int n3 = 8;
        List<List<String>> result3 = solution.solveNQueens(n3);
        System.out.println("Test case 3 result:");
        printResult(result3);
    }

    public static void printResult(List<List<String>> result) {
        for (List<String> list : result) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
        System.out.println("Number of solutions: " + result.size());
    }
}
