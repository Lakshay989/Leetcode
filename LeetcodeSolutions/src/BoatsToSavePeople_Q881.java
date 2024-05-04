import java.util.Arrays;

public class BoatsToSavePeople_Q881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }

        return ans;
    }
    public static void main(String[] args) {
        BoatsToSavePeople_Q881 boatRescuer = new BoatsToSavePeople_Q881();

        // Test case 1: Single person within the weight limit
        int[] people1 = {50};
        int limit1 = 100;
        System.out.println("Test case 1:");
        System.out.println("People: " + Arrays.toString(people1) + ", Limit: " + limit1);
        System.out.println("Number of rescue boats needed: " + boatRescuer.numRescueBoats(people1, limit1)); // Expected output: 1

        // Test case 2: Single person exceeding the weight limit
        int[] people2 = {100};
        int limit2 = 50;
        System.out.println("\nTest case 2:");
        System.out.println("People: " + Arrays.toString(people2) + ", Limit: " + limit2);
        System.out.println("Number of rescue boats needed: " + boatRescuer.numRescueBoats(people2, limit2)); // Expected output: 1

        // Test case 3: Multiple people requiring multiple boats
        int[] people3 = {20, 30, 50, 70, 80};
        int limit3 = 100;
        System.out.println("\nTest case 3:");
        System.out.println("People: " + Arrays.toString(people3) + ", Limit: " + limit3);
        System.out.println("Number of rescue boats needed: " + boatRescuer.numRescueBoats(people3, limit3)); // Expected output: 3

        // Test case 4: All people can fit in one boat
        int[] people4 = {10, 20, 30, 40, 50};
        int limit4 = 100;
        System.out.println("\nTest case 4:");
        System.out.println("People: " + Arrays.toString(people4) + ", Limit: " + limit4);
        System.out.println("Number of rescue boats needed: " + boatRescuer.numRescueBoats(people4, limit4)); // Expected output: 3
    }
}
