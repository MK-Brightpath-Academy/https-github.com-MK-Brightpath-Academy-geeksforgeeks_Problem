class Solution {
    public int missingNumber(int[] arr) {

        int n = arr.length;

        int i = 0;
        while (i < n) {

            int correct = arr[i] - 1;

            if (arr[i] > 0 &&
                arr[i] <= n &&
                arr[i] != arr[correct]) {

                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}