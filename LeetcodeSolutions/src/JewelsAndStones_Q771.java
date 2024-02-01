import java.util.HashMap;

public class JewelsAndStones_Q771 {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> stonesMap = new HashMap<>() ;

        for(int i = 0 ; i < stones.length() ; i++){
            stonesMap.put(stones.charAt(i), stonesMap.getOrDefault(stones.charAt(i), 0) + 1);
        }

        int result = 0 ;

        for(int i = 0 ; i < jewels.length() ; i++){
            if(stonesMap.containsKey(jewels.charAt(i))){
                result += stonesMap.get(jewels.charAt(i)) ;
            }
        }
        return result ;
    }
    public static void main(String[] args) {
        JewelsAndStones_Q771 solution = new JewelsAndStones_Q771();

        // Test Case 1
        String jewels1 = "aA";
        String stones1 = "aAAbbbb";
        int result1 = solution.numJewelsInStones(jewels1, stones1);
        System.out.println("Test Case 1: " + (result1 == 3 ? "Passed" : "Failed"));

        // Test Case 2
        String jewels2 = "z";
        String stones2 = "ZZ";
        int result2 = solution.numJewelsInStones(jewels2, stones2);
        System.out.println("Test Case 2: " + (result2 == 0 ? "Passed" : "Failed"));

        // Test Case 3
        String jewels3 = "abc";
        String stones3 = "ABCabc";
        int result3 = solution.numJewelsInStones(jewels3, stones3);
        System.out.println("Test Case 3: " + (result3 == 3 ? "Passed" : "Failed"));

        // Additional Test Case 4
        String jewels4 = "";
        String stones4 = "abcd";
        int result4 = solution.numJewelsInStones(jewels4, stones4);
        System.out.println("Test Case 4: " + (result4 == 0 ? "Passed" : "Failed"));
    }
}
