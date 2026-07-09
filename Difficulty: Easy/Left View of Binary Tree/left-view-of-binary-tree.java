import java.util.*;

class Solution {

    ArrayList<Integer> leftView(Node root) {

        ArrayList<Integer> result = new ArrayList<>();

        dfs(root, 0, result);

        return result;
    }

    private void dfs(Node node, int level, ArrayList<Integer> result) {

        if (node == null)
            return;

        if (level == result.size()) {
            result.add(node.data);
        }

        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }
}