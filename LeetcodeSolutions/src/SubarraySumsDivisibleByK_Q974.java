public class SubarraySumsDivisibleByK_Q974 {
        public int subarraysDivByK(int[] nums, int k) {
            int[] fre=new int[k];
            int sum=0;
            for(int i=0;i<nums.length;i++){
                sum+=((nums[i]%k)+k)%k;
                fre[sum%k]++;
            }
            int res=fre[0];
            for(int i:fre){
                res+=(i*(i-1))/2;
            }
            return res;
        }
        public static void main(String[] args) {
            SubarraySumsDivisibleByK_Q974 solution = new SubarraySumsDivisibleByK_Q974();

         // Test case
            int[] nums = {4, 5, 0, -2, -3, 1};
            int k = 5;
            System.out.println(solution.subarraysDivByK(nums, k)); // Expected: 7
        }
}
