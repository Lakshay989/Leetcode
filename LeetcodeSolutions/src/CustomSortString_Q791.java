import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomSortString_Q791 {
    public String customSortString(String order, String s) {
        StringBuilder result = new StringBuilder() ;

        Map<Character, Integer> map = new LinkedHashMap<>();

        for(int i = 0 ; i < order.length() ; i++){
            map.put(order.charAt(i), i) ;
        }

        Map<Character, Integer> mapS = new HashMap<>() ;

        for(int i = 0 ; i < s.length() ; i++){
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(char key : map.keySet()){
            if(mapS.containsKey(key)){
                while(mapS.get(key) > 0){
                    result.append(key);
                    mapS.put(key, mapS.get(key) - 1) ;
                }
                mapS.remove(key) ;
            }
        }

        for(char key : mapS.keySet()){
            for(int i = 0 ; i < mapS.get(key) ; i++){
                result.append(key);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        CustomSortString_Q791 sorter = new CustomSortString_Q791();

        // Test case 1
        String order1 = "cba";
        String s1 = "abcd";
        String expected1 = "cbad";
        System.out.println(sorter.customSortString(order1, s1).equals(expected1)); // Output: true

        // Test case 2
        String order2 = "kqep";
        String s2 = "keep";
        String expected2 = "keep";
        System.out.println(sorter.customSortString(order2, s2).equals(expected2)); // Output: true

        // Test case 3
        String order3 = "zxyw";
        String s3 = "yxwz";
        String expected3 = "zxyw";
        System.out.println(sorter.customSortString(order3, s3).equals(expected3)); // Output: true

        // Test case 4
        String order4 = "abc";
        String s4 = "xzyacb";
        String expected4 = "abcxyz";
        System.out.println(sorter.customSortString(order4, s4).equals(expected4)); // Output: true

        // Test case 5
        String order5 = "abc";
        String s5 = "abc";
        String expected5 = "abc";
        System.out.println(sorter.customSortString(order5, s5).equals(expected5)); // Output: true
    }
}
