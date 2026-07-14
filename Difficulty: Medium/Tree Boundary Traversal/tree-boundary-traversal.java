import java.util.*;

class Solution {

    ArrayList<Integer> boundaryTraversal(Node node) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (node == null)
            return ans;

        if (!isLeaf(node))
            ans.add(node.data);

        // Left Boundary
        addLeftBoundary(node, ans);

        // Leaf Nodes
        addLeaves(node, ans);

        // Right Boundary
        addRightBoundary(node, ans);

        return ans;
    }

    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    void addLeftBoundary(Node node, ArrayList<Integer> ans) {

        Node curr = node.left;

        while (curr != null) {

            if (!isLeaf(curr))
                ans.add(curr.data);

            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    void addLeaves(Node node, ArrayList<Integer> ans) {

        if (node == null)
            return;

        if (isLeaf(node)) {
            ans.add(node.data);
            return;
        }

        addLeaves(node.left, ans);
        addLeaves(node.right, ans);
    }

    void addRightBoundary(Node node, ArrayList<Integer> ans) {

        Stack<Integer> stack = new Stack<>();

        Node curr = node.right;

        while (curr != null) {

            if (!isLeaf(curr))
                stack.push(curr.data);

            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
    }
}