public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        int[] nums = {1,1,1,1,1,2,2,2,2,3,3,4,5,6,8,9,9} ;
        System.out.println();
        System.out.println(removeDuplicates(nums));
    }
//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
//such that each unique element appears only once. The relative order of the elements should be kept the same.

    public static int removeDuplicates(int[] nums)
    {
        int insertPointer = 1 ;

        for(int i = 1 ; i < nums.length ; i++)
        {
            if(nums[i-1] != nums[i])
            {
                nums[insertPointer] = nums[i] ;
                insertPointer++ ;
            }
        }
        return insertPointer ;

    }

}