class Solution {

    public int countRevPairs(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private int mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;

        int count = 0;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);

        count += countPairs(arr, low, mid, high);

        merge(arr, low, mid, high);

        return count;
    }

    private int countPairs(int[] arr, int low, int mid, int high) {

        int j = mid + 1;
        int count = 0;

        for (int i = low; i <= mid; i++) {

            while (j <= high &&
                   (long) arr[i] > 2L * arr[j]) {
                j++;
            }

            count += j - (mid + 1);
        }

        return count;
    }

    private void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }
}