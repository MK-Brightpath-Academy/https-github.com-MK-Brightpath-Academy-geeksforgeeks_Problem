
class Solution {
    public int minTime(int[] arr, int k) {
        long low = 0;
        long high = 0;

        for (int board : arr) {
            low = Math.max(low, board);
            high += board;
        }

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (canPaint(arr, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return (int) low;
    }

    private boolean canPaint(int[] arr, int k, long limit) {
        int painters = 1;
        long time = 0;

        for (int board : arr) {
            if (time + board > limit) {
                painters++;
                time = board;

                if (painters > k) {
                    return false;
                }
            } else {
                time += board;
            }
        }

        return true;
    }
}
