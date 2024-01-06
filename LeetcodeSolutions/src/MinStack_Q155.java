import java.util.ArrayList;
import java.util.List;

public class MinStack_Q155 {

        List<Integer> list = new ArrayList<>() ;
        List<Integer> min = new ArrayList<>() ;
        public MinStack_Q155() {
        }

        public void push(int val) {
            list.add(val) ;
            if(min.size() == 0){
                min.add(val);
            }
            else{
                min.add(Integer.min(min.getLast() ,val)) ;
            }
        }

        public void pop() {
            list.removeLast() ;
            min.removeLast() ;
        }

        public int top() {
            return list.getLast() ;
        }

        public int getMin() {
            return min.getLast() ;
        }

    public static void main(String[] args) {
        MinStack_Q155 minStack = new MinStack_Q155();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("Min value: " + minStack.getMin()); // Output: -3

        minStack.pop();

        System.out.println("Top value: " + minStack.top()); // Output: 0
        System.out.println("Min value: " + minStack.getMin()); // Output: -2
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

