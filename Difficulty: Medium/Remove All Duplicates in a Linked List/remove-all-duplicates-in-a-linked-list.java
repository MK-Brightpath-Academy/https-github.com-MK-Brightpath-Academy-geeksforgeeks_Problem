/* Structure of linked list Node
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
};*/
class Solution {

    Node removeDuplicates(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;
        Node curr = head;

        while (curr != null) {

            // Find duplicate nodes
            if (curr.next != null && curr.data == curr.next.data) {

                int duplicateValue = curr.data;

                // Skip ALL nodes having this value
                while (curr != null && curr.data == duplicateValue) {
                    curr = curr.next;
                }

                prev.next = curr;

            } else {

                // Current node is unique
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}