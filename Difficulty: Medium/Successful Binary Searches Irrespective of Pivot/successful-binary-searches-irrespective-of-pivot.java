
class Solution {
    public int countAlwaysFound(int[] arr) {
        int n = arr.length;
        int count = 0;

        int[] suffixMin = new int[n];

        suffixMin[n - 1] = arr[n - 1];

        // Step 1: Calculate suffix minimum
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(arr[i], suffixMin[i + 1]);
        }

        // Step 2: Check every element
        int leftMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            boolean leftValid = arr[i] > leftMax;

            boolean rightValid =
                (i == n - 1) || arr[i] < suffixMin[i + 1];

            if (leftValid && rightValid) {
                count++;
            }

            leftMax = Math.max(leftMax, arr[i]);
        }

        return count;
    }
}
