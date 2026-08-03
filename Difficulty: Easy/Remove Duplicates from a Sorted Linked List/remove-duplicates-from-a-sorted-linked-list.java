/* Structure of linked list Node
class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node head) {
        // Empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;

        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                // Skip duplicate node
                curr.next = curr.next.next;
            } else {
                // Move to next unique node
                curr = curr.next;
            }
        }

        return head;
    }
}