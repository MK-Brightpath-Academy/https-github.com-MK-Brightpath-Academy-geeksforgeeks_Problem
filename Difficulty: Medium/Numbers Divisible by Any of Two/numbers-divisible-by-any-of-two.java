
class Solution {
    public int sumOfSeries(int n, int a, int b) {
        long mod = 1_000_000_007L;

        long sumA = sumDivisible(n, a);
        long sumB = sumDivisible(n, b);
        long lcm = (long) a / gcd(a, b) * b;
        long sumBoth = lcm <= n ? sumDivisible(n, lcm) : 0;

        long ans = (sumA + sumB - sumBoth) % mod;

        return (int) ((ans + mod) % mod);
    }

    private long sumDivisible(long n, long d) {
        long k = n / d;
        return (k * (k + 1) / 2 % 1_000_000_007L)
               * (d % 1_000_000_007L)
               % 1_000_000_007L;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
