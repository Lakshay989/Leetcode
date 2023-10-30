public class Main {

    // 1.5 One Away - 3 types of edits  -- Add/ Remove / Replace

    public static boolean OneAway(char[] a, char[] b)
    {

        int diff = a.length - b.length ;

        if(diff > 1 || diff < -1)
        {
            return false ;
        }

        if(a.equals(b))
        {
            return true ;
        }

        // insert/remove can be same
        if(diff == 1){

            for( int  i = 0 ; i <a.length ; i++)
            {
                if 
            }
        }


    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}