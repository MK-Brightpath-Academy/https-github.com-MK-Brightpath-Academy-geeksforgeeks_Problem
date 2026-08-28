class Solution {

    public int solve(int x, int y, String s) {

        int profit = 0;

        // If "pr" gives more profit, remove "pr" first
        if (x >= y) {

            StringBuilder stack = new StringBuilder();

            for (char ch : s.toCharArray()) {

                int n = stack.length();

                if (n > 0 &&
                    stack.charAt(n - 1) == 'p' &&
                    ch == 'r') {

                    stack.deleteCharAt(n - 1);
                    profit += x;

                } else {
                    stack.append(ch);
                }
            }

            // Now remove "rp"
            StringBuilder stack2 = new StringBuilder();

            for (char ch : stack.toString().toCharArray()) {

                int n = stack2.length();

                if (n > 0 &&
                    stack2.charAt(n - 1) == 'r' &&
                    ch == 'p') {

                    stack2.deleteCharAt(n - 1);
                    profit += y;

                } else {
                    stack2.append(ch);
                }
            }

        } else {

            // If "rp" gives more profit, remove "rp" first
            StringBuilder stack = new StringBuilder();

            for (char ch : s.toCharArray()) {

                int n = stack.length();

                if (n > 0 &&
                    stack.charAt(n - 1) == 'r' &&
                    ch == 'p') {

                    stack.deleteCharAt(n - 1);
                    profit += y;

                } else {
                    stack.append(ch);
                }
            }

            // Now remove "pr"
            StringBuilder stack2 = new StringBuilder();

            for (char ch : stack.toString().toCharArray()) {

                int n = stack2.length();

                if (n > 0 &&
                    stack2.charAt(n - 1) == 'p' &&
                    ch == 'r') {

                    stack2.deleteCharAt(n - 1);
                    profit += x;

                } else {
                    stack2.append(ch);
                }
            }
        }

        return profit;
    }
}