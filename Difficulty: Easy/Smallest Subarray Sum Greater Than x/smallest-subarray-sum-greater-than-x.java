class Solution {

    public static int smallestSubWithSum(int x, int[] arr) {

        int n = arr.length;

        int left = 0;
        int sum = 0;
        int minLength = n + 1;

        for (int right = 0; right < n; right++) {

            // Expand window
            sum += arr[right];

            // Shrink window while sum > x
            while (sum > x && left <= right) {

                minLength = Math.min(
                    minLength,
                    right - left + 1
                );

                sum -= arr[left];
                left++;
            }
        }

        return minLength == n + 1 ? 0 : minLength;
    }
}