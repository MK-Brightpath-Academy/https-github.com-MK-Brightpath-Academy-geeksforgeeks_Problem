/* Binary Tree Node Structure
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {

    Node head = null;
    Node prev = null;

    // Removes leaves from tree and adds them to DLL
    private Node extractLeaves(Node root) {

        if (root == null) {
            return null;
        }

        // Leaf node
        if (root.left == null && root.right == null) {

            // Add to DLL
            if (head == null) {
                head = root;
            } else {
                prev.right = root;
                root.left = prev;
            }

            prev = root;

            // Remove leaf from tree
            return null;
        }

        root.left = extractLeaves(root.left);
        root.right = extractLeaves(root.right);

        return root;
    }

    Node convertToDLL(Node root) {

        head = null;
        prev = null;

        extractLeaves(root);

        return head;
    }
}