import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FindPlayersWithZeroOrOneLoss_Q2225 {
    public List<List<Integer>> findWinners(int[][] matches) {

        // Can use Collections.sort + HashMap for faster speed.
        TreeMap<Integer, Integer> winners = new TreeMap<>() ;
        TreeMap<Integer, Integer> losers = new TreeMap<>() ;

        List<List<Integer>> result = new ArrayList<>() ;

        for(int i = 0 ; i < matches.length ; i++){
            winners.put(matches[i][0], winners.getOrDefault(matches[i][0], 0) + 1);
            losers.put(matches[i][1], losers.getOrDefault(matches[i][1], 0) + 1);
        }

        List<Integer> wins = new ArrayList<>() ;
        List<Integer> losses = new ArrayList<>() ;
        for(int key : winners.keySet()){
            if(!losers.containsKey(key)){
                wins.add(key);
            }
        }

        for(int key : losers.keySet()){
            if(losers.get(key) == 1){
                losses.add(key);
            }
        }
        result.add(wins);
        result.add(losses) ;
        return result ;
    }

    public static void main(String[] args) {
        FindPlayersWithZeroOrOneLoss_Q2225 solution = new FindPlayersWithZeroOrOneLoss_Q2225();

        // Test 1
        int[][] matches1 = {{1, 2}, {3, 1}, {2, 4}, {5, 2}};
        List<List<Integer>> result1 = solution.findWinners(matches1);
        System.out.println("Test 1 Result: " + result1);

        // Test 2
        int[][] matches2 = {{1, 2}, {3, 1}, {2, 4}, {5, 2}, {6, 3}, {7, 4}};
        List<List<Integer>> result2 = solution.findWinners(matches2);
        System.out.println("Test 2 Result: " + result2);

        // Add more tests as needed

    }
}
