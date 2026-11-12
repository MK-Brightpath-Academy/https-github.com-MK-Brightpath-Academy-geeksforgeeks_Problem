
import java.util.*;

class Solution {
    public boolean wordBreak(String s, String[] dictionary) {

        int n = s.length();

        // Store dictionary words for fast lookup
        Set<String> set = new HashSet<>();

        int maxLen = 0;

        for (String word : dictionary) {
            set.add(word);
            maxLen = Math.max(maxLen, word.length());
        }

        // dp[i] = Can first i characters be segmented?
        boolean[] dp = new boolean[n + 1];

        // Empty string is always possible
        dp[0] = true;

        for (int i = 1; i <= n; i++) {

            // Check possible last words
            for (int j = Math.max(0, i - maxLen); j < i; j++) {

                if (dp[j] && set.contains(s.substring(j, i))) {

                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
