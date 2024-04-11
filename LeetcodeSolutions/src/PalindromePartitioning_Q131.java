import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_Q131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>() ;
        List<String> path = new ArrayList<>();
        helper(0, path, result, s);
        return result ;
    }

    void helper(int index, List<String> path, List<List<String>> result, String s){
        if(index == s.length()){
            result.add(new ArrayList<String>(path));
            return;
        }

        for(int i = index ; i < s.length() ; i++){
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i+1));
                helper(i + 1, path, result, s);
                path.remove(path.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        PalindromePartitioning_Q131 solution = new PalindromePartitioning_Q131();

        // Test case 1
        String s1 = "aab";
        List<List<String>> result1 = solution.partition(s1);
        System.out.println("Test case 1 result: " + result1);
        // Expected output: [[a, a, b], [aa, b]]

        // Test case 2
        String s2 = "a";
        List<List<String>> result2 = solution.partition(s2);
        System.out.println("Test case 2 result: " + result2);
        // Expected output: [[a]]

        // Test case 3
        String s3 = "racecar";
        List<List<String>> result3 = solution.partition(s3);
        System.out.println("Test case 3 result: " + result3);
        // Expected output: [[r, a, c, e, c, a, r], [r, a, c, e, ca, r], [r, aceca, r], [racecar]]
    }
}
