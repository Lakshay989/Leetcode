import java.util.Arrays;

public class ModifyTheMatrix_Q3033 {
    public int[][] modifiedMatrix(int[][] matrix) {
        int[] maxInColumns = new int[matrix[0].length];
        int[][] result = new int[matrix.length][matrix[0].length] ;
        for(int i = 0 ; i < matrix[0].length ; i++){
            int max  = -1 ;
            for(int j = 0 ; j < matrix.length ; j++){
                if(matrix[j][i] > max){
                    max = matrix[j][i];
                }
            }
            maxInColumns[i] = max ;
        }

        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0; j<matrix[0].length ; j++){
                if(matrix[i][j] == -1){
                    result[i][j] = maxInColumns[j];
                }
                else{
                    result[i][j] = matrix[i][j] ;
                }
            }
        }
        return result ;
    }

    public static void main(String[] args) {
        ModifyTheMatrix_Q3033 solution = new ModifyTheMatrix_Q3033();

        // Test Case 1
        int[][] matrix1 = {{1,2,-1}, {4,-1,6}, {7,8,9}};
        int[][] result1 = solution.modifiedMatrix(matrix1);
        System.out.println("Test Case 1 Result:");
        printMatrix(result1);

        // Test Case 2
        int[][] matrix2 = {{-1, 2, 3}, {4, -1, 6}, {7, 8, -1}};
        int[][] result2 = solution.modifiedMatrix(matrix2);
        System.out.println("Test Case 2 Result:");
        printMatrix(result2);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
