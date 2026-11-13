
class Solution {

    String max;

    public String findMaximumNum(String s, int k) {

        max = s;

        solve(s.toCharArray(), k, 0);

        return max;
    }

    private void solve(char[] arr, int k, int index) {

        // Base condition
        if (k == 0 || index == arr.length) {
            return;
        }

        // Find maximum digit in remaining string
        char maxDigit = arr[index];

        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] > maxDigit) {
                maxDigit = arr[i];
            }
        }

        // If current digit is already maximum
        if (maxDigit == arr[index]) {
            solve(arr, k, index + 1);
            return;
        }

        // Try swapping with every occurrence
        // of maximum digit
        for (int i = arr.length - 1; i > index; i--) {

            if (arr[i] == maxDigit) {

                // Swap
                swap(arr, index, i);

                // Update maximum number
                String current = new String(arr);

                if (current.compareTo(max) > 0) {
                    max = current;
                }

                // Recursive call
                solve(arr, k - 1, index + 1);

                // Backtracking
                swap(arr, index, i);
            }
        }
    }

    private void swap(char[] arr, int i, int j) {

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
