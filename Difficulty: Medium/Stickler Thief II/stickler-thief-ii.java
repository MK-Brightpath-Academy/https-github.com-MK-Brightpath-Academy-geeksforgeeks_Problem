class Solution {

    public int maxValue(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return arr[0];
        }

        // Case 1: Exclude last house
        int case1 = rob(arr, 0, n - 2);

        // Case 2: Exclude first house
        int case2 = rob(arr, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int rob(int[] arr, int start, int end) {

        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {

            int take = arr[i] + prev2;
            int skip = prev1;

            int current = Math.max(take, skip);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}