class Solution {
    static char nonRepeatingChar(String s) {

        int[] freq = new int[256];

        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        for (char ch : s.toCharArray()) {
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '$';
    }
}