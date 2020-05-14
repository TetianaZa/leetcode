package tree;
//Implement a trie with insert, search, and startsWith methods.
//
//Example:
//
//Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // returns true
//trie.search("app");     // returns false
//trie.startsWith("app"); // returns true
//trie.insert("app");
//trie.search("app");     // returns true
//Note:
//
//You may assume that all inputs are consist of lowercase letters a-z.
//All inputs are guaranteed to be non-empty strings.
public class ImplementPrefixTree {

    static class Trie {
        class TrieNode {

            static final int ALPHABET_SIZE = 26;

            TrieNode[] child = new TrieNode[ALPHABET_SIZE];
            boolean isEnd;
        }

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String str) {
            char[] data = str.toCharArray();
            TrieNode tempNode = root;

            for (char c : data) {
                int index = c - 'a';
                if (tempNode.child[index] == null) {
                    tempNode.child[index] = new TrieNode();
                }

                tempNode = tempNode.child[index];

            }
            tempNode.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String str) {
            char[] data = str.toCharArray();
            TrieNode tempNode = root;

            for (char c : data) {
                int index = c - 'a';
                if (tempNode.child[index] == null) {
                    return false;
                }
                tempNode = tempNode.child[index];
            }
            if (tempNode != null && tempNode.isEnd == false) {
                return false;
            }
            return true;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String str) {
            char[] data = str.toCharArray();
            TrieNode tempNode = root;

            for (char c : data) {
                int index = c - 'a';
                if (tempNode.child[index] == null) {
                    return false;
                }
                tempNode = tempNode.child[index];
            }
            return true;
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("apples");
        trie.search("app");     // returns true
    }
}
