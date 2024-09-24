import java.util.*;


class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie();
        for(String str : dictionary) {
            trie.insert(str);
        }
        int res = 0;
        Integer[] memo = new Integer[s.length()];
        res = dfs(s, trie, 0, memo);

        return res;
    }
    int dfs(String s, Trie trie, int i, Integer[] memo) {
        if(i == s.length()) {
            return 0;
        }
        if(memo[i] != null) {
            return memo[i];
        }
        int res = Integer.MAX_VALUE;
        for(int j = i; j < s.length(); j++) {
            int k = trie.search(s.substring(i, j + 1));
            if(k == -1){
                res = Math.min(res,  1 + dfs(s, trie, i + 1, memo));
                break;
            }else if(k == 0) {
                res = Math.min(res, dfs(s, trie, j + 1, memo));
            }else {
                res = Math.min(res,1 + dfs(s, trie, i + 1, memo));

            }
        }
        memo[i] = res;
        return res;
    }
}

class Trie {
TrieNode root;

public Trie() {
    root = new TrieNode('0');
}

public void insert(String word) {
    int wordLength = word.length();
    TrieNode temp = root;
    for (int i = 0; i < wordLength; i++) {
        if(!temp.children.containsKey(word.charAt(i))){
            TrieNode node = new TrieNode(word.charAt(i));
            temp.children.put(word.charAt(i), node);
        }
        temp = temp.children.get(word.charAt(i));
        if(i == wordLength - 1){
            temp.isTerminal = true;
        }
    }

}

public int search(String word) {
    TrieNode temp = root;

    for (int i = 0; i < word.length(); i++) {
        if(temp.children.containsKey(word.charAt(i))){
            temp = temp.children.get(word.charAt(i));
        }else return -1;
    }
    return temp.isTerminal ? 0 : 1;
}

public boolean startsWith(String prefix) {
    TrieNode temp = root;
    for (int i = 0; i < prefix.length(); i++) {
        if(temp.children.containsKey(prefix.charAt(i))){
            temp = temp.children.get(prefix.charAt(i));
        }else return false;
    }
    return true;
}
}

class TrieNode{
    char value;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isTerminal;

    public TrieNode(char value) {
        this.value = value;
        this.isTerminal = false;
    }
}
