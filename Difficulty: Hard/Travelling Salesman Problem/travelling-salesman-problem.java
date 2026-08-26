class Solution {

    int n;
    int[][] dp;

    int tsp(int[][] cost) {

        n = cost.length;

        dp = new int[n][1 << n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start from city 0
        return solve(0, 1, cost);
    }

    int solve(int current, int mask, int[][] cost) {

        // All cities visited
        if (mask == (1 << n) - 1) {
            return cost[current][0];
        }

        // Already calculated
        if (dp[current][mask] != -1) {
            return dp[current][mask];
        }

        int ans = Integer.MAX_VALUE;

        // Try every unvisited city
        for (int next = 0; next < n; next++) {

            // Check if next city is not visited
            if ((mask & (1 << next)) == 0) {

                int newMask = mask | (1 << next);

                int currentCost =
                        cost[current][next]
                        + solve(next, newMask, cost);

                ans = Math.min(ans, currentCost);
            }
        }

        return dp[current][mask] = ans;
    }
}