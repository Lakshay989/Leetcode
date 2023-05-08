public class RemDupSortedArray_II_Q80
{

    public static void main(String[] args)
    {
        int[] nums = {1,1,1,1,1,2,2,2,2,3,3,4,5,6,8,9,9} ;
        System.out.println();
        System.out.println(removeDuplicates(nums));

        for(int i = 0 ; i< nums.length ; i++)
        {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums)
    {
        // Solution inspired by StefanPochmann

        int count = 0;
        for (int n : nums)
            if (count < 2 || n > nums[count-2])
                nums[count++] = n;
        return count;
    }
}
