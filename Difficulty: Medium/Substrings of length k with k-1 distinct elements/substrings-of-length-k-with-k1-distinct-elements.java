class Solution {

    public int substrCount(String s, int k) {

        int n = s.length();
        int count = 0;

        int[] freq = new int[26];
        int distinct = 0;

        // First window
        for (int i = 0; i < k; i++) {

            int index = s.charAt(i) - 'a';

            if (freq[index] == 0) {
                distinct++;
            }

            freq[index]++;
        }

        // Check first window
        if (distinct == k - 1) {
            count++;
        }

        // Sliding Window
        for (int i = k; i < n; i++) {

            // Remove left character
            int leftIndex = s.charAt(i - k) - 'a';

            freq[leftIndex]--;

            if (freq[leftIndex] == 0) {
                distinct--;
            }

            // Add right character
            int rightIndex = s.charAt(i) - 'a';

            if (freq[rightIndex] == 0) {
                distinct++;
            }

            freq[rightIndex]++;

            // Check current window
            if (distinct == k - 1) {
                count++;
            }
        }

        return count;
    }
}