class Solution {
    public boolean areKAnagrams(String s1, String s2, int k) {

        // Step 1: Length check
        if (s1.length() != s2.length()) {
            return false;
        }

        // Step 2: Frequency array
        int[] freq = new int[26];

        // Step 3: Count characters of s1
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        // Step 4: Remove matching characters from s2
        for (int i = 0; i < s2.length(); i++) {
            freq[s2.charAt(i) - 'a']--;
        }

        // Step 5: Count extra characters
        int changes = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                changes += freq[i];
            }
        }

        // Step 6: Check whether changes <= k
        return changes <= k;
    }
}