class Solution {

    public boolean canRearrange(String s) {

        int n = s.length();

        int[] freq = new int[26];

        // Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Find maximum frequency
        int maxFreq = 0;

        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Rearrangement is possible if
        // maximum frequency <= (n + 1) / 2
        return maxFreq <= (n + 1) / 2;
    }
}