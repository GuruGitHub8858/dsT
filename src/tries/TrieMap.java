package tries;

import java.util.HashMap;
import java.util.Map;

class TrieMapNode {
    Map<Character, TrieMapNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

public class TrieMap {
    TrieMapNode root = new TrieMapNode();

    // Insert a word into the trie
    public void insert(String word) {
        TrieMapNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieMapNode());
            node = node.children.get(ch);
        }
        node.isEndOfWord = true;
    }

    // Search for a full word
    public boolean search(String word) {
        TrieMapNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch))
                return false;
            node = node.children.get(ch);
        }
        return node.isEndOfWord;
    }

    // Check if any word starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieMapNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.children.containsKey(ch))
                return false;
            node = node.children.get(ch);
        }
        return true;
    }

    // Delete a word from the trie
    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieMapNode node, String word, int depth) {
        if (node == null) return false;

        if (depth == word.length()) {
            if (!node.isEndOfWord) return false;
            node.isEndOfWord = false;
            return node.children.isEmpty(); // If no children, delete this node
        }

        char ch = word.charAt(depth);
        TrieMapNode child = node.children.get(ch);

        boolean shouldDelete = delete(child, word, depth + 1);

        if (shouldDelete) {
            node.children.remove(ch);
            return !node.isEndOfWord && node.children.isEmpty();
        }

        return false;
    }

    // Main method to test
    public static void main(String[] args) {
        TrieMap trie = new TrieMap();

        trie.insert("cat");
        trie.insert("cap");
        trie.insert("can");

        System.out.println("Search 'cat': " + trie.search("cat")); // true
        System.out.println("Search 'cab': " + trie.search("cab")); // false
        System.out.println("Starts with 'ca': " + trie.startsWith("ca")); // true

        trie.delete("cap");
        System.out.println("After deleting 'cap', search 'cap': " + trie.search("cap")); // false
        System.out.println("Still starts with 'ca': " + trie.startsWith("ca")); // true
    }
}
