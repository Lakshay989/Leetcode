public class IntegerToRoman_Q12 {
    private static final int[] values = {
            1000,
            900,
            500,
            400,
            100,
            90,
            50,
            40,
            10,
            9,
            5,
            4,
            1,
    };
    private static final String[] symbols = {
            "M",
            "CM",
            "D",
            "CD",
            "C",
            "XC",
            "L",
            "XL",
            "X",
            "IX",
            "V",
            "IV",
            "I",
    };

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num > 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman_Q12 converter = new IntegerToRoman_Q12();

        // Test cases
        System.out.println("Test 1: " + ("III".equals(converter.intToRoman(3)) ? "Passed" : "Failed")); // 3 -> "III"
        System.out.println("Test 2: " + ("IV".equals(converter.intToRoman(4)) ? "Passed" : "Failed")); // 4 -> "IV"
        System.out.println("Test 3: " + ("IX".equals(converter.intToRoman(9)) ? "Passed" : "Failed")); // 9 -> "IX"
        System.out.println("Test 4: " + ("LVIII".equals(converter.intToRoman(58)) ? "Passed" : "Failed")); // 58 -> "LVIII"
        System.out.println("Test 5: " + ("MCMXCIV".equals(converter.intToRoman(1994)) ? "Passed" : "Failed")); // 1994 -> "MCMXCIV"
        System.out.println("Test 6: " + ("MMMCMXCIX".equals(converter.intToRoman(3999)) ? "Passed" : "Failed")); // 3999 -> "MMMCMXCIX"
        System.out.println("Test 7: " + ("M".equals(converter.intToRoman(1000)) ? "Passed" : "Failed")); // 1000 -> "M"
        System.out.println("Test 8: " + ("D".equals(converter.intToRoman(500)) ? "Passed" : "Failed")); // 500 -> "D"
        System.out.println("Test 9: " + ("C".equals(converter.intToRoman(100)) ? "Passed" : "Failed")); // 100 -> "C"
        System.out.println("Test 10: " + ("XC".equals(converter.intToRoman(90)) ? "Passed" : "Failed")); // 90 -> "XC"
        System.out.println("Test 11: " + ("XL".equals(converter.intToRoman(40)) ? "Passed" : "Failed")); // 40 -> "XL"
        System.out.println("Test 12: " + ("I".equals(converter.intToRoman(1)) ? "Passed" : "Failed")); // 1 -> "I"
        System.out.println("Test 13: " + ("".equals(converter.intToRoman(0)) ? "Passed" : "Failed")); // 0 -> ""
    }
}
