
class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int[] flip = new int[n];
        int activeFlips = 0;
        int operations = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                activeFlips ^= flip[i - k];
            }

            int bit = arr[i] ^ activeFlips;

            if (bit == 0) {
                if (i + k > n) {
                    return -1;
                }

                activeFlips ^= 1;
                flip[i] = 1;
                operations++;
            }
        }

        return operations;
    }
}
