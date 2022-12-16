public class BinarySearch_Q704
{
    public static void main(String args[])
    {
       int[] nums = {-1,0,3,5,9,12} ;
       int target = 9 ;
       System.out.println();
       System.out.println("The index of the target is = " + search(nums, target));
    }

    public static int search(int[] nums, int target)
    {
        int low = 0 ;
        int high = nums.length ;

        return BinarySearch(nums , low , high , target) ;

    }
    public static int BinarySearch (int[] nums, int low , int high, int target)
    {
        if(low == high)
        {
            return -1 ;
        }
        int mid = low + (high - low)/2 ;

        if(nums[mid] == target)
        {
            return mid ;
        }
        else if (target < nums[mid])
        {
            return BinarySearch(nums,low,mid, target) ;
        }
        else
        {
            return BinarySearch(nums,mid+1,high, target) ;
        }

    }
}
