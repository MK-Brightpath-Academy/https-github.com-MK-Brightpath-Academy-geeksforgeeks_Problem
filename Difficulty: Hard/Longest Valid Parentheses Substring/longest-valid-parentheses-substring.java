class Solution {
    static int maxLength(String s) {
        Stack<Integer> stack = new Stack<>();

        // Base index
        stack.push(-1);

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {

                stack.pop();

                if (stack.isEmpty()) {
                    // Current ')' becomes new base
                    stack.push(i);
                } else {
                    // Valid substring length
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}