public class FirstBadVersion_Q278
{
    // No API isBadVersion
    // Incomplete Solution here
    public static boolean isBadVersion(int n)
    {
        return false ;
    }

    public int firstBadVersion(int n)
    {
        int low = 1;
        int high = n ;

        while(low<=high)
        {
            int mid = low + (high-low)/2 ;
            boolean isbad = isBadVersion(mid);
            boolean isbad1 = isBadVersion(mid-1);
            if(isbad && !isbad1)
            {
                return mid ;
            }
            else if(!isbad)
            {
                low = mid +1 ;
            }
            else
            {
                high = mid - 1 ;
            }
        }
        return 0 ;

    }
}
