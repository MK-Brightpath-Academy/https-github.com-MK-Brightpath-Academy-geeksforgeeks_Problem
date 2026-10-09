class Solution {

    public int minSwaps(String s1, String s2) {

        int count01 = 0;
        int count10 = 0;

        // Count mismatches
        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }

            if (s1.charAt(i) == '0') {
                count01++;
            } else {
                count10++;
            }
        }

        // Odd total mismatches => impossible
        if ((count01 + count10) % 2 != 0) {
            return -1;
        }

        // Pair same-type mismatches
        int swaps = count01 / 2 + count10 / 2;

        // One 01 and one 10 left
        if (count01 % 2 == 1) {
            swaps += 2;
        }

        return swaps;
    }
}