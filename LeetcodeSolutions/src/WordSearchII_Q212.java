import java.util.ArrayList;
import java.util.List;

class TrieNodeQ212{
    TrieNodeQ212[] dict = new TrieNodeQ212[26] ;
    String word = null;

    public TrieNodeQ212(){};
}
public class WordSearchII_Q212 {
    char[][] _board = null ;
    List<String> _result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNodeQ212 root = new TrieNodeQ212() ;
        for(String word : words){
            TrieNodeQ212 curr = root ;
            for(int i = 0 ; i < word.length() ; i++){
                char c = word.charAt(i);
                if(curr.dict[c - 'a'] == null){
                    curr.dict[c - 'a'] = new TrieNodeQ212() ;
                }
                curr = curr.dict[c - 'a'] ;
            }
            curr.word = word ;
        }

        this._board = board ;
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if(root.dict[(board[row][col]) - 'a'] != null){
                    backtracking(row, col, root);
                }
            }
        }
        return this._result;
    }

    private void backtracking(int row, int col, TrieNodeQ212 parent) {
        Character letter = this._board[row][col];
        TrieNodeQ212 currNode = parent.dict[letter - 'a'];

        // check if there is any match
        if (currNode.word != null) {
            this._result.add(currNode.word);
            currNode.word = null;
        }

        // mark the current letter before the EXPLORATION
        this._board[row][col] = '#';

        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this._board.length || newCol < 0
                    || newCol >= this._board[0].length) {
                continue;
            }
            if ((this._board[newRow][newCol] != '#') && currNode.dict[this._board[newRow][newCol] - 'a'] != null){
                backtracking(newRow, newCol, currNode);
            }
        }

        // End of EXPLORATION, restore the original letter in the board.
        this._board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes
        boolean hasChildren = false;
        for (TrieNodeQ212 child : currNode.dict) {
            if (child != null) {
                hasChildren = true;
                break;
            }
        }
        if (!hasChildren && currNode.word == null) {
            parent.dict[letter - 'a'] = null;
        }
    }
    public static void main(String[] args) {
        WordSearchII_Q212 solution1 = new WordSearchII_Q212();
        WordSearchII_Q212 solution2 = new WordSearchII_Q212();
        WordSearchII_Q212 solution3 = new WordSearchII_Q212();


        // Test case 1
        char[][] board1 = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words1 = {"oath", "pea", "eat", "rain"};
        List<String> result1 = solution1.findWords(board1, words1);
        System.out.println("Test case 1 result: " + result1); // Expected output: ["oath", "eat"]

        // Test case 2
        char[][] board2 = {
                {'a', 'b'},
                {'c', 'd'}
        };
        String[] words2 = {"abcd", "dcba", "dcab", "abcb"};
        List<String> result2 = solution2.findWords(board2, words2);
        System.out.println("Test case 2 result: " + result2); // Expected output: ["abcd", "abcb"]

        // Test case 3
        char[][] board3 = {
                {'a', 'a'}
        };
        String[] words3 = {"a", "aa"};
        List<String> result3 = solution3.findWords(board3, words3);
        System.out.println("Test case 3 result: " + result3); // Expected output: ["a", "aa"]
    }
}

