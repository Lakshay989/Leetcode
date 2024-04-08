public class NumberOfStudentsUnableToEatLunch_Q1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int circleStudentCount = 0;
        int squareStudentCount = 0;

        // Count the number of students who want each type of sandwich
        for (int student : students) {
            if (student == 0) {
                circleStudentCount++;
            } else {
                squareStudentCount++;
            }
        }

        // Serve sandwiches to students
        for (int sandwich : sandwiches) {
            // No student wants the circle sandwich on top of the stack
            if (sandwich == 0 && circleStudentCount == 0) {
                return squareStudentCount;
            }
            // No student wants the square sandwich on top of the stack
            if (sandwich == 1 && squareStudentCount == 0) {
                return circleStudentCount;
            }
            // Decrement the count of the served sandwich type
            if (sandwich == 0) {
                circleStudentCount--;
            } else {
                squareStudentCount--;
            }
        }
        // Every student received a sandwich
        return 0;
    }
    public static void main(String[] args) {
        NumberOfStudentsUnableToEatLunch_Q1700 solution = new NumberOfStudentsUnableToEatLunch_Q1700();

        // Test case 1
        int[] students1 = {1, 1, 0, 0};
        int[] sandwiches1 = {0, 1, 0, 1};
        int result1 = solution.countStudents(students1, sandwiches1);
        System.out.println("Test case 1 result: " + result1); // Expected output: 0

        // Test case 2
        int[] students2 = {1, 1, 1, 0, 0, 1};
        int[] sandwiches2 = {1, 1, 1, 0, 0, 0};
        int result2 = solution.countStudents(students2, sandwiches2);
        System.out.println("Test case 2 result: " + result2); // Expected output: 1

        // Test case 3
        int[] students3 = {1, 0, 0, 0, 1, 1};
        int[] sandwiches3 = {0, 1, 1, 1, 1, 0};
        int result3 = solution.countStudents(students3, sandwiches3);
        System.out.println("Test case 3 result: " + result3); // Expected output: 2

        // Test case 4
        int[] students4 = {0, 0, 0};
        int[] sandwiches4 = {1, 1, 1};
        int result4 = solution.countStudents(students4, sandwiches4);
        System.out.println("Test case 4 result: " + result4); // Expected output: 3
    }
}
