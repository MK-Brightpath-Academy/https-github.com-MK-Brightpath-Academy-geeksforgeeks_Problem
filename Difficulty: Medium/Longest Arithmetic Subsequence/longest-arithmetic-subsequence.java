class Solution {

    public int lengthOfLongestAP(Integer[] arr) {

        int n = arr.length;

        if (n <= 2) {
            return n;
        }

        // dp[i] = HashMap
        // key   = common difference
        // value = longest AP ending at index i
        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int ans = 2;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                int diff = arr[i] - arr[j];

                // If there is already an AP ending at j
                // with same difference, extend it.
                int length = dp[j].getOrDefault(diff, 1) + 1;

                // Store the best AP ending at i
                dp[i].put(
                    diff,
                    Math.max(
                        dp[i].getOrDefault(diff, 0),
                        length
                    )
                );

                ans = Math.max(ans, length);
            }
        }

        return ans;
    }
}