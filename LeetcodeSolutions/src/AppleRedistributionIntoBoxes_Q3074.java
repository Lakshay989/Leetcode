import java.util.Arrays;

public class AppleRedistributionIntoBoxes_Q3074 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0 ;
        for(int total : apple){
            sum+= total ;
        }
        Arrays.sort(capacity);
        int result = 0 ; int index = capacity.length -1 ;
        while(sum > 0){
            sum -= capacity[index];
            index-- ;
            result++ ;
        }
        return result ;
    }

    public static void main(String[] args) {
        AppleRedistributionIntoBoxes_Q3074 solution = new AppleRedistributionIntoBoxes_Q3074();

        // Test case 1
        int[] apple1 = {1, 3, 2};
        int[] capacity1 = {4, 3, 1, 5, 2};
        int result1 = solution.minimumBoxes(apple1, capacity1);
        System.out.println("Test Case 1: " + result1); // Expected output: 2

        // Test case 2
        int[] apple2 = {5, 5, 5};
        int[] capacity2 = {2, 4, 2, 7};
        int result2 = solution.minimumBoxes(apple2, capacity2);
        System.out.println("Test Case 2: " + result2); // Expected output: 4
    }
}
