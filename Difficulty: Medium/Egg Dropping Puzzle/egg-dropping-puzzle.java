
class Solution {

    static int eggDrop(int n, int k) {

        // dp[i] = Maximum floors that can be
        // checked using i eggs

        int[] dp = new int[n + 1];

        int moves = 0;

        while (dp[n] < k) {

            moves++;

            // Reverse traversal is important
            for (int i = n; i >= 1; i--) {

                dp[i] = dp[i] + dp[i - 1] + 1;

                // No need to calculate beyond k
                if (dp[i] > k) {
                    dp[i] = k;
                }
            }
        }

        return moves;
    }
}
