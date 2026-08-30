class Solution {

    public int bitonic(int[] arr) {

        int n = arr.length;

        if (n == 0)
            return 0;

        int maxLen = 1;

        int start = 0;
        int nextStart = 0;

        int i = 0;

        while (i < n - 1) {

            // 1. Non-decreasing part
            while (i < n - 1 && arr[i] <= arr[i + 1]) {
                i++;
            }

            // 2. Non-increasing part
            while (i < n - 1 && arr[i] >= arr[i + 1]) {

                // Remember where the decreasing
                // sequence started
                if (arr[i] > arr[i + 1]) {
                    nextStart = i + 1;
                }

                i++;
            }

            // Current bitonic length
            maxLen = Math.max(maxLen, i - start + 1);

            // Start next possible bitonic subarray
            start = nextStart;
        }

        return maxLen;
    }
}