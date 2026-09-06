class Solution {
    public long findGroups(int[] arr) {
        long[] count = new long[3];

        // Count numbers according to remainder
        for (int num : arr) {
            count[num % 3]++;
        }

        long ans = 0;

        // Groups of size 2

        // 0 + 0 = multiple of 3
        ans += count[0] * (count[0] - 1) / 2;

        // 1 + 2 = multiple of 3
        ans += count[1] * count[2];

        // Groups of size 3

        // 0 + 0 + 0
        ans += count[0] * (count[0] - 1) * (count[0] - 2) / 6;

        // 1 + 1 + 1
        ans += count[1] * (count[1] - 1) * (count[1] - 2) / 6;

        // 2 + 2 + 2
        ans += count[2] * (count[2] - 1) * (count[2] - 2) / 6;

        // 0 + 1 + 2
        ans += count[0] * count[1] * count[2];

        return ans;
    }
}