import java.util.ArrayList;
import java.util.List;

public class CourseSchedule_Q207 {
    public boolean dfs(int node, List<List<Integer>> adj, boolean[] visit, boolean[] inStack) {
        // If the node is already in the stack, we have a cycle.
        if (inStack[node]) {
            return true;
        }
        if (visit[node]) {
            return false;
        }
        // Mark the current node as visited and part of current recursion stack.
        visit[node] = true;
        inStack[node] = true;
        for (int neighbor : adj.get(node)) {
            if (dfs(neighbor, adj, visit, inStack)) {
                return true;
            }
        }
        // Remove the node from the stack.
        inStack[node] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] visit = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, adj, visit, inStack)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule_Q207 solution = new CourseSchedule_Q207();

        // Test case 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        boolean result1 = solution.canFinish(numCourses1, prerequisites1);
        System.out.println("Test case 1: " + result1); // Expected output: true

        // Test case 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        boolean result2 = solution.canFinish(numCourses2, prerequisites2);
        System.out.println("Test case 2: " + result2); // Expected output: false

        // Test case 3
        int numCourses3 = 4;
        int[][] prerequisites3 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        boolean result3 = solution.canFinish(numCourses3, prerequisites3);
        System.out.println("Test case 3: " + result3); // Expected output: true

        // Test case 4: No prerequisites
        int numCourses4 = 3;
        int[][] prerequisites4 = {};
        boolean result4 = solution.canFinish(numCourses4, prerequisites4);
        System.out.println("Test case 4: " + result4); // Expected output: true

        // Test case 5: Single course with a self-loop
        int numCourses5 = 1;
        int[][] prerequisites5 = {{0, 0}};
        boolean result5 = solution.canFinish(numCourses5, prerequisites5);
        System.out.println("Test case 5: " + result5); // Expected output: false

        // Test case 6: Multiple courses with a self-loop
        int numCourses6 = 3;
        int[][] prerequisites6 = {{0, 0}, {1, 1}, {2, 2}};
        boolean result6 = solution.canFinish(numCourses6, prerequisites6);
        System.out.println("Test case 6: " + result6); // Expected output: false

        // Add more test cases as needed
    }
}
