public class AppendCharactersToStringToMakeSubsequence_Q2486 {
    public int appendCharacters(String s, String t) {
        if(s.equals(t))
            return 0;
        char chS[] = s.toCharArray();
        char chT[] = t.toCharArray();

        int i = 0, j = 0;
        int m = chS.length, n = chT.length;
        for(; i < m; i++)
        {
            if(chS[i] == chT[j])
                j++;

            if(j == n)
                return 0;
        }
        return n - j;
    }

    public static void main(String[] args) {
        AppendCharactersToStringToMakeSubsequence_Q2486 solution = new AppendCharactersToStringToMakeSubsequence_Q2486();

        // Test case 1: s is already t
        String s1 = "abcde";
        String t1 = "abcde";
        int expected1 = 0;
        System.out.println("Test Case 1 Passed: " + (solution.appendCharacters(s1, t1) == expected1));

        // Test case 2: t is a subsequence of s
        String s2 = "abcde";
        String t2 = "ace";
        int expected2 = 0;
        System.out.println("Test Case 2 Passed: " + (solution.appendCharacters(s2, t2) == expected2));

        // Test case 3: t is not a subsequence of s, needs appending characters
        String s3 = "abc";
        String t3 = "abcd";
        int expected3 = 1; // Need to append 'd'
        System.out.println("Test Case 3 Passed: " + (solution.appendCharacters(s3, t3) == expected3));

        // Test case 4: t is completely different from s
        String s4 = "abc";
        String t4 = "xyz";
        int expected4 = 3; // Need to append 'x', 'y', 'z'
        System.out.println("Test Case 4 Passed: " + (solution.appendCharacters(s4, t4) == expected4));

        // Test case 5: t is a subsequence but needs some characters
        String s5 = "ab";
        String t5 = "abc";
        int expected5 = 1; // Need to append 'c'
        System.out.println("Test Case 5 Passed: " + (solution.appendCharacters(s5, t5) == expected5));

        // Test case 6: t contains repeating characters
        String s6 = "abacaba";
        String t6 = "aaaa";
        int expected6 = 0;
        System.out.println("Test Case 6 Passed: " + (solution.appendCharacters(s6, t6) == expected6));
    }
}
