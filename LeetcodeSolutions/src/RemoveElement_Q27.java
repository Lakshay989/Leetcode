public class RemoveElement_Q27
{
    public static void main(String[] args)
    {
        int[] nums = {1,1,1,1,1,2,2,2,2,3,3,4,5,6,8,9,9} ;
        System.out.println();
        System.out.println(removeElement(nums,9 ));
    }

    public static int removeElement(int[] nums, int val)
    {
        int count = 0;

        for(int i =0 ; i < nums.length ; i++)
        {
            if(nums[i] != val)
            {
                nums[count] = nums[i] ;
                count++ ;
            }
        }
        return count;
    }
}
