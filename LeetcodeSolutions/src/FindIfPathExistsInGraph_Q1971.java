class DisjointSetUnion{
    private int[] parent;
    private int N;

    public DisjointSetUnion(int n){
        this.N = n;
        this.parent = new int[this.N];
        for(int i = 0; i < this.N; i++){
            this.parent[i] = i;
        }
    }

    public boolean areConnected(int u, int v){
        return find(u) == find(v);
    }

    public void union(int u, int v){
        if(u != v){
            int a = find(u);
            int b = find(v);
            parent[a] = b;
        }
    }

    private int find(int u){
        int x = u;
        while(x != this.parent[x]){
            x = this.parent[x];
        }

        this.parent[u] = x;
        return x;
    }
}
public class FindIfPathExistsInGraph_Q1971 {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        DisjointSetUnion set = new DisjointSetUnion(n);
        for(int[] edge : edges){
            set.union(edge[0], edge[1]);
        }

        return set.areConnected(start, end);
    }
    public static void main(String[] args) {
        FindIfPathExistsInGraph_Q1971 solution = new FindIfPathExistsInGraph_Q1971();

        // Test cases
        int[][] edges1 = {{0,1},{0,2},{2,5},{3,4},{3,5}};
        System.out.println("Test Case 1: " + solution.validPath(6, edges1, 0, 5)); // Output: true

        int[][] edges2 = {{0,1},{0,2},{2,5},{3,4},{3,5}};
        System.out.println("Test Case 2: " + solution.validPath(6, edges2, 0, 4)); // Output: false

        int[][] edges3 = {{0,1},{1,2},{2,3},{3,4},{4,5}};
        System.out.println("Test Case 3: " + solution.validPath(6, edges3, 0, 5)); // Output: true
        }
    }
