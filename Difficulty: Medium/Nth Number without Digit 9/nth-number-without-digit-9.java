
import java.math.BigInteger;

class Solution {
    public String findNth(String n) {
        BigInteger num = new BigInteger(n);
        BigInteger nine = BigInteger.valueOf(9);
        StringBuilder ans = new StringBuilder();

        while (num.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] qr = num.divideAndRemainder(nine);

            ans.append(qr[1].intValue());
            num = qr[0];
        }

        return ans.reverse().toString();
    }
}
