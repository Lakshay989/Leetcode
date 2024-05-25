import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder_Q127 {
    // class Pair{
//     String word ;
//     int level ;

//     Pair(String _first, int _second){
//         word = _first ;
//         level = _second ;
//     }
// }

// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> setOfWords = new HashSet<>() ;
//         for(int i = 0 ; i < wordList.size() ; i++){
//             setOfWords.add(wordList.get(i)) ;
//         }

//         Queue<Pair> q = new LinkedList<>() ;
//         q.add(new Pair(beginWord, 1));
//         setOfWords.remove(beginWord);

//         while(! q.isEmpty()){
//             String word = q.peek().word ;
//             int level = q.peek().level ;
//             q.poll() ;

//             if(word.equals(endWord) == true) return level ;

//             for(int i = 0 ; i < word.length() ; i++){
//                 for( char ch = 'a' ; ch <= 'z' ; ch ++){
//                     char[] replacedCharArray = word.toCharArray() ;
//                     replacedCharArray[i] = ch ;
//                     String newWord = new String(replacedCharArray) ;
//                     if(setOfWords.contains(newWord) == true ){
//                         setOfWords.remove(newWord);
//                         q.add(new Pair(newWord, level + 1));
//                     }
//                 }
//             }
//         }
//         return 0 ;
//     }
// }
     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return 0;
            }
            Set<String> beginSet = new HashSet<>();
            beginSet.add(beginWord);
            Set<String> endSet = new HashSet<>();
            endSet.add(endWord);
            Set<String> dict = new HashSet<>(wordList);
            int step = 1;
            Set<String> visit = new HashSet<>();
            while (beginSet.size() > 0) {
                if (beginSet.size() > endSet.size()) {
                    Set<String> temp = beginSet;
                    beginSet = endSet;
                    endSet = temp;
                }
                Set<String> nextBegin = new HashSet<>();
                for (String word : beginSet) {
                    visit.add(word);
                    int n = word.length();
                    char[] strArr = word.toCharArray();
                    for (int i = 0; i < n; i++) {
                        char old = strArr[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == old) {
                                continue;
                            }
                            strArr[i] = c;
                            String nextWord = String.valueOf(strArr);
                            if (endSet.contains(nextWord)) {
                                return step + 1;
                            }
                            if (!visit.contains(nextWord) && dict.contains(nextWord)) {
                                nextBegin.add(nextWord);
                            }
                        }
                        strArr[i] = old;
                    }
                }
                step++;
                beginSet = nextBegin;
            }
            return 0;
        }

    public static void main(String[] args) {
        WordLadder_Q127 solution = new WordLadder_Q127();

        // Test Case 1: Basic case with a possible transformation sequence
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = List.of("hot", "dot", "dog", "lot", "log", "cog");
        int result1 = solution.ladderLength(beginWord1, endWord1, wordList1);
        System.out.println("Test Case 1: " + result1); // Expected Output: 5

        // Test Case 2: No possible transformation sequence
        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = List.of("hot", "dot", "dog", "lot", "log");
        int result2 = solution.ladderLength(beginWord2, endWord2, wordList2);
        System.out.println("Test Case 2: " + result2); // Expected Output: 0

        // Test Case 3: Single step transformation
        String beginWord3 = "a";
        String endWord3 = "c";
        List<String> wordList3 = List.of("a", "b", "c");
        int result3 = solution.ladderLength(beginWord3, endWord3, wordList3);
        System.out.println("Test Case 3: " + result3); // Expected Output: 2

        // Test Case 4: Longer transformation sequence
        String beginWord4 = "hit";
        String endWord4 = "cog";
        List<String> wordList4 = List.of("hot", "dot", "tod", "hog", "hop", "cop", "cog");
        int result4 = solution.ladderLength(beginWord4, endWord4, wordList4);
        System.out.println("Test Case 4: " + result4); // Expected Output: 4

        // Test Case 5: Transformation with multiple intermediate steps
        String beginWord5 = "start";
        String endWord5 = "end";
        List<String> wordList5 = List.of("stark", "stack", "slack", "black", "blank", "bland", "brand", "bread", "break", "bream", "cream", "dream", "dread", "trend", "tread", "end");
        int result5 = solution.ladderLength(beginWord5, endWord5, wordList5);
        System.out.println("Test Case 5: " + result5); // Expected Output: 5
    }
    }
