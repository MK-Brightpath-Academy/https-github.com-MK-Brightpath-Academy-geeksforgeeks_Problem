
class Solution {
    int totHammingDist(int arr[]) {
        int n = arr.length;
        int total = 0;

        for (int bit = 0; bit < 32; bit++) {
            int ones = 0;

            for (int num : arr) {
                if (((num >>> bit) & 1) == 1) {
                    ones++;
                }
            }

            total += ones * (n - ones);
        }

        return total;
    }
}
