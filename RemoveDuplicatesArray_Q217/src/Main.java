import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args)
    {

        int [] nums = {1,2,34,5,634,43,232,32,34,243,56};
        System.out.println();
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        // Arrays.sort(nums);
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i]==nums[i-1]){
        //         return true;
        //     }
        // }
        // return false;

        Set<Integer> set = new HashSet<>(nums.length) ;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(set.contains(nums[i]))
            {
                return true ;
            }
            set.add(nums[i]) ;
        }
        return false ;
    }
}