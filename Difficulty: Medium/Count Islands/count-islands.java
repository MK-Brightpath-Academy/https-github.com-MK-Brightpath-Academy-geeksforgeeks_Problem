
class Solution {

    // 8 directions
    int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] colDir = {-1,  0,  1,-1, 1,-1, 0, 1};

    public void dfs(int row, int col,
                    char[][] grid,
                    boolean[][] visited,
                    int n, int m) {

        // Mark current cell visited
        visited[row][col] = true;

        // Check all 8 directions
        for (int i = 0; i < 8; i++) {

            int newRow = row + rowDir[i];
            int newCol = col + colDir[i];

            // Check boundaries and land
            if (newRow >= 0 && newRow < n &&
                newCol >= 0 && newCol < m &&
                grid[newRow][newCol] == 'L' &&
                !visited[newRow][newCol]) {

                dfs(newRow, newCol, grid,
                    visited, n, m);
            }
        }
    }

    public int countIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int count = 0;

        // Traverse entire grid
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                // Found new island
                if (grid[i][j] == 'L' &&
                    !visited[i][j]) {

                    count++;

                    dfs(i, j, grid, visited, n, m);
                }
            }
        }

        return count;
    }
}
