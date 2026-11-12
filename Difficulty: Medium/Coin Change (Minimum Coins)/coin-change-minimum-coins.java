
class Solution {
    public int minCoins(int coins[], int sum) {

        int[] dp = new int[sum + 1];

        // Initially, assume every sum is impossible
        int INF = sum + 1;
        java.util.Arrays.fill(dp, INF);

        // 0 sum requires 0 coins
        dp[0] = 0;

        // Calculate minimum coins for every amount
        for (int i = 1; i <= sum; i++) {

            for (int coin : coins) {

                if (coin <= i && dp[i - coin] != INF) {

                    dp[i] = Math.min(
                        dp[i],
                        1 + dp[i - coin]
                    );
                }
            }
        }

        return dp[sum] == INF ? -1 : dp[sum];
    }
}
