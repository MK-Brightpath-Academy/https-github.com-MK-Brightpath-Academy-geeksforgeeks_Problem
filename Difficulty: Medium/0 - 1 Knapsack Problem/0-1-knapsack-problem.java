class Solution {

    public int knapsack(int capacity, int[] val, int[] wt) {

        int[] dp = new int[capacity + 1];

        for (int i = 0; i < wt.length; i++) {

            for (int w = capacity; w >= wt[i]; w--) {

                dp[w] = Math.max(dp[w],
                                 val[i] + dp[w - wt[i]]);
            }
        }

        return dp[capacity];
    }
}