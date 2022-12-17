import java.util.HashSet;

public class ValidSudoku_Q36
{
    public static void main(String[] args)
    {
        char[][] board =
                        {{'5','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}} ;

        char[][] board1 =
                        {{'8','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}} ;

        System.out.println();
        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku(board1));

    }
    public static boolean isValidSudoku(char[][] board)
    {
        HashSet<Character>[] rows = new HashSet[board.length] ;
        HashSet<Character>[] cols = new HashSet[board.length] ;
        HashSet<Character>[] boxes = new HashSet[board.length] ;

        for(int i = 0 ; i< board.length ; i++)
        {
            rows[i] = new HashSet<Character>() ;
            cols[i] = new HashSet<Character>() ;
            boxes[i] = new HashSet<Character>() ;
        }

        for(int i = 0 ; i< board.length ; i++)
        {
            for (int j = 0 ; j<board[0].length ; j++)
            {
                if(board[i][j] != ',' && board[i][j] != '.')
                {
                    if(rows[i].contains(board[i][j]))
                    {
                        return false ;
                    }
                    rows[i].add(board[i][j]) ;


                    if(cols[j].contains(board[i][j]))
                    {
                        return false ;
                    }
                    cols[j].add(board[i][j]) ;

                    int idx = (i / 3) * 3 + j / 3;
                    if (boxes[idx].contains(board[i][j]))
                    {
                        return false;
                    }
                    boxes[idx].add(board[i][j]);
                }
            }
        }
        return true ;

    }
}
