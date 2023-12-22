public class LongestRepeatingCharacterReplacement_Q424 {
    public static int characterReplacement(String s, int k) {

        // This approach needs to find the max value in the Hashmap
        // HashMap<Character, Integer> hashMap = new HashMap<>() ;

        // check for empty string

        // int left = 0 ;
        // int maxLen = 0 ;
        // int len = 0 ;

        // for (int right = 0 ; right < s.length(); right++){
        //     char ch = s.charAt(right);
        //     if((right - left + 1) -  <= k){
        //         len = right - left + 1 ;
        //         if (len > maxLen){
        //             maxLen = len;
        //         }
        //         hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        //     }
        //     else{
        //         hashMap.put(ch, hashMap.get(ch) - 1);
        //         left+=1;
        //     }
        // }
        // return maxLen ;

        int[] arr = new int[26];
        int ans = 0;
        int max = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 'A']++;
            max = Math.max(max, arr[s.charAt(j) - 'A']);
            if (j - i + 1 - max > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

public static void main(String[] args) {
    // Test cases
    String s1 = "ABAB";
    int k1 = 2;
    System.out.println("Test Case 1: " + characterReplacement(s1, k1)); // Output: 4

    String s2 = "AABABBA";
    int k2 = 1;
    System.out.println("Test Case 2: " + characterReplacement(s2, k2)); // Output: 4

    String s3 = "AAAA";
    int k3 = 0;
    System.out.println("Test Case 3: " + characterReplacement(s3, k3)); // Output: 4

    String s4 = "ABCD";
    int k4 = 1;
    System.out.println("Test Case 4: " + characterReplacement(s4, k4)); // Output: 2
}
}
