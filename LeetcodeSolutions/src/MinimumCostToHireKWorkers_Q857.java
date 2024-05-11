import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostToHireKWorkers_Q857 {
    class WorkerRatio{
        double ratio;
        int quality;
        public WorkerRatio(double r, int q){
            ratio = r;
            quality=q;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        WorkerRatio[] ratio = new WorkerRatio[n];
        for(int i=0 ; i< n ;++i) ratio[i] = new WorkerRatio((double)wage[i]/quality[i],quality[i]);
        Arrays.sort(ratio,(a, b)-> Double.compare(a.ratio,b.ratio));
        Queue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        int sum=0;
        for(int i=0; i<k ; ++i){
            pq.add(ratio[i].quality);
            sum+=ratio[i].quality;
        }
        double baseRatio = ratio[k-1].ratio;
        double ans = baseRatio*sum;
        for(int i=k ; i<n ; ++i){
            double newRatio = ratio[i].ratio;
            // get k smallest quality between 0,i
            int cur_equality = ratio[i].quality;
            if(pq.peek() > cur_equality){
                sum-=pq.poll();
                pq.add(cur_equality);
                sum+=cur_equality;
            }
            ans = Math.min(ans,newRatio*sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumCostToHireKWorkers_Q857 solution = new MinimumCostToHireKWorkers_Q857();

        // Test case 1
        int[] quality1 = {10, 20, 5};
        int[] wage1 = {70, 50, 30};
        int k1 = 2;
        double result1 = solution.mincostToHireWorkers(quality1, wage1, k1);
        System.out.println("Test Case 1 Result: " + result1); // Expected output: 105.0

        // Test case 2
        int[] quality2 = {3, 1, 10, 10, 1};
        int[] wage2 = {4, 8, 2, 2, 7};
        int k2 = 3;
        double result2 = solution.mincostToHireWorkers(quality2, wage2, k2);
        System.out.println("Test Case 2 Result: " + result2); // Expected output: 30.666666666666668

        // Add more test cases as needed
    }
}
