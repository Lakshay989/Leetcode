import java.util.*;

public class LeastNumberOfUniqueIntegersAfterKRemoval_Q1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Map to track the frequencies of elements
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // List to track all the frequencies
        List<Integer> frequencies = new ArrayList<>(map.values());

        // Sorting the frequencies
        Collections.sort(frequencies);

        // Tracking the number of elements removed
        int elementsRemoved = 0;

        for (int i = 0; i < frequencies.size(); i++) {
            // Removing frequencies[i] elements, which equates to
            // removing one unique element
            elementsRemoved += frequencies.get(i);

            // If the number of elements removed exceeds k, return
            // the remaining number of unique elements
            if (elementsRemoved > k) {
                return frequencies.size() - i;
            }
        }

        // We have removed all elements, so no unique integers remain
        // Return 0 in this case
        return 0;
    }
    public static void main(String[] args) {
        LeastNumberOfUniqueIntegersAfterKRemoval_Q1481 solution = new LeastNumberOfUniqueIntegersAfterKRemoval_Q1481();

        // Test Case 1
        int[] arr1 = {5, 5, 4};
        int k1 = 1;
        int expected1 = 1;
        int result1 = solution.findLeastNumOfUniqueInts(arr1, k1);
        System.out.println("Test Case 1 Result: " + (result1 == expected1 ? "Check" : "Error"));

        // Test Case 2
        int[] arr2 = {4, 3, 1, 1, 3, 3, 2};
        int k2 = 3;
        int expected2 = 2;
        int result2 = solution.findLeastNumOfUniqueInts(arr2, k2);
        System.out.println("Test Case 2 Result: " + (result2 == expected2 ? "Check" : "Error"));
    }
}
