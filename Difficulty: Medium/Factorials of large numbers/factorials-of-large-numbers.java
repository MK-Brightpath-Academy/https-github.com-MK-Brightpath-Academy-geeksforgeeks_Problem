class Solution {
    public ArrayList<Integer> factorial(int n) {

        ArrayList<Integer> result = new ArrayList<>();

        // Initially result = 1
        result.add(1);

        for (int x = 2; x <= n; x++) {

            int carry = 0;

            // Multiply current number by x
            for (int i = 0; i < result.size(); i++) {

                int product = result.get(i) * x + carry;

                result.set(i, product % 10);

                carry = product / 10;
            }

            // Add remaining carry
            while (carry > 0) {

                result.add(carry % 10);

                carry = carry / 10;
            }
        }

        // Currently digits are stored in reverse order.
        // Example: 120 -> [0, 2, 1]
        Collections.reverse(result);

        return result;
    }
}