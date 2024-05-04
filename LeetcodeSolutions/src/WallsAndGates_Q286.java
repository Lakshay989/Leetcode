public class WallsAndGates_Q286 {
    private static int[] d = {0, 1, 0, -1, 0};

    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[0].length; j++)
                if (rooms[i][j] == 0) dfs(rooms, i, j);
    }

    public void dfs(int[][] rooms, int i, int j) {
        for (int k = 0; k < 4; ++k) {
            int p = i + d[k], q = j + d[k + 1];
            if (0<= p && p < rooms.length && 0<= q && q < rooms[0].length && rooms[p][q] > rooms[i][j] + 1) {
                rooms[p][q] = rooms[i][j] + 1;
                dfs(rooms, p, q);
            }
        }
    }

    public static void main(String[] args) {
        WallsAndGates_Q286 wallGate = new WallsAndGates_Q286();

        // Test case 1: Empty room
        int[][] rooms1 = {};
        System.out.println("Test case 1:");
        System.out.println("Original rooms:");
        printRooms(rooms1);
        wallGate.wallsAndGates(rooms1);
        System.out.println("Rooms after updating:");
        printRooms(rooms1);

        // Test case 2: Single room with gate
        int[][] rooms2 = {{Integer.MAX_VALUE}};
        System.out.println("\nTest case 2:");
        System.out.println("Original rooms:");
        printRooms(rooms2);
        wallGate.wallsAndGates(rooms2);
        System.out.println("Rooms after updating:");
        printRooms(rooms2);

        // Test case 3: Multiple rooms with gates and walls
        int[][] rooms3 = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        System.out.println("\nTest case 3:");
        System.out.println("Original rooms:");
        printRooms(rooms3);
        wallGate.wallsAndGates(rooms3);
        System.out.println("Rooms after updating:");
        printRooms(rooms3);
    }

    public static void printRooms(int[][] rooms) {
        for (int[] row : rooms) {
            for (int cell : row) {
                if (cell == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(cell + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
