import java.util.HashMap;
import java.util.Map;

public class Trie {
    private Map<Character, TrieNode> root;
    public Trie() {
        this.root = new HashMap<>();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        Map<Character, TrieNode> currentNode = root;
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            TrieNode nextValue = currentNode.get(c);
            if (nextValue != null) {
                if (i == chars.length - 1 && !nextValue.isEnd()) {
                    nextValue.setEnd(true);
                }
            } else {
                TrieNode trieNode = new TrieNode();
                if (i == chars.length - 1) {
                    trieNode.setEnd(true);
                }
                currentNode.put(c, trieNode);
            }
            currentNode = currentNode.get(c).getNextValues();
        }
    }

    public boolean search(String word) {
        return this.search(word, false);
    }

    public boolean startsWith(String prefix) {
        return this.search(prefix, true);
    }

    private boolean search(String word, boolean isPrefix) {

        char[] chars = word.toCharArray();
        Map<Character, TrieNode> currentNode = root;
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            TrieNode nextValue = currentNode.get(c);
            if (nextValue == null) {
                return false;
            } else {
                if (!isPrefix && i == chars.length - 1 && !nextValue.isEnd()) {
                    return false;
                }
                currentNode = currentNode.get(c).getNextValues();
            }
        }

        return true;
    }
}

class TrieNode {
    private boolean isEnd;
    private Map<Character, TrieNode> nextValues;

    public TrieNode() {
        this.isEnd = false;
        this.nextValues = new HashMap<>();
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public Map<Character, TrieNode> getNextValues() {
        return nextValues;
    }
}