public class NumberOfSubArraysThatMatchAPatternI_Q3034 {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int count, result = 0 ;
        for(int i = 0 ; i < nums.length - pattern.length ; i++){
            count = 0 ;
            for(int k = 0 ; k < pattern.length ; k++){
                if((nums[i + k + 1] > nums[i + k] && pattern[k] == 1) || (nums[i + k + 1] == nums[i + k] && pattern[k] == 0) || (nums[i + k + 1] < nums[i + k] && pattern[k] == -1)){
                    count++ ;
                }
            }
            if(count == pattern.length){
                result +=1 ;
            }
        }
        return result ;
//        StringBuilder pString = new StringBuilder() ;
//        int result = 0 ;
//        for(int i = 0 ; i < pattern.length ; i ++){
//            pString.append(pattern[i]);
//        }
//
//        String p = pString.toString() ;
//
//        int start = 0 ;
//        int end = pattern.length;
//
//        StringBuilder numString = new StringBuilder() ;
//
//        for (int i = start ; i < end ; i++){
//            if(nums[i + 1] > nums[i]){
//                numString.append(1);
//            }
//            else if(nums[i + 1] == nums[i]){
//                numString.append(0);
//            }
//            else{
//                numString.append(-1) ;
//            }
//        }
//
//        if(p.equals(numString.toString())){
//            result += 1 ;
//        }
//
//        while(end < nums.length - 1){
//            // start++;
//            if(numString.toString().charAt(0) == '-'){
//                numString.deleteCharAt(0);
//                numString.deleteCharAt(1);
//            }
//            else{
//                numString.deleteCharAt(0);
//            }
//            if(nums[end+1] > nums[end]){
//                numString.append(1);
//            }
//            else if(nums[end + 1] == nums[end]){
//                numString.append(0);
//            }
//            else{
//                numString.append(-1) ;
//            }
//            if(p.equals(numString.toString())){
//                result += 1 ;
//            }
//            end++ ;
//
//        }
//        return result ;
    }
    public static void main(String[] args) {
        NumberOfSubArraysThatMatchAPatternI_Q3034 solution = new NumberOfSubArraysThatMatchAPatternI_Q3034();

        // Example 1
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] pattern1 = {1, 1};
        System.out.println("Example 1 Output: " + solution.countMatchingSubarrays(nums1, pattern1)); // Output: 4

        // Example 2
        int[] nums2 = {1, 4, 4, 1, 3, 5, 5, 3};
        int[] pattern2 = {1, 0, -1};
        System.out.println("Example 2 Output: " + solution.countMatchingSubarrays(nums2, pattern2)); // Output: 2
    }
}
