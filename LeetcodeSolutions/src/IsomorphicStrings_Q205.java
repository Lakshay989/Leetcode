import java.util.Arrays;

public class IsomorphicStrings_Q205 {
    public boolean isIsomorphic(String s, String t) {

        int[] mappingDictStoT = new int[256];
        Arrays.fill(mappingDictStoT, -1);

        int[] mappingDictTtoS = new int[256];
        Arrays.fill(mappingDictTtoS, -1);

        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Case 1: No mapping exists in either of the dictionaries
            if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                mappingDictStoT[c1] = c2;
                mappingDictTtoS[c2] = c1;
            }

            // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
            // it doesn't match in either of the dictionaries or both
            else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        IsomorphicStrings_Q205 solution = new IsomorphicStrings_Q205();

        // Test case 1
        String s1 = "egg";
        String t1 = "add";
        boolean result1 = solution.isIsomorphic(s1, t1);
        System.out.println("Test case 1 result: " + result1); // Expected output: true

        // Test case 2
        String s2 = "foo";
        String t2 = "bar";
        boolean result2 = solution.isIsomorphic(s2, t2);
        System.out.println("Test case 2 result: " + result2); // Expected output: false

        // Test case 3
        String s3 = "paper";
        String t3 = "title";
        boolean result3 = solution.isIsomorphic(s3, t3);
        System.out.println("Test case 3 result: " + result3); // Expected output: true
    }
}
