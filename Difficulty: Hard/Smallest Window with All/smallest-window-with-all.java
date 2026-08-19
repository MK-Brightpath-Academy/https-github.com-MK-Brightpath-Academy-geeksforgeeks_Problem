class Solution {
    public static String minWindow(String s, String p) {
        if (s.length() < p.length()) {
            return "";
        }

        int[] freq = new int[256];

        for (char ch : p.toCharArray()) {
            freq[ch]++;
        }

        int required = p.length();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int start = -1;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (freq[ch] > 0) {
                required--;
            }

            freq[ch]--;

            while (required == 0) {
                int windowLength = right - left + 1;

                if (windowLength < minLength) {
                    minLength = windowLength;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar]++;

                if (freq[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        // No valid window
        if (start == -1) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}