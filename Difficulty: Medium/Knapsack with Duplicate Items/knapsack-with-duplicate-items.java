
class Solution {
    public int knapSack(int val[], int wt[], int capacity) {

        int n = val.length;

        int[] dp = new int[capacity + 1];

        for (int i = 0; i <= capacity; i++) {

            for (int j = 0; j < n; j++) {

                if (wt[j] <= i) {

                    dp[i] = Math.max(
                        dp[i],
                        val[j] + dp[i - wt[j]]
                    );
                }
            }
        }

        return dp[capacity];
    }
}
