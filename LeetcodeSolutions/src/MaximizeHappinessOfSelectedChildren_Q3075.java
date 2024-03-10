import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren_Q3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        long total = 0 ;
        int count = 0 ;
        Arrays.sort(happiness);
        int index = happiness.length - 1 ;
        while(k > 0){
            if(happiness[index] - count > 0){
                total+= happiness[index] - count;
            }
            else{
                total+=0 ;
            }
            count ++;
            index--;
            k--;
        }
        return total ;
    }
}
