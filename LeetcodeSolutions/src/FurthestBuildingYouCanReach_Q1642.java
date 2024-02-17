import java.util.PriorityQueue;
import java.util.Queue;

public class FurthestBuildingYouCanReach_Q1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for(int i = 0 ; i <heights.length - 1 ; i++){
            int climb = heights[i + 1] - heights[i];
            if( climb > 0){
                minHeap.add(climb);
                if(minHeap.size() <= ladders){
                    continue ;
                }
                bricks -= minHeap.remove() ;
                if(bricks < 0){
                    return i ;
                }
            }
        }
        return heights.length - 1 ;
    }

    public static void main(String[] args) {
        FurthestBuildingYouCanReach_Q1642 solution = new FurthestBuildingYouCanReach_Q1642();

        // Test Case 1: Regular case with enough bricks and ladders to reach the end
        int[] heights1 = {4, 2, 7, 6, 9, 14, 12};
        int bricks1 = 5;
        int ladders1 = 1;
        int expected1 = 4; // Furthest building reachable is at index 4 (height 9)
        int result1 = solution.furthestBuilding(heights1, bricks1, ladders1);
        System.out.println("Test Case 1 Result: " + (result1 == expected1 ? "Check" : "Error"));

        // Test Case 2: Regular case with not enough bricks but enough ladders to reach the end
        int[] heights2 = {4, 12, 2, 7, 3, 18, 20, 3, 19};
        int bricks2 = 7;
        int ladders2 = 2;
        int expected2 = 7; // Furthest building reachable is at index 7 (height 20)
        int result2 = solution.furthestBuilding(heights2, bricks2, ladders2);
        System.out.println("Test Case 2 Result: " + (result2 == expected2 ? "Check" : "Error"));

        // Test Case 3: Regular case with not enough bricks or ladders to reach the end
        int[] heights3 = {14, 3, 19, 3};
        int bricks3 = 17;
        int ladders3 = 0;
        int expected3 = 3; // Furthest building reachable is at index 3 (height 3)
        int result3 = solution.furthestBuilding(heights3, bricks3, ladders3);
        System.out.println("Test Case 3 Result: " + (result3 == expected3 ? "Check" : "Error"));
    }
}
