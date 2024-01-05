public class ContainerWithMostWater_Q11 {
    public int maxArea(int[] height) {
        int maxArea = 0 ;
        int area = 0 ;

        int left = 0 ;
        int right = height.length - 1 ;

        while (left < right){
            area = Integer.min(height[right], height[left]) * (right - left) ;

            if (area > maxArea){
                maxArea = area ;
            }

            if(height[right] >= height[left]){
                left ++ ;
            }
            else{
                right -- ;
            }
        }
        return maxArea ;
    }
    public static void main(String[] args) {
        ContainerWithMostWater_Q11 container = new ContainerWithMostWater_Q11();

        // Test Case 1: Standard scenario with increasing heights
        int[] heights1 = {1, 3, 4, 6, 2, 5};
        System.out.println("Max Area for heights1: " + container.maxArea(heights1)); // Expected output: 12

        // Test Case 2: Standard scenario with decreasing heights
        int[] heights2 = {7, 6, 4, 3, 1};
        System.out.println("Max Area for heights2: " + container.maxArea(heights2)); // Expected output: 9

        // Test Case 3: Empty array
        int[] heights3 = {};
        System.out.println("Max Area for heights3: " + container.maxArea(heights3)); // Expected output: 0

        // Test Case 4: Array with only one height
        int[] heights4 = {5};
        System.out.println("Max Area for heights4: " + container.maxArea(heights4)); // Expected output: 0

        // Test Case 5: Array with repeated heights
        int[] heights5 = {3, 3, 3, 3, 3};
        System.out.println("Max Area for heights5: " + container.maxArea(heights5)); // Expected output: 12
    }
}
