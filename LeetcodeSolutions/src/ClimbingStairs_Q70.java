public class ClimbingStairs_Q70
{
    public static void main(String[] args)
    {
        int n = 8 ;
        System.out.println();
        System.out.println("The number of possible solutions is = " + climbStairs(n));
    }

    // You are climbing a staircase. It takes n steps to reach the top.
    //Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    public static int climbStairs(int n)
    {
        // Using the Fibonacci approach

        int first = 1 ;
        int second = 2 ;

        if(n==1)
        {
            return first ;
        }
        for(int i = 3 ; i<= n ; i++ )
        {
            int third = first + second ;
            first = second ;
            second = third ;
        }
        return second ;

    }
}
