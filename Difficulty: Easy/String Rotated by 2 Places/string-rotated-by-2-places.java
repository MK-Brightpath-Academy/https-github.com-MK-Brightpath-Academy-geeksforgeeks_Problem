class Solution {
    public boolean isRotated(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int n = s1.length();

        if (n <= 2) {
            return s1.equals(s2);
        }

        // Clockwise rotation by 2
        String clockwise = s1.substring(n - 2) + s1.substring(0, n - 2);

        // Anti-clockwise rotation by 2
        String antiClockwise = s1.substring(2) + s1.substring(0, 2);

        return s2.equals(clockwise) || s2.equals(antiClockwise);
    }
}