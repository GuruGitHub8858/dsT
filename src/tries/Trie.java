package tries;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

public class Trie {
    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return true;
    }

    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode node, String word, int depth) {
        if (node == null) return false;

        if (depth == word.length()) {
            if (!node.isEndOfWord) return false;
            node.isEndOfWord = false;
            return isEmpty(node);
        }

        int index = word.charAt(depth) - 'a';
        boolean shouldDelete = delete(node.children[index], word, depth + 1);

        if (shouldDelete) {
            node.children[index] = null;
            return !node.isEndOfWord && isEmpty(node);
        }

        return false;
    }

    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children)
            if (child != null)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("cat");
        trie.insert("cap");
        trie.insert("can");

        System.out.println("Search 'cat': " + trie.search("cat"));
        System.out.println("Search 'cab': " + trie.search("cab"));
        System.out.println("Starts with 'ca': " + trie.startsWith("ca"));

        trie.delete("cap");
        System.out.println("After deleting 'cap', search 'cap': " + trie.search("cap"));
        System.out.println("Still starts with 'ca': " + trie.startsWith("ca"));
    }
}
