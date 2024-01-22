import java.util.Arrays;
import java.util.Collections;

public class MinimumPushes_Q1233 {
    public static int minimumPushes(String word) {

        int[] arr = new int[26] ;

        for(int i = 0 ; i < word.length() ; i++){
            arr[word.charAt(i) - 'a']++ ;
        }

        Integer[] boxedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArray, Collections.reverseOrder());

        int minPushes = 0 ;
        for(int i = 0 ; i < boxedArray.length ; i++){
            if(i < 8){
                minPushes += arr[i] * 1 ;
            }
            else if (i >= 8 && i < 16){
                minPushes += arr[i] *2 ;
            }
            else if( i>=16 && i< 24){
                minPushes += arr[i] *3 ;
            }
            else{
                minPushes += arr[i] * 4 ;
            }
        }
        return minPushes ;
    }
    public static void main(String[] args) {
        String inputWord = "xycdefghij";
        int result = minimumPushes(inputWord);
        System.out.println("Result: " + result);
    }
}
