import java.util.*;

class Solution {
    public int shortestPath(int k, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Queue: row, col, wallsRemoved, steps
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][k + 1];

        queue.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];
            int removed = curr[2];
            int steps = curr[3];

            // Destination reached
            if (row == n - 1 && col == m - 1) {
                return steps;
            }

            for (int d = 0; d < 4; d++) {
                int nr = row + dr[d];
                int nc = col + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                int newRemoved = removed + mat[nr][nc];

                if (newRemoved <= k &&
                    !visited[nr][nc][newRemoved]) {

                    visited[nr][nc][newRemoved] = true;

                    queue.offer(new int[]{
                        nr, nc, newRemoved, steps + 1
                    });
                }
            }
        }

        return -1;
    }
}