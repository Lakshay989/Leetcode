import java.util.Arrays;

public class PutBoxesIntoTheWareHouseII_Q1580 {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int warehouseSize = warehouse.length;

        // Sort the boxes by height
        Arrays.sort(boxes);

        int leftIndex = 0;
        int rightIndex = warehouseSize - 1;
        int boxCount = 0;
        int boxIndex = boxes.length - 1;

        // Iterate through the boxes from largest to smallest
        while (leftIndex <= rightIndex && boxIndex >= 0) {
            // Check if the current box can fit in the leftmost available room
            if (boxes[boxIndex] <= warehouse[leftIndex]) {
                boxCount++;
                leftIndex++;
                // Check if the current box can fit in the rightmost available room
            } else if (boxes[boxIndex] <= warehouse[rightIndex]) {
                boxCount++;
                rightIndex--;
            }
            boxIndex--;
        }

        return boxCount;
    }
    public static void main(String[] args) {
        PutBoxesIntoTheWareHouseII_Q1580 solution = new PutBoxesIntoTheWareHouseII_Q1580();

        // Test case 1
        int[] boxes1 = {4, 3, 4, 1};
        int[] warehouse1 = {5, 4, 3, 3, 2};
        System.out.println("Test case 1: " + (solution.maxBoxesInWarehouse(boxes1, warehouse1) == 4 ? "Passed" : "Failed"));

        // Test case 2
        int[] boxes2 = {1, 2, 3};
        int[] warehouse2 = {1, 2, 3, 4};
        System.out.println("Test case 2: " + (solution.maxBoxesInWarehouse(boxes2, warehouse2) == 3 ? "Passed" : "Failed"));

        // Test case 3
        int[] boxes3 = {4, 5, 6};
        int[] warehouse3 = {3, 3, 3, 3};
        System.out.println("Test case 3: " + (solution.maxBoxesInWarehouse(boxes3, warehouse3) == 0 ? "Passed" : "Failed"));

        // Test case 4
        int[] boxes4 = {1, 2, 2, 3};
        int[] warehouse4 = {2, 2, 2, 2};
        System.out.println("Test case 4: " + (solution.maxBoxesInWarehouse(boxes4, warehouse4) == 3 ? "Passed" : "Failed"));

        // Test case 5
        int[] boxes5 = {1, 2, 3, 4, 5};
        int[] warehouse5 = {4, 3, 3, 2, 1};
        System.out.println("Test case 5: " + (solution.maxBoxesInWarehouse(boxes5, warehouse5) == 4 ? "Passed" : "Failed"));

        // Additional Test case 6: Edge case - empty boxes array
        int[] boxes6 = {};
        int[] warehouse6 = {1, 2, 3};
        System.out.println("Test case 6: " + (solution.maxBoxesInWarehouse(boxes6, warehouse6) == 0 ? "Passed" : "Failed"));

        // Additional Test case 7: Edge case - empty warehouse array
        int[] boxes7 = {1, 2, 3};
        int[] warehouse7 = {};
        System.out.println("Test case 7: " + (solution.maxBoxesInWarehouse(boxes7, warehouse7) == 0 ? "Passed" : "Failed"));

        // Additional Test case 8: Box fits in every room
        int[] boxes8 = {1, 1, 1, 1};
        int[] warehouse8 = {5, 5, 5, 5};
        System.out.println("Test case 8: " + (solution.maxBoxesInWarehouse(boxes8, warehouse8) == 4 ? "Passed" : "Failed"));

        // Additional Test case 9: Mixed sizes
        int[] boxes9 = {3, 5, 2, 1};
        int[] warehouse9 = {4, 4, 1, 2};
        System.out.println("Test case 9: " + (solution.maxBoxesInWarehouse(boxes9, warehouse9) == 3 ? "Passed" : "Failed"));

        // Additional Test case 10: All boxes larger than the smallest room
        int[] boxes10 = {4, 4, 4};
        int[] warehouse10 = {1, 2, 3};
        System.out.println("Test case 10: " + (solution.maxBoxesInWarehouse(boxes10, warehouse10) == 0 ? "Passed" : "Failed"));
    }
}
