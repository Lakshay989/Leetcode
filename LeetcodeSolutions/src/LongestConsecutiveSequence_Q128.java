import java.util.HashSet;

public class LongestConsecutiveSequence_Q128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> table = new HashSet<>();

        for (int i = 0 ; i < nums.length ; i++){
            table.add(nums[i]);
        }
        int max = 0 ;
        for (int i = 0 ; i < nums.length ; i++){
            if(!table.contains(nums[i] - 1)){
                int temp = 1 ;
                int j = 1 ;
                while(table.contains(nums[i] + j)){
                    temp +=1 ;
                    j+=1 ;
                }
                max = Integer.max(max, temp);
            }
        }
        return max ;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence_Q128 sequence = new LongestConsecutiveSequence_Q128();

        // Test case 1: Basic test with consecutive sequence
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive sequence for nums1: " + sequence.longestConsecutive(nums1)); // Expected output: 4

        // Test case 2: Empty array
        int[] nums2 = {};
        System.out.println("Longest consecutive sequence for nums2: " + sequence.longestConsecutive(nums2)); // Expected output: 0

        // Test case 3: Array with all elements as the same number
        int[] nums3 = {5, 5, 5, 5, 5};
        System.out.println("Longest consecutive sequence for nums3: " + sequence.longestConsecutive(nums3)); // Expected output: 1

        // Test case 4: Array with negative numbers
        int[] nums4 = {-2, -3, -4, -1, 0, 1, 2, 3, 4};
        System.out.println("Longest consecutive sequence for nums4: " + sequence.longestConsecutive(nums4)); // Expected output: 9

        // Test case 5: Array with random elements
        int[] nums5 = {9, 1, 5, 7, 3, 2, 8, 4, 6};
        System.out.println("Longest consecutive sequence for nums5: " + sequence.longestConsecutive(nums5)); // Expected output: 9
    }
}
