
class Solution {

    static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        String word;
    }

    public ArrayList<String> wordBoggle(char[][] board, String[] dictionary) {

        ArrayList<String> result = new ArrayList<>();

        TrieNode root = new TrieNode();

        // Step 1: Build Trie
        for (String word : dictionary) {

            TrieNode current = root;

            for (char ch : word.toCharArray()) {

                current.children.putIfAbsent(ch, new TrieNode());

                current = current.children.get(ch);
            }

            current.word = word;
        }

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        // Step 2: Start DFS from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                TrieNode next = root.children.get(board[i][j]);

                if (next != null) {
                    dfs(board, i, j, next, visited, result);
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

        // 8 directions
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {

            int newRow = row + dr[k];
            int newCol = col + dc[k];

            if (newRow >= 0 && newRow < board.length &&
                newCol >= 0 && newCol < board[0].length &&
                !visited[newRow][newCol]) {

                char ch = board[newRow][newCol];

                TrieNode next = node.children.get(ch);

                if (next != null) {
                    dfs(board, newRow, newCol,
                        next, visited, result);
                }
            }
        }

        // Backtracking
        visited[row][col] = false;
    }
}
