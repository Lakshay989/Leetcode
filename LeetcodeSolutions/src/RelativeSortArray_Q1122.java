public class RelativeSortArray_Q1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt=new int[1001];
        for(int i:arr1){
            cnt[i]++;
        }
        int[] ans=new int[arr1.length];
        int i=0;
        for(int n:arr2){
            while(cnt[n]>0){
                ans[i]=n;
                cnt[n]--;
                i++;
            }
        }
        for(int j=0;j<cnt.length;j++){
            while(cnt[j]>0){
                ans[i]=j;
                cnt[j]--;
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RelativeSortArray_Q1122 solution = new RelativeSortArray_Q1122();

        // Test cases
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] result = solution.relativeSortArray(arr1, arr2);

        System.out.print("Sorted array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Expected output: 2 2 2 1 4 3 3 9 6 7 19
    }
}
