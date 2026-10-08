class Solution {

    public int maximumGap(int[] start, int[] end) {

        int n = start.length;

        int[][] intervals = new int[n][2];

        // Create intervals
        for (int i = 0; i < n; i++) {
            intervals[i][0] = start[i];
            intervals[i][1] = end[i];
        }

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int maxGap = 0;
        int currentEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {

            int currentStart = intervals[i][0];

            // Gap exists
            if (currentStart > currentEnd) {
                maxGap = Math.max(
                    maxGap,
                    currentStart - currentEnd
                );
            }

            // Extend covered time
            currentEnd = Math.max(
                currentEnd,
                intervals[i][1]
            );
        }

        return maxGap;
    }
}