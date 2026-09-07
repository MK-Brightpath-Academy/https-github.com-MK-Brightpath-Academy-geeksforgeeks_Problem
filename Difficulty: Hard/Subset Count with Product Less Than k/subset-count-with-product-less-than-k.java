class Solution {

    public int numOfSubsets(int[] arr, int k) {

        int n = arr.length;

        // dp[j] = number of subsets with product <= j
        // Initially, empty subset is counted
        int[] dp = new int[k + 1];

        for (int j = 0; j <= k; j++) {
            dp[j] = 1;
        }

        for (int i = 0; i < n; i++) {

            int[] newDp = dp.clone();

            for (int j = 1; j <= k; j++) {

                // Include arr[i]
                if (arr[i] <= j) {
                    newDp[j] += dp[j / arr[i]];
                }
            }

            dp = newDp;
        }

        // Remove empty subset
        return dp[k] - 1;
    }
}