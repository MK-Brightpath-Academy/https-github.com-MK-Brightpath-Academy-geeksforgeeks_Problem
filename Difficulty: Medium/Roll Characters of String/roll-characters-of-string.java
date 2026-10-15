
class Solution {
    public String findRollOut(String s, int[] roll) {
        int n = s.length();
        int[] freq = new int[n + 2];

        for (int r : roll) {
            if (r > 0 && r <= n) {
                freq[r]++;
            }
        }

        char[] arr = s.toCharArray();
        int count = 0;

        for (int i = n; i >= 1; i--) {
            count = (count + freq[i]) % 26;

            arr[i - 1] = (char) ('a' +
                (arr[i - 1] - 'a' + count) % 26);
        }

        return new String(arr);
    }
}
