class TrieNodeQ211{
    TrieNodeQ211[] map = new TrieNodeQ211[26];
    boolean endOfWord = false ;
    char val;
}
public class DesignAddAndSearchWordsDataStructure_Q211{
    private TrieNodeQ211 root ;
    public DesignAddAndSearchWordsDataStructure_Q211() {
        root = new TrieNodeQ211() ;

    }

    public void addWord(String word) {
        TrieNodeQ211 current = root ;
        for(int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            if(current.map[c - 'a'] == null)
            {
                current.map[c - 'a'] = new TrieNodeQ211() ;
            }
            current = current.map[c - 'a'] ;
        }
        current.endOfWord = true ;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNodeQ211 node) {
        if (index == word.length()) {
            return node.endOfWord;
        }

        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNodeQ211 child : node.map) {
                if (child != null && searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNodeQ211 nextNode = node.map[c - 'a'];
            return nextNode != null && searchHelper(word, index + 1, nextNode);
        }
    }
    public static void main(String[] args) {
        DesignAddAndSearchWordsDataStructure_Q211 wordDictionary = new DesignAddAndSearchWordsDataStructure_Q211();

        // Add words to the dictionary
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        // Test searches
        System.out.println("Search for 'pad': " + wordDictionary.search("pad")); // Expected: false
        System.out.println("Search for 'bad': " + wordDictionary.search("bad")); // Expected: true
        System.out.println("Search for '.ad': " + wordDictionary.search(".ad")); // Expected: true
        System.out.println("Search for 'b..': " + wordDictionary.search("b..")); // Expected: true
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
