
class Solution {
    public String findString(int n, int k) {
        int total = 1;
        for (int i = 0; i < n; i++) {
            total *= k;
        }

        int power = 1;
        for (int i = 1; i < n; i++) {
            power *= k;
        }

        boolean[] visited = new boolean[total];
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            ans.append('0');
        }

        int node = 0;
        visited[0] = true;
        int count = 1;

        while (count < total) {
            boolean found = false;

            for (int digit = k - 1; digit >= 0; digit--) {
                int edge = node * k + digit;

                if (!visited[edge]) {
                    visited[edge] = true;
                    ans.append((char) ('0' + digit));
                    node = edge % power;
                    count++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                break;
            }
        }

        return ans.toString();
    }
}
