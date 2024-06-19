import java.util.Arrays;

public class PutBoxesIntoTheWarehouseI_Q1564 {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {

        int i = boxes.length - 1;
        int count = 0;
        Arrays.sort(boxes);

        for (int room : warehouse) {
            // Iterate through boxes from largest to smallest
            // Discard boxes that doesn't fit in the current warehouse
            while (i >= 0 && boxes[i] > room) {
                i--;
            }

            if (i == -1) return count;
            count++;
            i--;
        }

        return count;
    }

    public static void main(String[] args) {
        PutBoxesIntoTheWarehouseI_Q1564 solution = new PutBoxesIntoTheWarehouseI_Q1564();

        // Test case 1
        int[] boxes1 = {4, 3, 4, 1};
        int[] warehouse1 = {5, 3, 3, 4, 1};
        System.out.println("Test case 1: " + (solution.maxBoxesInWarehouse(boxes1, warehouse1) == 3 ? "Passed" : "Failed"));

        // Test case 2
        int[] boxes2 = {1, 2, 3};
        int[] warehouse2 = {1, 2, 3, 4};
        System.out.println("Test case 2: " + (solution.maxBoxesInWarehouse(boxes2, warehouse2) == 1 ? "Passed" : "Failed"));

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
