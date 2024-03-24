import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MostFrequentIDs_Q3092 {
    public long[] mostFrequentIDs(int[] arr, int[] freq) {
        int n = arr.length;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b)->(int)(b[1]-a[1]));
        HashMap<Long,Long> hp = new HashMap<>();

        long ans[] = new long[n];

        for(int i=0; i<n; i++){
            long x = arr[i];
            long c = freq[i];
            hp.put(x,hp.getOrDefault(x,(long)0)+c);
            pq.add(new long[]{x,hp.get(x)});
            long a[] = pq.remove();
            while(a[1]!=hp.get(a[0])){
                a = pq.remove();
            }
            ans[i] = a[1];
            pq.add(a);
        }
        return ans;
    }
    public static void main(String[] args) {
        MostFrequentIDs_Q3092 solution = new MostFrequentIDs_Q3092();

        // Test cases
        int[] arr1 = {1, 2, 3, 1, 2};
        int[] freq1 = {3, 2, 1, 4, 5};
        System.out.println("Most frequent IDs for arr1: " + Arrays.toString(solution.mostFrequentIDs(arr1, freq1)));

        int[] arr2 = {1, 1, 2, 2, 3};
        int[] freq2 = {5, 4, 3, 2, 1};
        System.out.println("Most frequent IDs for arr2: " + Arrays.toString(solution.mostFrequentIDs(arr2, freq2)));

        int[] arr3 = {3, 3, 3, 4, 4};
        int[] freq3 = {1, 2, 3, 4, 5};
        System.out.println("Most frequent IDs for arr3: " + Arrays.toString(solution.mostFrequentIDs(arr3, freq3)));
    }

}
