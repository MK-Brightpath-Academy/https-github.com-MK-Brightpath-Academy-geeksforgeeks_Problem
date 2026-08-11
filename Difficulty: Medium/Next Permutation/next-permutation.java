class Solution {
    public void nextPermutation(int[] arr) {

        int n = arr.length;

        // Step 1: Find the first decreasing element from right
        int i = n - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // Step 2: If such element exists
        if (i >= 0) {

            // Find the smallest element greater than arr[i]
            int j = n - 1;

            while (arr[j] <= arr[i]) {
                j--;
            }

            // Swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Step 3: Reverse the elements after i
        int left = i + 1;
        int right = n - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}