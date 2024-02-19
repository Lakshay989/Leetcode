public class CountPrefixAndSuffixPairsI_Q3042 {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPrefixAndSuffix(String s1, String s2) {
        return s2.startsWith(s1) && s2.endsWith(s1);
    } // O(n^3)

    public static void main(String[] args) {
        CountPrefixAndSuffixPairsI_Q3042 solution = new CountPrefixAndSuffixPairsI_Q3042();

        // Example 1
        String[] words1 = {"a", "aba", "ababa", "aa"};
        System.out.println("Example 1: " + solution.countPrefixSuffixPairs(words1)); // Output: 4

        // Example 2
        String[] words2 = {"pa", "papa", "ma", "mama"};
        System.out.println("Example 2: " + solution.countPrefixSuffixPairs(words2)); // Output: 2

        // Example 3
        String[] words3 = {"abab", "ab"};
        System.out.println("Example 3: " + solution.countPrefixSuffixPairs(words3)); // Output: 0
    }
}
