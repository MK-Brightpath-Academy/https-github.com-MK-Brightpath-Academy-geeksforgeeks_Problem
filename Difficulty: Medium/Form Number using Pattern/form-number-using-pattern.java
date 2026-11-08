import java.util.*;

class Solution {

    String minNumber(String p) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i <= p.length(); i++) {

            stack.push(i + 1);

            // If I comes or pattern ends
            if (i == p.length() || p.charAt(i) == 'I') {

                while (!stack.isEmpty()) {
                    ans.append(stack.pop());
                }
            }
        }

        return ans.toString();
    }
}