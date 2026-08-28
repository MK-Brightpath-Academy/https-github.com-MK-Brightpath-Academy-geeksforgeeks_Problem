class Solution {
    public int cuts(String s) {
        int n = s.length();

        // dp[i] = minimum number of parts needed for first i characters
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            // A valid binary number cannot start with 0
            if (dp[i] == Integer.MAX_VALUE || s.charAt(i) == '0') {
                continue;
            }

            long value = 0;

            for (int j = i; j < n; j++) {

                value = value * 2 + (s.charAt(j) - '0');

                if (isPowerOf5(value)) {
                    dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    private boolean isPowerOf5(long n) {
        if (n <= 0) {
            return false;
        }

        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1;
    }
}