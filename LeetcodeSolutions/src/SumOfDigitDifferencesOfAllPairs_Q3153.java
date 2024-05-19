public class SumOfDigitDifferencesOfAllPairs_Q3153 {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        if (n == 2) {
            return digitDifference(nums[0], nums[1]);
        }

        String[] numStrings = new String[n];
        for (int i = 0; i < n; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }

        int numDigits = numStrings[0].length();

        long totalDifference = 0;

        for (int pos = 0; pos < numDigits; pos++) {
            int[] digitCounts = new int[10];

            for (String num : numStrings) {
                int digit = num.charAt(pos) - '0';
                digitCounts[digit]++;
            }

            for (int d = 0; d < 10; d++) {
                int count = digitCounts[d];
                totalDifference += (long) count * (n - count);
            }
        }

        return totalDifference / 2;
    }

    private int digitDifference(int num1, int num2) {
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);
        int differences = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                differences++;
            }
        }
        return differences;
    }

    public static void main(String[] args) {
        SumOfDigitDifferencesOfAllPairs_Q3153 sumCalculator = new SumOfDigitDifferencesOfAllPairs_Q3153();

        // Test case 1: Array with two elements
        int[] nums1 = {13, 23, 12};
        long expected1 = 4;
        long result1 = sumCalculator.sumDigitDifferences(nums1);
        System.out.println("Test case 1 passed: " + (expected1 == result1));

        // Test case 2: Array with three elements
        int[] nums2 = {111, 222, 333};
        long expected2 = 9; // Digit differences: (1-2) + (1-3) + (2-3) = 1 + 2 + 1 = 4
        long result2 = sumCalculator.sumDigitDifferences(nums2);
        System.out.println("Test case 2 passed: " + (expected2 == result2));

        // Test case 3: Array with four elements
        int[] nums3 = {10, 10, 10, 10};
        long expected3 = 0;
        long result3 = sumCalculator.sumDigitDifferences(nums3);
        System.out.println("Test case 3 passed: " + (expected3 == result3));
    }
}
