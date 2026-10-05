class Solution {

    public int findMinPicks(int[] count, int k) {

        int colors = 0;
        int maxPairs = 0;

        // Count available colors and maximum possible pairs
        for (int c : count) {

            if (c > 0) {
                colors++;
            }

            maxPairs += c / 2;
        }

        // Impossible to make k pairs
        if (maxPairs < k) {
            return -1;
        }

        /*
         * Initially we can pick 1 sock from every
         * non-empty color without getting a pair.
         */
        int answer = colors;

        // We can have at most k-1 pairs before
        // the final pick guarantees the kth pair.
        int pairsBeforeLast = k - 1;

        /*
         * For a color:
         *
         * count = 3 -> 1,3
         *            increments: +2
         *
         * count = 4 -> 1,3,4
         *            increments: +2,+1
         *
         * count = 5 -> 1,3,5
         *            increments: +2,+2
         *
         * So first use all possible +2 increments,
         * then +1 increments.
         */

        int twoPickGroups = 0;
        int onePickGroups = 0;

        for (int c : count) {

            if (c >= 2) {

                // Number of +2 increments
                twoPickGroups += (c - 1) / 2;

                // Even count has one final +1 increment
                if (c % 2 == 0) {
                    onePickGroups++;
                }
            }
        }

        // Use +2 increments first
        int useTwo = Math.min(pairsBeforeLast, twoPickGroups);

        answer += useTwo * 2;
        pairsBeforeLast -= useTwo;

        // Then use +1 increments
        int useOne = Math.min(pairsBeforeLast, onePickGroups);

        answer += useOne;

        /*
         * One final sock guarantees the kth pair.
         */
        return answer + 1;
    }
}