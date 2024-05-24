public class MaximumScoreWordsFormedByLetters_Q1255 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int W = words.length;
        // Count how many times each letter occurs
        freq = new int[26];
        for (char c: letters) {
            freq[c - 'a']++;
        }
        maxScore = 0;
        check(W - 1, words, score, new int[26], 0);
        return maxScore;
    }

    // Check if adding this word exceeds the frequency of any letter
    private boolean isValidWord(int[] subsetLetters) {
        for (int c = 0; c < 26; c++) {
            if (freq[c] < subsetLetters[c]) {
                return false;
            }
        }
        return true;
    }

    private int maxScore;
    private int[] freq;

    private void check(int w, String[] words, int[] score, int[] subsetLetters, int totalScore) {
        if (w == -1) {
            // If all words have been iterated, check the score of this subset
            maxScore = Math.max(maxScore, totalScore);
            return;
        }
        // Not adding words[w] to the current subset
        check(w - 1, words, score, subsetLetters, totalScore);
        // Adding words[w] to the current subset
        int L = words[w].length();
        for (int i = 0; i < L; i++) {
            int c = words[w].charAt(i) - 'a';
            subsetLetters[c]++;
            totalScore += score[c];
        }

        if (isValidWord(subsetLetters)) {
            // Consider the next word if this subset is still valid
            check(w - 1, words, score, subsetLetters, totalScore);
        }
        // Rollback effects of this word
        for (int i = 0; i < L; i++) {
            int c = words[w].charAt(i) - 'a';
            subsetLetters[c]--;
            totalScore -= score[c];
        }
    }

    public static void main(String[] args) {
        MaximumScoreWordsFormedByLetters_Q1255 solution = new MaximumScoreWordsFormedByLetters_Q1255();

        // Test Case 1: Basic Case
        String[] words1 = {"dog", "cat", "dad", "good"};
        char[] letters1 = {'a', 'a', 'c', 'd', 'd', 'g', 'o', 'o'};
        int[] score1 = {1, 0, 9, 5, 6, 8, 1, 2, 4, 7, 8, 3, 9, 10, 5, 1, 0, 3, 6, 4, 3, 6, 8, 6, 9, 2};
        System.out.println("Test Case 1: " + solution.maxScoreWords(words1, letters1, score1)); // Expected Output: 16

        // Test Case 2: No Possible Words
        String[] words2 = {"dog", "cat", "dad", "good"};
        char[] letters2 = {'a', 'b', 'c'};
        int[] score2 = {1, 0, 9, 5, 6, 8, 1, 2, 4, 7, 8, 3, 9, 10, 5, 1, 0, 3, 6, 4, 3, 6, 8, 6, 9, 2};
        System.out.println("Test Case 2: " + solution.maxScoreWords(words2, letters2, score2)); // Expected Output: 0

        // Test Case 3: Single Letter Words
        String[] words3 = {"a", "b", "c", "d"};
        char[] letters3 = {'a', 'a', 'b', 'c', 'c', 'd', 'd'};
        int[] score3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        System.out.println("Test Case 3: " + solution.maxScoreWords(words3, letters3, score3)); // Expected Output: 10

        // Additional Test Case 4: More Complex Case
        String[] words4 = {"leetcode", "is", "cool"};
        char[] letters4 = {'l', 'e', 'e', 't', 'c', 'o', 'd', 'e', 'i', 's', 'c', 'o', 'o', 'l'};
        int[] score4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        System.out.println("Test Case 4: " + solution.maxScoreWords(words4, letters4, score4)); // Expected Output: 142

        // Additional Test Case 5: Another Basic Case
        String[] words5 = {"apple", "banana", "cherry"};
        char[] letters5 = {'a', 'p', 'p', 'l', 'e', 'b', 'a', 'n', 'a', 'n', 'a', 'c', 'h', 'e', 'r', 'r', 'y'};
        int[] score5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        System.out.println("Test Case 5: " + solution.maxScoreWords(words5, letters5, score5)); // Expected Output: 160
    }
}
