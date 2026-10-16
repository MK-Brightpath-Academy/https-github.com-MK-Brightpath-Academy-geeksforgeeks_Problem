class Solution {

    int rows, cols;
    int[][] dp;

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int longIncPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;

        dp = new int[rows][cols];

        int ans = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int r, int c) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        dp[r][c] = 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < rows &&
                nc >= 0 && nc < cols &&
                matrix[nr][nc] > matrix[r][c]) {

                dp[r][c] = Math.max(
                    dp[r][c],
                    1 + dfs(matrix, nr, nc)
                );
            }
        }

        return dp[r][c];
    }
}