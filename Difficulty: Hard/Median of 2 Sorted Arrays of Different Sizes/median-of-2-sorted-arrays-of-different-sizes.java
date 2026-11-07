class Solution {
    public double medianOf2(int a[], int b[]) {

        // Always apply binary search on smaller array
        if (a.length > b.length) {
            return medianOf2(b, a);
        }

        int n = a.length;
        int m = b.length;

        int low = 0;
        int high = n;

        while (low <= high) {

            int cut1 = low + (high - low) / 2;
            int cut2 = (n + m + 1) / 2 - cut1;

            int l1 = (cut1 == 0) ?
                     Integer.MIN_VALUE : a[cut1 - 1];

            int l2 = (cut2 == 0) ?
                     Integer.MIN_VALUE : b[cut2 - 1];

            int r1 = (cut1 == n) ?
                     Integer.MAX_VALUE : a[cut1];

            int r2 = (cut2 == m) ?
                     Integer.MAX_VALUE : b[cut2];

            if (l1 <= r2 && l2 <= r1) {

                if ((n + m) % 2 == 0) {
                    return (Math.max(l1, l2) +
                            (double) Math.min(r1, r2)) / 2.0;
                }

                return Math.max(l1, l2);

            } else if (l1 > r2) {

                high = cut1 - 1;

            } else {

                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}