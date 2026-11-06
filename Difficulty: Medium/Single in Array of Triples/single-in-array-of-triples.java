class Solution {
    public int getSingle(int[] arr) {

        int result = 0;

        // Check all 32 bits of integer
        for (int i = 0; i < 32; i++) {

            int count = 0;

            // Count set bits at position i
            for (int num : arr) {

                if ((num & (1 << i)) != 0) {
                    count++;
                }
            }

            // If frequency is not divisible by 3
            if (count % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }
}