import java.util.ArrayList;
import java.util.List;

public class FindBeautifulIndicesintheGivenArrayI_Q3006 {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {

        List<Integer> aIndex = new ArrayList<>() ;
        List<Integer> bIndex = new ArrayList<>() ;
        List<Integer> result = new ArrayList<>() ;

        for(int i = 0 ; i<= s.length() - a.length() ; i++){
            if(s.substring(i, (i + a.length())).equals(a)){
                aIndex.add(i);
            }
        }

        for(int i = 0 ; i<= s.length() - b.length() ; i++){
            if(s.substring(i, (i + b.length())).equals(b)){
                bIndex.add(i);
            }
        }

        for (int i : aIndex) {
            for (int j : bIndex) {
                if (Math.abs(i - j) <= k) {
                    result.add(i);
                    break; // Break to avoid adding the same 'a' index multiple times
                }
            }
        }

        // if (!aIndex.isEmpty() && !bIndex.isEmpty()) {
        //     int size = Integer.min(aIndex.size(), bIndex.size()) ;
        //     for(int i = 0 ; i < size ; i++){
        //         if( Math.abs(aIndex.get(i) - bIndex.get(i)) <= k ){
        //             result.add(aIndex.get(i));
        //         }
        //     }
        // }

        return result ;
    }

    public static void main(String[] args) {
        FindBeautifulIndicesintheGivenArrayI_Q3006 solution = new FindBeautifulIndicesintheGivenArrayI_Q3006();

        // Test 1
        String s1 = "abcbacab";
        String a1 = "a";
        String b1 = "b";
        int k1 = 2;
        List<Integer> result1 = solution.beautifulIndices(s1, a1, b1, k1);
        System.out.println("Test 1 Result: " + result1);

        // Test 2
        String s2 = "abcdeabcd";
        String a2 = "a";
        String b2 = "d";
        int k2 = 3;
        List<Integer> result2 = solution.beautifulIndices(s2, a2, b2, k2);
        System.out.println("Test 2 Result: " + result2);

        // Add more tests as needed

    }
}
