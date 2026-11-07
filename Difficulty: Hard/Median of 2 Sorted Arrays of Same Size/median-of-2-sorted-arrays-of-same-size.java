class Solution {
    public double medianOf2(int a[], int b[]) {

        int n = a.length;

        int low = 0;
        int high = n;

        while (low <= high) {

            int mid1 = low + (high - low) / 2;
            int mid2 = n - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1];

            int r1 = (mid1 == n) ? Integer.MAX_VALUE : a[mid1];
            int r2 = (mid2 == n) ? Integer.MAX_VALUE : b[mid2];

            if (l1 <= r2 && l2 <= r1) {

                return (Math.max(l1, l2) + (double) Math.min(r1, r2)) / 2.0;

            } else if (l1 > r2) {

                high = mid1 - 1;

            } else {

                low = mid1 + 1;
            }
        }

        return 0.0;
    }
}