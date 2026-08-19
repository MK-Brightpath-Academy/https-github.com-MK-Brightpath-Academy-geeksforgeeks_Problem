class Solution {
    public int maxCircularSum(int[] arr) {
        int totalSum = arr[0];

        int maxEnding = arr[0];
        int maxSum = arr[0];

        int minEnding = arr[0];
        int minSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            totalSum += arr[i];

            // Kadane for maximum subarray
            maxEnding = Math.max(arr[i], maxEnding + arr[i]);
            maxSum = Math.max(maxSum, maxEnding);

            // Kadane for minimum subarray
            minEnding = Math.min(arr[i], minEnding + arr[i]);
            minSum = Math.min(minSum, minEnding);
        }

        // All elements are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum circular subarray
        int circularSum = totalSum - minSum;

        return Math.max(maxSum, circularSum);
    }
}