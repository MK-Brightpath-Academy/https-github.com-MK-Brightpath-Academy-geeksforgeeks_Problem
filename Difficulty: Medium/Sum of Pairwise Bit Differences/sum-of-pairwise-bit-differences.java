class Solution {
    public int sumBitDifferences(int[] arr) {

        int n = arr.length;
        int result = 0;

        // Check all 32 bit positions
        for (int i = 0; i < 32; i++) {

            int countSetBits = 0;

            // Count numbers having current bit = 1
            for (int num : arr) {

                if ((num & (1 << i)) != 0) {
                    countSetBits++;
                }
            }

            int countUnsetBits = n - countSetBits;

            // Ordered pairs: (1,0) and (0,1)
            result += 2 * countSetBits * countUnsetBits;
        }

        return result;
    }
}