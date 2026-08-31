class Solution {
    public static boolean isRepeat(String s) {
        int n = s.length();

        // LPS array
        int[] lps = new int[n];

        for (int i = 1, len = 0; i < n; ) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i] = ++len;
                i++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        // Length of smallest repeating substring
        int len = n - lps[n - 1];

        // If entire string can be formed by repeating substring
        return len < n && n % len == 0;
    }
}