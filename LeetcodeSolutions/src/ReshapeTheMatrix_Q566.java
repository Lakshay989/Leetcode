import java.util.ArrayList;

public class ReshapeTheMatrix_Q566
{
    public static void main(String args[]) {

        int[][] mat = {{1, 2}, {3, 4}};
        int r = 1;
        int c = 4;
        int[][] result = new int[r][c];
        result = matrixReshape(mat, r, c);

        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                System.out.println(result[i][j]);
            }
        }
    }

    public  static int[][] matrixReshape(int[][] mat, int r, int c)
    {
        if(!(mat.length*mat[0].length == r*c))
        {
            return mat ;
        }

        int[][] result = new int[r][c] ;

        ArrayList<Integer> temp = new ArrayList<Integer>() ;

        for(int i =0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[0].length ; j++)
            {
                temp.add(mat[i][j]);
            }
        }

        int pos = 0 ;
        for(int i =0 ; i < r ; i++)
        {
            for (int j = 0 ; j < c ; j++ )
            {
                result[i][j] = temp.get(pos) ;
                pos++;
            }
        }
        return result ;

    }
}
