class Solution {
    public String minSum(int[] arr) {
        Arrays.sort(arr);

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                num1.append(arr[i]);
            } else {
                num2.append(arr[i]);
            }
        }

        int i = 0;
        while (i < num1.length() - 1 && num1.charAt(i) == '0') {
            i++;
        }
        num1 = new StringBuilder(num1.substring(i));

        i = 0;
        while (i < num2.length() - 1 && num2.charAt(i) == '0') {
            i++;
        }
        num2 = new StringBuilder(num2.substring(i));

        return addStrings(num1.toString(), num2.toString());
    }

    private String addStrings(String a, String b) {
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }
}