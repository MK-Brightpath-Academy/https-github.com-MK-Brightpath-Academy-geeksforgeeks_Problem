class Solution {

    boolean isPatternPresent(String txt, String pat) {

        boolean start = pat.charAt(0) == '^';
        boolean end = pat.charAt(pat.length() - 1) == '$';

        int left = start ? 1 : 0;
        int right = end ? pat.length() - 1 : pat.length();

        String p = pat.substring(left, right);

        // ^pattern$
        if (start && end) {
            return startsWith(txt, p) && endsWith(txt, p);
        }

        // ^pattern
        if (start) {
            return startsWith(txt, p);
        }

        // pattern$
        if (end) {
            return endsWith(txt, p);
        }

        // pattern anywhere
        return contains(txt, p);
    }

    // Check pattern at beginning
    private boolean startsWith(String txt, String p) {

        if (p.length() > txt.length()) {
            return false;
        }

        for (int i = 0; i < p.length(); i++) {
            if (txt.charAt(i) != p.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    // Check pattern at ending
    private boolean endsWith(String txt, String p) {

        if (p.length() > txt.length()) {
            return false;
        }

        int start = txt.length() - p.length();

        for (int i = 0; i < p.length(); i++) {
            if (txt.charAt(start + i) != p.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    // KMP substring search
    private boolean contains(String txt, String p) {

        if (p.length() == 0) {
            return true;
        }

        if (p.length() > txt.length()) {
            return false;
        }

        int[] lps = buildLPS(p);

        int i = 0; // txt pointer
        int j = 0; // pattern pointer

        while (i < txt.length()) {

            if (txt.charAt(i) == p.charAt(j)) {
                i++;
                j++;

                if (j == p.length()) {
                    return true;
                }

            } else {

                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    // Longest Prefix Suffix array
    private int[] buildLPS(String p) {

        int[] lps = new int[p.length()];

        int len = 0;
        int i = 1;

        while (i < p.length()) {

            if (p.charAt(i) == p.charAt(len)) {
                len++;
                lps[i] = len;
                i++;

            } else {

                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}