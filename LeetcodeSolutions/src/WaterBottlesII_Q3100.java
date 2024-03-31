public class WaterBottlesII_Q3100 {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBottles = 0;
        int totalDrinks = 0;
        int fullBottles = numBottles;

        while (emptyBottles >= numExchange || fullBottles > 0) {
            if(fullBottles > 0){
                totalDrinks += fullBottles;
                emptyBottles += fullBottles;
                fullBottles = 0 ;
            }
            else{
                emptyBottles -= numExchange;
                fullBottles += 1;
                numExchange ++ ;
            }
        }
        return totalDrinks;
    }
    public static void main(String[] args) {
        WaterBottlesII_Q3100 solution = new WaterBottlesII_Q3100();

        // Test case 1
        int numBottles1 = 10;
        int numExchange1 = 3;
        int result1 = solution.maxBottlesDrunk(numBottles1, numExchange1);
        System.out.println("Test case 1 result: " + result1); // Expected output: 13

        // Test case 2
        int numBottles2 = 15;
        int numExchange2 = 4;
        int result2 = solution.maxBottlesDrunk(numBottles2, numExchange2);
        System.out.println("Test case 2 result: " + result2); // Expected output: 18

        // Test case 3
        int numBottles3 = 5;
        int numExchange3 = 5;
        int result3 = solution.maxBottlesDrunk(numBottles3, numExchange3);
        System.out.println("Test case 3 result: " + result3); // Expected output: 6
    }
}
