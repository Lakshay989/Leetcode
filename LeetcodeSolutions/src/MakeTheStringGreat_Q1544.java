public class MakeTheStringGreat_Q1544 {
    public String makeGood(String s) {
        // Convert string to character array to make it mutable
        char[] arr = s.toCharArray();

        // Initialize 'end = 0' since the good string is empty.
        int end = 0;
        for (int cur = 0; cur < arr.length; ++cur) {
            // If arr[cur] makes a pair with the last character arr[end - 1] in good string,
            // remove arr[end - 1] by decrementing 'end' by 1.
            // Otherwise, add arr[cur] to the good string by overwriting arr[end] by arr[cur].
            if (end > 0 && Math.abs(arr[cur] - arr[end - 1]) == 32)
                end--;
            else {
                arr[end] = arr[cur];
                end++;
            }
        }

        // Once the iteration ends, the string before 'end' is the good string.
        return new String(arr, 0, end);
    }
    public static void main(String[] args) {
        MakeTheStringGreat_Q1544 solution = new MakeTheStringGreat_Q1544();

        // Test case 1
        String s1 = "leEeetcode";
        String result1 = solution.makeGood(s1);
        System.out.println("Test case 1 result: " + result1); // Expected output: "leetcode"

        // Test case 2
        String s2 = "abBAcC";
        String result2 = solution.makeGood(s2);
        System.out.println("Test case 2 result: " + result2); // Expected output: ""

        // Test case 3
        String s3 = "s";
        String result3 = solution.makeGood(s3);
        System.out.println("Test case 3 result: " + result3); // Expected output: "s"
    }
}
