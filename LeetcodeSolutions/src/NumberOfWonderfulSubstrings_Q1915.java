public class NumberOfWonderfulSubstrings_Q1915 {
    public long wonderfulSubstrings(String word) {

        long wonderful = 0;
        final int TOTAL = 1 << 10;
        long[] map = new long[TOTAL];
        map[0] = 1L;
        int value = 0;
        int length = word.length();

        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            value ^= (1 << index);
            map[value]++;
        }

        for (int i = 0; i < TOTAL; i++) {
            wonderful += map[i] * (map[i] - 1) / 2;
            for (int j = 1; j <= i; j <<= 1) {
                if ((i & j) == j)
                    wonderful += map[i] * map[i - j];
            }
        }
        return wonderful;
    }

    public static void main(String[] args) {
        NumberOfWonderfulSubstrings_Q1915 solver = new NumberOfWonderfulSubstrings_Q1915();

        // Test case 1: String with no repeated characters
        String word1 = "abc";
        long result1 = solver.wonderfulSubstrings(word1);
        System.out.println("Result for word1: " + result1); // Expected output: 3

        // Test case 2: String with repeated characters
        String word2 = "aab";
        long result2 = solver.wonderfulSubstrings(word2);
        System.out.println("Result for word2: " + result2); // Expected output: 5

        // Test case 3: String with all characters the same
        String word3 = "aaaaa";
        long result3 = solver.wonderfulSubstrings(word3);
        System.out.println("Result for word3: " + result3); // Expected output: 15
    }
}
