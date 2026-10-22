
class Solution {
    public int countGroups(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 1 && !visited[i][j]) {
                    boolean[] surrounded = {true};

                    dfs(mat, visited, i, j, surrounded);

                    if (surrounded[0]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private void dfs(int[][] mat, boolean[][] visited,
                     int i, int j, boolean[] surrounded) {

        int n = mat.length;
        int m = mat[0].length;

        visited[i][j] = true;

        // Group touches matrix boundary
        if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
            surrounded[0] = false;
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            if (nr >= 0 && nr < n &&
                nc >= 0 && nc < m &&
                mat[nr][nc] == 1 &&
                !visited[nr][nc]) {

                dfs(mat, visited, nr, nc, surrounded);
            }
        }
    }
}
