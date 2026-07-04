class Solution {

    static final int MOD = 1000000007;

    public int perfectSum(int arr[], int target) {

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int num : arr) {

            for (int sum = target; sum >= 0; sum--) {

                if (sum >= num) {
                    dp[sum] = (dp[sum] + dp[sum - num]) % MOD;
                }
            }
        }

        return dp[target];
    }
}