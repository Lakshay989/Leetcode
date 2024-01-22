import java.util.Arrays;
import java.util.Collections;

// Same solution for Q3016 as well
class MinimumNumberOfPushesToTypeWord1I_Q3014{
    public int minimumPushes(String word) {

        int[] arr = new int[26] ;

        for(int i = 0 ; i < word.length() ; i++){
            arr[word.charAt(i) - 'a']++ ;
        }

        Integer[] boxedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArray, Collections.reverseOrder());

        int minPushes = 0 ;
        for(int i = 0 ; i < boxedArray.length ; i++){
            if(i < 8){
                minPushes += boxedArray[i] * 1 ;
            }
            else if (i >= 8 && i < 16){
                minPushes += boxedArray[i] *2 ;
            }
            else if( i>=16 && i< 24){
                minPushes += boxedArray[i] *3 ;
            }
            else{
                minPushes += boxedArray[i] * 4 ;
            }
        }
        return minPushes ;
    }
    public static void main(String[] args) {
        MinimumNumberOfPushesToTypeWord1I_Q3014 solution = new MinimumNumberOfPushesToTypeWord1I_Q3014();

        // Test Case 1
        String word1 = "hello";
        int result1 = solution.minimumPushes(word1);
        printTestResult("Test Case 1", result1, 5);

        // Test Case 2
        String word2 = "xycdefghij";
        int result2 = solution.minimumPushes(word2);
        printTestResult("Test Case 2", result2, 12);

        // Add more test cases as needed
    }

    private static void printTestResult(String testName, int actual, int expected) {
        System.out.println(testName + ": " + (actual == expected ? "Passed" : "Failed"));
        System.out.println("  Actual: " + actual);
        System.out.println("  Expected: " + expected);
        System.out.println();
    }
}