class Solution {
    public String multiplyStrings(String s1, String s2) {

        // Check signs
        boolean negative = false;

        if (s1.charAt(0) == '-') {
            negative = !negative;
            s1 = s1.substring(1);
        }

        if (s2.charAt(0) == '-') {
            negative = !negative;
            s2 = s2.substring(1);
        }

        // Remove leading zeros
        s1 = removeLeadingZeros(s1);
        s2 = removeLeadingZeros(s2);

        // If either number is zero
        if (s1.equals("0") || s2.equals("0")) {
            return "0";
        }

        int n = s1.length();
        int m = s2.length();

        int[] result = new int[n + m];

        // Multiply
        for (int i = n - 1; i >= 0; i--) {

            for (int j = m - 1; j >= 0; j--) {

                int digit1 = s1.charAt(i) - '0';
                int digit2 = s2.charAt(j) - '0';

                int product = digit1 * digit2;

                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = product + result[pos2];

                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }

        // Convert result to String
        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < result.length && result[i] == 0) {
            i++;
        }

        while (i < result.length) {
            ans.append(result[i]);
            i++;
        }

        // Add negative sign
        if (negative) {
            ans.insert(0, '-');
        }

        return ans.toString();
    }

    private String removeLeadingZeros(String s) {

        int i = 0;

        while (i < s.length() - 1 && s.charAt(i) == '0') {
            i++;
        }

        return s.substring(i);
    }
}