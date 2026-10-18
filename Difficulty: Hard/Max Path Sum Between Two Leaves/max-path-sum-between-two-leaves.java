/* Node Structure
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/


class Solution {
    private int maxSum;

    public int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;

        maxPathToLeaf(root);

        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }

    private int maxPathToLeaf(Node node) {
        if (node == null) {
            return 0;
        }

        // Leaf node
        if (node.left == null && node.right == null) {
            return node.data;
        }

        // Only right child exists
        if (node.left == null) {
            return node.data + maxPathToLeaf(node.right);
        }

        // Only left child exists
        if (node.right == null) {
            return node.data + maxPathToLeaf(node.left);
        }

        // Both children exist
        int leftSum = maxPathToLeaf(node.left);
        int rightSum = maxPathToLeaf(node.right);

        // Path between leaves through current node
        maxSum = Math.max(
            maxSum,
            leftSum + node.data + rightSum
        );

        // Return the best single downward path
        return node.data + Math.max(leftSum, rightSum);
    }
}
