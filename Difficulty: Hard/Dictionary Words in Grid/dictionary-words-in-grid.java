
class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public ArrayList<String> findWords(char[][] board, String[] words) {

        ArrayList<String> result = new ArrayList<>();

        TrieNode root = new TrieNode();

        // Step 1: Build Trie
        for (String word : words) {

            TrieNode curr = root;

            for (char ch : word.toCharArray()) {

                int index = ch - 'A';

                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }

                curr = curr.children[index];
            }

            curr.word = word;
        }

        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        // Step 2: Start DFS from every cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int index = board[i][j] - 'A';

                if (root.children[index] != null) {

                    dfs(board, i, j, root.children[index],
                        visited, result);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] board, int row, int col,
                     TrieNode node, boolean[][] visited,
                     ArrayList<String> result) {

        // Word found
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        visited[row][col] = true;

        // Only 4 directions
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {

            int nr = row + dr[k];
            int nc = col + dc[k];

            if (nr >= 0 && nr < board.length &&
                nc >= 0 && nc < board[0].length &&
                !visited[nr][nc]) {

                int index = board[nr][nc] - 'A';

                if (node.children[index] != null) {

                    dfs(board, nr, nc,
                        node.children[index], visited, result);
                }
            }
        }

        // Backtracking
        visited[row][col] = false;
    }
}
