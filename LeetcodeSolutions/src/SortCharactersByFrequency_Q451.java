import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SortCharactersByFrequency_Q451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map= new HashMap<>();
        StringBuilder result = new StringBuilder() ;
        for(int i = 0 ; i < s.length() ; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Character> characters = new ArrayList<>(map.keySet());
        Collections.sort(characters, (a, b) -> map.get(b) - map.get(a));

        for(char c : characters){
            int copies = map.get(c);
            for (int i = 0; i < copies; i++) {
                result.append(c);
            }
        }
        return result.toString() ;
    }

    public static void main(String[] args) {
        SortCharactersByFrequency_Q451 solution = new SortCharactersByFrequency_Q451();

        // Test Case 1
        String input1 = "tree";
        String output1 = solution.frequencySort(input1);
        System.out.println("Test Case 1: " + (output1.equals("eert") || output1.equals("eetr") ? "Passed" : "Failed"));

        // Test Case 2
        String input2 = "cccaaa";
        String output2 = solution.frequencySort(input2);
        System.out.println("Test Case 2: " + (output2.equals("cccaaa") || output2.equals("aaaccc") ? "Passed" : "Failed"));

        // Test Case 3
        String input3 = "Aabb";
        String output3 = solution.frequencySort(input3);
        System.out.println("Test Case 3: " + (output3.equals("bbAa") || output3.equals("aaBb") ? "Passed" : "Failed"));

        // Additional Test Case 4
        String input4 = "xyzxyz";
        String output4 = solution.frequencySort(input4);
        System.out.println("Test Case 4: " + (output4.equals("xxyyzz") || output4.equals("yyzzxx") || output4.equals("zzyyxx") ? "Passed" : "Failed"));    }
}
