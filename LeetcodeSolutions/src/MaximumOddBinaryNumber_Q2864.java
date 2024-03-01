public class MaximumOddBinaryNumber_Q2864 {
    public String maximumOddBinaryNumber(String s) {
        int countZ = 0;
        int countO = 0 ;

        for(int i = 0 ; i < s.length() ; i++){
            if (s.charAt(i) =='0'){
                countZ ++;
            }
            else{
                countO++ ;
            }
        }
        StringBuilder sb = new StringBuilder() ;
        if(countO > 1){
            for(int i = 0 ; i < countO - 1 ; i++){
                sb.append(1) ;
            }
        }
        for(int i = 0 ; i < countZ ; i++){
            sb.append(0);
        }
        sb.append(1) ;

        return sb.toString() ;
    }
    public static void main(String[] args) {
        MaximumOddBinaryNumber_Q2864 solution = new MaximumOddBinaryNumber_Q2864();

        // Test case 1: "1101" is the maximum odd binary number
        String s1 = "1011";
        System.out.println("Test Case 1: " + (solution.maximumOddBinaryNumber(s1).equals("1101") ? "Passed" : "Failed"));

        // Test case 2: "101" is already an odd binary number
        String s2 = "101";
        System.out.println("Test Case 2: " + (solution.maximumOddBinaryNumber(s2).equals("101") ? "Passed" : "Failed"));

        // Test case 3: "1001" is the maximum odd binary number
        String s3 = "0100";
        System.out.println("Test Case 3: " + (solution.maximumOddBinaryNumber(s3).equals("0001") ? "Passed" : "Failed"));
    }
}
