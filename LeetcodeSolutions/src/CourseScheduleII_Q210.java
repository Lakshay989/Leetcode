import java.util.Arrays;

public class CourseScheduleII_Q210 {
    private int top;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        top = numCourses - 1;

        int[] postList = new int[numCourses];
        int[] nextIndex = new int[prerequisites.length];
        int[] nextNode = new int[prerequisites.length];

        for(int i = 0; i < numCourses; i++){
            postList[i] = -1;
        }

        int index = 0;
        for(int[] prerequisite : prerequisites) {
            nextIndex[index] = postList[prerequisite[1]];
            nextNode[index] = prerequisite[0];
            postList[prerequisite[1]] = index;
            index++;
        }

        int[] stack = new int[numCourses];
        int[] visited = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(0 == visited[i]){
                if(!DFS(i, visited, postList, nextIndex, nextNode, stack)) {
                    return new int[0];
                }
            }
        }
        return stack;
    }

    private boolean DFS(int numCourses, int[] visited, int[] postList, int[] nextIndex, int[] nextNode, int[] stack){
        visited[numCourses] = 1;
        for(int i = postList[numCourses]; i != -1; i = nextIndex[i]){
            if(1 == visited[nextNode[i]]) {
                return false;
            }
            if(0 == visited[nextNode[i]]){
                if(!DFS(nextNode[i], visited, postList, nextIndex, nextNode, stack)){
                    return false;
                }
            }
        }
        visited[numCourses] = 2;
        stack[top] = numCourses;
        top--;
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleII_Q210 solution = new CourseScheduleII_Q210();

        // Test case 1
        int numCourses1 = 4;
        int[][] prerequisites1 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] result1 = solution.findOrder(numCourses1, prerequisites1);
        System.out.println("Test Case 1 Result:");
        System.out.println(Arrays.toString(result1));
        // Expected output: [0, 2, 1, 3]

        // Test case 2
        int numCourses2 = 3;
        int[][] prerequisites2 = {{1, 0}, {0, 2}, {2, 1}};
        int[] result2 = solution.findOrder(numCourses2, prerequisites2);
        System.out.println("Test Case 2 Result:");
        System.out.println(Arrays.toString(result2));
        // Expected output: []

        // Add more test cases as needed
    }
}
