class Solution {

    public ArrayList<Integer> printPalindromes(int m, int n) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int num = m; num <= n; num++) {

            if (isPalindrome(num)) {
                result.add(num);
            }
        }

        return result;
    }

    private boolean isPalindrome(int num) {

        int original = num;
        int reverse = 0;

        while (num > 0) {

            int digit = num % 10;

            reverse = reverse * 10 + digit;

            num = num / 10;
        }

        return original == reverse;
    }
}