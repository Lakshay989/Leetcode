import java.util.Map;
import java.util.TreeMap;

public class TheNumberOfBeautifulSubsets_Q2597 {
    public int beautifulSubsets(int[] nums, int k) {
        int totalCount = 1;
        Map<Integer, Map<Integer, Integer>> freqMap = new TreeMap<>();

        // Calculate frequencies based on remainder
        for (int num : nums) {
            Map<Integer, Integer> fr = freqMap.getOrDefault(num % k, new TreeMap<>());
            fr.put(num, fr.getOrDefault(num, 0) + 1);
            freqMap.put(num % k, fr);
        }

        // Iterate through each remainder group
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : freqMap.entrySet()) {
            int prevNum = -k, prev2 = 0, prev1 = 1, curr = 1;

            // Iterate through each number in the current remainder group
            for (Map.Entry<Integer, Integer> freqEntry : entry.getValue().entrySet()) {
                int num = freqEntry.getKey();
                int freq = freqEntry.getValue();
                // Count of subsets skipping the current number
                int skip = prev1;

                // Count of subsets including the current number
                // Check if the current number and the previous number
                // form a beautiful pair
                int take;
                if (num - prevNum == k) {
                    take = ((1 << freq) - 1) * prev2;
                } else {
                    take = ((1 << freq) - 1) * prev1;
                }

                curr = skip + take; // Store the total count for the current number
                prev2 = prev1;
                prev1 = curr;
                prevNum = num;
            }
            totalCount *= curr;
        }
        return totalCount - 1;
    }
    public static void main(String[] args) {
        TheNumberOfBeautifulSubsets_Q2597 solution = new TheNumberOfBeautifulSubsets_Q2597();

        // Test cases
        int[] nums1 = {2, 4, 6, 8};
        int k1 = 2;
        System.out.println(solution.beautifulSubsets(nums1, k1)); // Expected output: 14

        int[] nums2 = {1, 2, 3, 4};
        int k2 = 1;
        System.out.println(solution.beautifulSubsets(nums2, k2)); // Expected output: 15

        int[] nums3 = {1, 1, 1, 1};
        int k3 = 2;
        System.out.println(solution.beautifulSubsets(nums3, k3)); // Expected output: 15

        int[] nums4 = {5, 10, 15};
        int k4 = 5;
        System.out.println(solution.beautifulSubsets(nums4, k4)); // Expected output: 7
    }
}
