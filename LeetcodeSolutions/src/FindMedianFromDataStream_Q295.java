import java.util.PriorityQueue;

public class FindMedianFromDataStream_Q295 {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;


    public FindMedianFromDataStream_Q295() {
        min = new PriorityQueue();
        max = new PriorityQueue<>((a,b) -> (b - a));
    }

    public void addNum(int num) {

        if(max.size() == 0 || max.peek() >= num)
            max.add(num);
        else
            min.add(num);

        //rebalance
        if(max.size() > min.size() + 1) {
            min.add(max.poll());
        }

        if(min.size() > max.size()) {
            max.add(min.poll());
        }

    }

    public double findMedian() {

        int len = max.size() + min.size();
        if(len % 2 != 0)
            return (double)max.peek();
        else {
            return ((double)max.peek() + min.peek()) / 2;
        }

    }

    public static void main(String[] args) {
        FindMedianFromDataStream_Q295 medianFinder = new FindMedianFromDataStream_Q295();

        // Adding numbers
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);

        // Finding median
        double median1 = medianFinder.findMedian();
        System.out.println("Median after adding 1, 2, 3: " + median1); // Expected output: 2.0

        // Adding more numbers
        medianFinder.addNum(4);
        medianFinder.addNum(5);

        // Finding median
        double median2 = medianFinder.findMedian();
        System.out.println("Median after adding 4, 5: " + median2); // Expected output: 3.0
    }
}
