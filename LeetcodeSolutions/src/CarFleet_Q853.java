import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CarFleet_Q853 {
    public int carFleet(int target, int[] position, int[] speed) {

        Map<Integer, Double> map = new TreeMap<>(Collections.reverseOrder());
        double curr = 0;
        int res = 0 ;
        for(int i = 0 ; i < position.length ; i++){
            map.put(position[i], (double) (target - position[i])/ speed[i]) ;
        }


        for(double time : map.values()){
            if(time > curr){
                curr = time ;
                res++;
            }
        }
        return res ;
    }

    public static void main(String[] args) {
        CarFleet_Q853 carFleetQ853 = new CarFleet_Q853();

        // Test case 1
        int target1 = 12;
        int[] position1 = {10, 8, 0, 5, 3};
        int[] speed1 = {2, 4, 1, 1, 3};
        int result1 = carFleetQ853.carFleet(target1, position1, speed1);
        System.out.println("Test Case 1: " + result1); // Change this to display the result

        // Test case 2
        int target2 = 20;
        int[] position2 = {5, 10, 15};
        int[] speed2 = {2, 3, 2};
        int result2 = carFleetQ853.carFleet(target2, position2, speed2);
        System.out.println("Test Case 2: " + result2); // Change this to display the result

        // Add more test cases as needed
    }
}
