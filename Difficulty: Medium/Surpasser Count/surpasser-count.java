class Solution {

    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public ArrayList<Integer> findSurpasser(int[] arr) {

        int n = arr.length;

        Pair[] a = new Pair[n];

        for (int i = 0; i < n; i++) {
            a[i] = new Pair(arr[i], i);
        }

        int[] count = new int[n];

        mergeSort(a, 0, n - 1, count);

        ArrayList<Integer> ans = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            ans.add(count[i]);
        }

        return ans;
    }

    private void mergeSort(Pair[] a, int left, int right, int[] count) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(a, left, mid, count);
        mergeSort(a, mid + 1, right, count);

        merge(a, left, mid, right, count);
    }

    private void merge(Pair[] a,
                       int left,
                       int mid,
                       int right,
                       int[] count) {

        Pair[] temp = new Pair[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            if (a[i].value < a[j].value) {

                // All remaining elements in right half
                // are greater than a[i]
                count[a[i].index] += right - j + 1;

                temp[k++] = a[i++];

            } else {

                temp[k++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= right) {
            temp[k++] = a[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            a[left + x] = temp[x];
        }
    }
}