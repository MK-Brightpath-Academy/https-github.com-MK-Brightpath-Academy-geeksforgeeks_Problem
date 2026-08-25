/* Structure of linked list node
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

    Node compute(Node head) {

        // Step 1: Reverse linked list
        head = reverse(head);

        int max = head.data;
        Node current = head;

        while (current != null && current.next != null) {

            if (current.next.data < max) {
                // Delete next node
                current.next = current.next.next;
            } else {
                current = current.next;
                max = current.data;
            }
        }

        // Step 3: Reverse again
        head = reverse(head);

        return head;
    }

    private Node reverse(Node head) {

        Node prev = null;
        Node current = head;

        while (current != null) {

            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}