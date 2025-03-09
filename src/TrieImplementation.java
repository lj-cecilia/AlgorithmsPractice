//time O(n)
//space O(n)

public class TrieImplementation {}
//trie is a tree data structure
//the insert, search, and startsWtih functions are all traversals in the trieNode

class Trie {
    class TrieNode {
        //boolean determines whether the chars to current node is a word
        boolean isWord;
        //represent the next children by setting one position of the array to a new TrieNode
        //char is represented by the index of the children
        TrieNode[] children = new TrieNode[26];
        //constructor
        public TrieNode() {}
    }
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            //if current node's children doesn't contain this char
            if (current.children[c - 'a'] == null) current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) return false;
            else current = current.children[c - 'a'];
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (current.children[c - 'a'] == null) return false;
            else current = current.children[c - 'a'];
        }
        return true;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */