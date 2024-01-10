public class FindTheMaximumAchieveableNumber_Q2769 {
    public static int theMaximumAchievableX(int num, int t) {
        return num + 2*t ;
    }
    public static void main(String[] args) {
        FindTheMaximumAchieveableNumber_Q2769 solution = new FindTheMaximumAchieveableNumber_Q2769();

        // Test cases
        int num1 = 4, t1 = 1;
        System.out.println("Input: num = " + num1 + ", t = " + t1);
        System.out.println("Output: " + solution.theMaximumAchievableX(num1, t1)); // Output: 6

        int num2 = 3, t2 = 2;
        System.out.println("Input: num = " + num2 + ", t = " + t2);
        System.out.println("Output: " + solution.theMaximumAchievableX(num2, t2)); // Output: 7
    }
}
