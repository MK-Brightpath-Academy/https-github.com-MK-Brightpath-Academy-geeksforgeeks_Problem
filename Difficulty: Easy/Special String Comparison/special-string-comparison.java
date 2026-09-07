class Solution {

    public int compareStrings(String s1, String s2) {

        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {

            int rank1;
            int rank2;

            // Token from s1
            if (i + 1 < s1.length()
                    && s1.charAt(i) == 'n'
                    && s1.charAt(i + 1) == 'g') {

                rank1 = 14;
                i += 2;

            } else {

                rank1 = getRank(s1.charAt(i));
                i++;
            }

            // Token from s2
            if (j + 1 < s2.length()
                    && s2.charAt(j) == 'n'
                    && s2.charAt(j + 1) == 'g') {

                rank2 = 14;
                j += 2;

            } else {

                rank2 = getRank(s2.charAt(j));
                j++;
            }

            // Compare
            if (rank1 < rank2) {
                return -1;
            }

            if (rank1 > rank2) {
                return 1;
            }
        }

        // If one string is prefix of another
        if (i < s1.length()) {
            return 1;
        }

        if (j < s2.length()) {
            return -1;
        }

        return 0;
    }

    private int getRank(char ch) {

        int rank = ch - 'a';

        // After 'n', everything shifts by 1
        if (ch >= 'o') {
            rank++;
        }

        return rank;
    }
}