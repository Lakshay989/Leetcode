import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences_Q1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
    }
    public static void main(String[] args) {
        UniqueNumberOfOccurrences_Q1207 checker = new UniqueNumberOfOccurrences_Q1207();

        // Test case 1
        int[] arr1 = {1, 2, 2, 3, 3, 3};
        System.out.println("Test Case 1: " + checker.uniqueOccurrences(arr1)); // Expected output: true

        // Test case 2
        int[] arr2 = {1, 2, 2, 3, 3, 3, 4};
        System.out.println("Test Case 2: " + checker.uniqueOccurrences(arr2)); // Expected output: false

        // Test case 3
        int[] arr3 = {};
        System.out.println("Test Case 3: " + checker.uniqueOccurrences(arr3)); // Expected output: true

        // Test case 4
        int[] arr4 = {5};
        System.out.println("Test Case 4: " + checker.uniqueOccurrences(arr4)); // Expected output: true

        // Test case 5
        int[] arr5 = {0, 0, 0, 0};
        System.out.println("Test Case 5: " + checker.uniqueOccurrences(arr5)); // Expected output: false
    }
}
