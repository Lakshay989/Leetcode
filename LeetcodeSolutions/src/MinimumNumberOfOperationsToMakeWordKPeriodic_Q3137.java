import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeWordKPeriodic_Q3137 {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length();
        int operations = 0;

        String s = word.substring(0, k);
        if (isKPeriodic(word, s, k)) {
            return 0;
        }

        Map<String, Integer> substringCounts = new HashMap<>();
        for (int i = 0; i < n; i += k) {
            String substring = word.substring(i, i + k);
            substringCounts.put(substring, substringCounts.getOrDefault(substring, 0) + 1);
        }

        int maxFrequency = 0;
        String maxSubstring = "";
        for (Map.Entry<String, Integer> entry : substringCounts.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                maxSubstring = entry.getKey();
            }
        }

        for (int i = 0; i < n; i += k) {
            String substring = word.substring(i, i + k);
            if (!substring.equals(maxSubstring)) {
                operations++;
            }
        }

        return operations;
    }

    private boolean isKPeriodic(String word, String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length() / k; i++) {
            sb.append(s);
        }
        return sb.toString().equals(word);
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsToMakeWordKPeriodic_Q3137 solver = new MinimumNumberOfOperationsToMakeWordKPeriodic_Q3137();

        // Test case 1: Word is already k-periodic
        String word1 = "abcabcabc";
        int k1 = 3;
        System.out.println("Test case 1:");
        System.out.println("Minimum operations: " + solver.minimumOperationsToMakeKPeriodic(word1, k1));

        // Test case 2: Word is not k-periodic, minimum operations required
        String word2 = "abacabadabacabac";
        int k2 = 4;
        System.out.println("\nTest case 2:");
        System.out.println("Minimum operations: " + solver.minimumOperationsToMakeKPeriodic(word2, k2));

        // Test case 3: Word is not k-periodic, no operations required
        String word3 = "abcdabcdabcd";
        int k3 = 2;
        System.out.println("\nTest case 3:");
        System.out.println("Minimum operations: " + solver.minimumOperationsToMakeKPeriodic(word3, k3));

        // Test case 4: Word is single character
        String word4 = "abb";
        int k4 = 3;
        System.out.println("\nTest case 4:");
        System.out.println("Minimum operations: " + solver.minimumOperationsToMakeKPeriodic(word4, k4));
    }
}
