class Solution {
    public int[] singleNum(int[] arr) {
        int xor = 0;

        // XOR of all elements gives a ^ b
        for (int num : arr) {
            xor ^= num;
        }

        // Find rightmost set bit
        int setBit = xor & -xor;

        int num1 = 0;
        int num2 = 0;

        // Divide elements into two groups
        for (int num : arr) {
            if ((num & setBit) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        // Return in increasing order
        if (num1 < num2) {
            return new int[]{num1, num2};
        }

        return new int[]{num2, num1};
    }
}
