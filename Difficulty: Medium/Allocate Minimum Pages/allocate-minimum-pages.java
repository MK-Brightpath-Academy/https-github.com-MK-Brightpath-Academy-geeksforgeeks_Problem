class Solution {

    public int findPages(int[] arr, int k) {

        int n = arr.length;

        if (k > n) {
            return -1;
        }

        long low = 0;
        long high = 0;

        // Calculate search space
        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        long ans = -1;

        // Binary Search
        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (isPossible(arr, k, mid)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return (int) ans;
    }

    private boolean isPossible(int[] arr, int k, long maxPages) {

        int students = 1;
        long pages = 0;

        for (int book : arr) {

            if (pages + book <= maxPages) {

                pages += book;

            } else {

                students++;
                pages = book;
            }

            if (students > k) {
                return false;
            }
        }

        return true;
    }
}