class Solution {

    public ArrayList<ArrayList<Integer>> paths(Node root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        dfs(root, path, result);

        return result;
    }

    private void dfs(Node node,
                     ArrayList<Integer> path,
                     ArrayList<ArrayList<Integer>> result) {

        if (node == null) {
            return;
        }

        // Add current node
        path.add(node.data);

        // If leaf node
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {

            // Traverse left
            dfs(node.left, path, result);

            // Traverse right
            dfs(node.right, path, result);
        }

        // Backtracking
        path.remove(path.size() - 1);
    }
}