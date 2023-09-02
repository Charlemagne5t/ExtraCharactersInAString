import java.util.*;


public class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int leftover = s.length();
        Integer[][][] memo = new Integer[s.length() + 1][s.length() + 1][s.length() + 1];
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        return dfs(s, set, 0, 1, leftover, memo);
    }

    private int dfs(String s, Set<String> set, int left, int right, int penalty, Integer[][][] memo) {

        if (right > s.length()) {
            return penalty;
        }
        if(memo[left][right][penalty] != null){
            return memo[left][right][penalty];
        }
        int result = Integer.MAX_VALUE;
        int take = Integer.MAX_VALUE;
        int expandRight= Integer.MAX_VALUE;
        int shrinkLeft = Integer.MAX_VALUE;
        if (set.contains(s.substring(left, right))){
            take = dfs(s, set, right, right + 1, penalty - (right - left), memo);
        }

        expandRight = dfs(s, set, left, right + 1, penalty, memo);
        if(right - left > 1){
            shrinkLeft = dfs(s, set, left + 1, right, penalty, memo);
        }

        result = Math.min(take, Math.min(expandRight, shrinkLeft));
        memo[left][right][penalty] = result;
        return result;

    }
}
