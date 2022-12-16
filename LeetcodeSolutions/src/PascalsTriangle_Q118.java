import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_Q118
{
    public static void main(String args[])
    {
        int numRows = 7 ;

        List<List<Integer>> result = generate(numRows) ;

        for(int i = 0 ; i < result.size() ; i++ )
        {
            for (int j = 0 ; j < result.get(i).size() ; j ++)
            {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> output= new ArrayList<List<Integer>>();

        for(int i=0;i<numRows;i++)
        {

            List<Integer> currentList = new ArrayList<>();
            for(int j=0;j<i+1;j++)
            {
                if(j==0 || j== i)
                {
                    currentList.add(1);
                }

                else
                {
                    currentList.add(output.get(i-1).get(j-1)+output.get(i-1).get(j));
                }
            }
            output.add(currentList);
        }
        return output;

    }
}
