class Solution {

    static int findFloor(int[] arr, int x) {

        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= x) {
                ans = mid;
                left = mid + 1;   // Search for a later occurrence
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}