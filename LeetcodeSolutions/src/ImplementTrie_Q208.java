class TrieNode {
    public TrieNode[] children;
    public boolean exists = false;
    public String val;

    public TrieNode() {
        this.children = new TrieNode[26];
    }

    public TrieNode(String val) {
        this.val = val;
    }

    public boolean isLeaf() {
        return this.val != null;
    }
}

public class ImplementTrie_Q208 {
     private TrieNode root;

    public ImplementTrie_Q208() {
        this.root = new TrieNode();
    }

    private int charAt(String s, int pos) {
        return (int)(s.charAt(pos)) - (int)('a');
    }

    public void insert(String word) {
        this._insert(word, this.root, 0);
    }

    private void _insert(String word, TrieNode root, int lo) {
        int pos = charAt(word, lo);
        TrieNode match = root.children[pos];
        if (match == null) {
            root.children[pos] = new TrieNode(word); return;
        }
        if (lo == word.length() - 1) {
            match.exists = true;
        } else {
            if (match.isLeaf()) {
                TrieNode newNode = new TrieNode();
                root.children[pos] = newNode;
                this._insert(match.val, root, lo);
                match = newNode;
            }
            this._insert(word, match, lo+1);
        }
    }

    public boolean search(String word) {
        return this._search(word, this.root, 0);
    }

    public boolean _search(String word, TrieNode root, int lo) {
        int pos = charAt(word, lo);
        TrieNode match = root.children[pos];
        if (match == null) {
            return false;
        }
        if (lo == word.length() - 1) {
            return match.exists || word.equals(match.val);
        }
        if (match.isLeaf()) {
            return word.equals(match.val);
        }
        return this._search(word, match, lo + 1);
    }

    public boolean startsWith(String prefix) {
        return this._startsWith(prefix, this.root, 0);
    }

    public boolean _startsWith(String word, TrieNode root, int lo) {
        int pos = charAt(word, lo);
        TrieNode match = root.children[pos];
        if (match == null) {
            return false;
        }
        if (match.isLeaf()) {
            return match.val.startsWith(word);
        }
        if (lo == word.length() - 1) {
            return true;
        }
        return this._startsWith(word, match, lo + 1);
    }

    public static void main(String[] args) {
        ImplementTrie_Q208 trie = new ImplementTrie_Q208();

        // Insert "apple" into the trie
        trie.insert("apple");

        // Test search
        System.out.println("Search for 'apple': " + trie.search("apple")); // Expected output: true
        System.out.println("Search for 'app': " + trie.search("app"));     // Expected output: false

        // Test startsWith
        System.out.println("Starts with 'app': " + trie.startsWith("app")); // Expected output: true

        // Insert "app" into the trie
        trie.insert("app");

        // Test search after inserting "app"
        System.out.println("Search for 'app' after inserting: " + trie.search("app")); // Expected output: true
    }
}
