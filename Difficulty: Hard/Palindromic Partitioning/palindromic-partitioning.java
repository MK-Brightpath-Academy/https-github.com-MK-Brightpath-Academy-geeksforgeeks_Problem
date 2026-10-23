
class Solution {
    public int palPartition(String s) {
        int n = s.length();

        boolean[][] isPalindrome = new boolean[n][n];
        int[] dp = new int[n + 1];

        // dp[i] = minimum cuts needed for s[0...i-1]
        for (int i = 0; i <= n; i++) {
            dp[i] = i - 1;
        }

        for (int end = 0; end < n; end++) {
            for (int start = end; start >= 0; start--) {

                if (s.charAt(start) == s.charAt(end) &&
                    (end - start <= 2 ||
                     isPalindrome[start + 1][end - 1])) {

                    isPalindrome[start][end] = true;

                    dp[end + 1] = Math.min(
                        dp[end + 1],
                        dp[start] + 1
                    );
                }
            }
        }

        return dp[n];
    }
}
