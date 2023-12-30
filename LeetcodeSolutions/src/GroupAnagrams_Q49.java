import java.util.*;

public class GroupAnagrams_Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        testGroupAnagrams();
    }

    public static void testGroupAnagrams() {
        GroupAnagrams_Q49 solution = new GroupAnagrams_Q49();

        // Test Case 1: Regular input with anagrams
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = solution.groupAnagrams(strs1);
        printResult(result1);

        // Test Case 2: Edge case with an empty array
        String[] strs2 = {};
        List<List<String>> result2 = solution.groupAnagrams(strs2);
        printResult(result2);

        // Test Case 3: Handling null input
        String[] strs3 = null;
        List<List<String>> result3 = solution.groupAnagrams(strs3);
        printResult(result3);
    }

    // Helper method to print the result
    private static void printResult(List<List<String>> result) {
        for (List<String> group : result) {
            System.out.println(group);
        }
        System.out.println("---------------");
    }
}
