import java.util.PriorityQueue;

public class RelativeRanks_Q506 {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;
        String[] res = new String[n];

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a,b)->score[b]-score[a]);

        for(int i=0;i<n;i++){
            pq.add(i);
        }
        int i=1;
        while(!pq.isEmpty()){

            int idx = pq.poll();

            if(i>3){
                res[idx] = Integer.toString(i);
            }else if(i==1){
                res[idx] = "Gold Medal";
            }else if(i==2){
                res[idx] = "Silver Medal";
            }else if(i==3){
                res[idx] = "Bronze Medal";
            }
            i++;
        }

        return res;

    }

    public static void main(String[] args) {
        RelativeRanks_Q506 relativeRanks = new RelativeRanks_Q506();

        // Test case 1: Example input [5, 4, 3, 2, 1]
        int[] scores1 = {5, 4, 3, 2, 1};
        String[] result1 = relativeRanks.findRelativeRanks(scores1);
        printArray(result1); // Expected output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]

        // Test case 2: Input with duplicate scores
        int[] scores2 = {10, 15, 20, 15, 10};
        String[] result2 = relativeRanks.findRelativeRanks(scores2);
        printArray(result2); // Expected output: ["Bronze Medal", "Silver Medal", "Gold Medal", "Silver Medal", "Bronze Medal"]

        // Test case 3: Input with all scores equal
        int[] scores3 = {3, 3, 3, 3, 3};
        String[] result3 = relativeRanks.findRelativeRanks(scores3);
        printArray(result3); // Expected output: ["Gold Medal", "Gold Medal", "Gold Medal", "Gold Medal", "Gold Medal"]
    }

    // Helper method to print the array
    private static void printArray(String[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("\"" + arr[i] + "\"");
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
