/* Node Structure
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    int getKthFromLast(Node head, int k) {

        Node fast = head;
        Node slow = head;

        // Move fast k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return -1;
            }
            fast = fast.next;
        }

        // Move both pointers
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;
    }
}