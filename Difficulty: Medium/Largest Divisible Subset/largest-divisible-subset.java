class Solution {

    public ArrayList<Integer> largestSubset(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        int[] dp = new int[n];
        int[] next = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(next, -1);

        // DP from right to left
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i + 1; j < n; j++) {

                if (nums[j] % nums[i] == 0) {

                    // Better length
                    if (dp[j] + 1 > dp[i]) {

                        dp[i] = dp[j] + 1;
                        next[i] = j;

                    }
                    // Same length -> choose larger next element
                    else if (dp[j] + 1 == dp[i]
                            && (next[i] == -1
                            || nums[j] > nums[next[i]])) {

                        next[i] = j;
                    }
                }
            }
        }

        // Find maximum length
        int maxLength = 0;
        int start = -1;

        for (int i = 0; i < n; i++) {

            if (dp[i] > maxLength) {

                maxLength = dp[i];
                start = i;

            }
            // Same length -> lexicographically larger
            else if (dp[i] == maxLength
                    && start != -1
                    && nums[i] > nums[start]) {

                start = i;
            }
        }

        // Build result
        ArrayList<Integer> result = new ArrayList<>();

        while (start != -1) {

            result.add(nums[start]);
            start = next[start];
        }

        return result;
    }
}