import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SearchSuggestionsSystem_Q1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        PriorityQueue<String> pq = new PriorityQueue<>(3, (s1, s2) -> s1.compareTo(s2));
        List<List<String>> list = new ArrayList<>();

        for(int i = 1; i<=searchWord.length(); i++){
            String temp = searchWord.substring(0, i);
            for(String s : products){
                if(s.startsWith(temp)){
                    pq.offer(s);
                }
            }
            List<String> temp_list = new ArrayList<>();
            for(int j = 0; j<3; j++){
                if(pq.peek() != null){
                    temp_list.add(pq.poll());
                }
            }
            pq.clear();
            list.add(temp_list);
        }
        return list;
    }

    public static void main(String[] args) {
        SearchSuggestionsSystem_Q1268 solution = new SearchSuggestionsSystem_Q1268();

        String[] products1 = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord1 = "mouse";

        String[] products2 = {"bags", "baggage", "banner", "box", "cloths"};
        String searchWord2 = "bags";

        String[] products3 = {"havana"};
        String searchWord3 = "havana";

        System.out.println(solution.suggestedProducts(products1, searchWord1));
        System.out.println(solution.suggestedProducts(products2, searchWord2));
        System.out.println(solution.suggestedProducts(products3, searchWord3));
    }
}
