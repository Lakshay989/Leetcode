import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements_Q347 {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> table = new HashMap<>();

        for(int num : nums){
            table.put(num, table.getOrDefault(num, 0) + 1) ;
        }

        // Buckets

        List<Integer>[] buckets = new List[nums.length + 1];

        for(int i = 0 ; i < buckets.length ; i++){
            buckets[i] = new ArrayList<>();
        }

        // Adding to buckets according to freq
        for (Integer element : table.keySet()) {
            int frequency = table.get(element) ;
            buckets[frequency].add(element) ;
        }
        List<Integer> result = new ArrayList<>() ;

        for(int i = buckets.length - 1 ; i >=0 ; i --){
            for (int num : buckets[i]){
                result.add(num);
            }
        }
        int[] topK = new int[k] ;

        for(int i = 0 ; i < k ; i++){
            topK[i] = result.get(i) ;
        }
        return topK ;
    }

    public static void main(String[] args) {
        TopKFrequentElements_Q347 solution = new TopKFrequentElements_Q347();

        // Test Case 1: Basic scenario with unique elements
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = solution.topKFrequent(nums1, k1);
        System.out.println(Arrays.toString(result1)); // Expected output: [1, 2]

        // Test Case 2: All elements are the same
        int[] nums2 = {4, 4, 4, 4, 4, 4};
        int k2 = 1;
        int[] result2 = solution.topKFrequent(nums2, k2);
        System.out.println(Arrays.toString(result2)); // Expected output: [4]

        // Test Case 3: Empty input array
        int[] nums3 = {};
        int k3 = 0;
        int[] result3 = solution.topKFrequent(nums3, k3);
        System.out.println(Arrays.toString(result3)); // Expected output: []

        // Test Case 4: Larger input with more elements
        int[] nums4 = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 5};
        int k4 = 3;
        int[] result4 = solution.topKFrequent(nums4, k4);
        System.out.println(Arrays.toString(result4)); // Expected output: [3, 1, 5]

        // Test Case 5: All elements are unique
        int[] nums5 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int k5 = 3;
        int[] result5 = solution.topKFrequent(nums5, k5);
        System.out.println(Arrays.toString(result5)); // Expected output: [1, 2, 3]
    }

}
