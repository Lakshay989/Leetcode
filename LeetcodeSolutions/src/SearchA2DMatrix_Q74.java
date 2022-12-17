public class SearchA2DMatrix_Q74
{
    public static void main(String[] args)
    {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}} ;
        int target = 3;
        int[][] matrix1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}} ;
        int target1 = 13 ;

        System.out.println();
        System.out.println(searchMatrix(matrix,target));
        System.out.println(searchMatrix(matrix1,target1));
    }
    // Try Later in O(log(mn))
    public static boolean searchMatrix(int[][] matrix, int target)
    {
        for(int i = 0 ; i <matrix.length ; i++)
        {
            if(target == matrix[i][matrix[0].length-1])
            {
                return true ;
            }
            else if (target < matrix[i][matrix[0].length-1])
            {
                int low = 0 ;
                int high = matrix[i].length ;

                return BinarySearch(matrix[i] , low , high , target) ;
            }
        }
        return false ;
    }
    public static boolean BinarySearch (int[] nums, int low , int high, int target)
    {
        if(low == high)
        {
            return false ;
        }
        int mid = low + (high - low)/2 ;

        if(nums[mid] == target)
        {
            return true ;
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
