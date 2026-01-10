package Trie;
class Trie {

    // Trie Node
    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;

    // Constructor
    public Trie() {
        root = new TrieNode();
    }

    // 1️⃣ Insert a word
    public void insert(String word) {
        TrieNode curr = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    // 2️⃣ Search a word
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isEnd;
    }

    // 3️⃣ Check prefix
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    // Helper method
    private TrieNode findNode(String str) {
        TrieNode curr = root;

        for (char ch : str.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                return null;
            }
            curr = curr.children[idx];
        }
        return curr;
    }

    // 4️⃣ Delete a word
    public void delete(String word) {
        deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(TrieNode node, String word, int depth) {
        if (node == null) return false;

        // End of word
        if (depth == word.length()) {
            if (!node.isEnd) return false;
            node.isEnd = false;
            return isEmpty(node);
        }

        int idx = word.charAt(depth) - 'a';
        boolean shouldDeleteChild =
                deleteHelper(node.children[idx], word, depth + 1);

        if (shouldDeleteChild) {
            node.children[idx] = null;
            return !node.isEnd && isEmpty(node);
        }

        return false;
    }

    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) return false;
        }
        return true;
    }
}
