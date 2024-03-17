import java.util.Arrays;

public class MinimumDeletionsToMakeStringKSpecial_Q3085 {
    public int minimumDeletions(String word, int k) {
        // Step 1: Count the frequency of each character
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);
        reverse(freq);

        int minDeletions = Integer.MAX_VALUE;

        for (int i = 0; i < freq.length; i++) {
            int target = freq[i];
            int deletions = 0;

            for (int f : freq) {
                if (f > target + k) {
                    deletions += f - (target + k);
                } else if (f < target) {
                    deletions += f;
                }
            }
            minDeletions = Math.min(minDeletions, deletions);

            if (minDeletions == 0) break;
        }

        return minDeletions != Integer.MAX_VALUE ? minDeletions : 0;
    }

    private void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        MinimumDeletionsToMakeStringKSpecial_Q3085 solution = new MinimumDeletionsToMakeStringKSpecial_Q3085();

        // Test cases
        String word1 = "aabcaba";
        int k1 = 0;
        int result1 = solution.minimumDeletions(word1, k1);
        System.out.println("Test Case 1: " + result1); // Expected output: 3

        String word2 = "dabdcbdcdcd";
        int k2 = 2;
        int result2 = solution.minimumDeletions(word2, k2);
        System.out.println("Test Case 2: " + result2); // Expected output: 2

        String word3 = "aaabaaa";
        int k3 = 2;
        int result3 = solution.minimumDeletions(word3, k3);
        System.out.println("Test Case 3: " + result3); // Expected output: 1
    }
}
