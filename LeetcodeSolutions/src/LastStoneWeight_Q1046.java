import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight_Q1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq  = new PriorityQueue<>(Comparator.reverseOrder());

        for(int stone: stones){
            pq.add(stone) ;
            //pq.offer(stone) ;
        }
        // int index = 0 ;
        int ele1 = 0 ;
        int ele2 = 0 ;

        while(pq.size() > 1){
            ele1 = pq.poll();
            ele2 = pq.poll() ;

            if(pq.size() == 0){
                return Math.abs(ele1 -ele2);
            }

            if(ele1 > ele2){
                pq.add(ele1 - ele2);
            }
            else if(ele2 > ele1){
                pq.add(ele2 - ele1);
            }
            else{
                continue ;
            }
        }
        return pq.poll() ;
    }
}
