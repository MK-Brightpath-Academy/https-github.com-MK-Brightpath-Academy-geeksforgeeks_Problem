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

    public Node pairwiseSwap(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node current = head;

        // New head will be second node
        head = head.next;

        while (current != null && current.next != null) {

            Node second = current.next;
            Node nextPair = second.next;

            // Swap current and second
            second.next = current;
            current.next = nextPair;

            // Connect previous pair
            if (prev != null) {
                prev.next = second;
            }

            // Move to next pair
            prev = current;
            current = nextPair;
        }

        return head;
    }
}