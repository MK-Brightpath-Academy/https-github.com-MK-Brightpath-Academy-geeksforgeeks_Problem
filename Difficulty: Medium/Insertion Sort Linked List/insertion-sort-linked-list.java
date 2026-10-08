/* Structure of linked list Node
class Node {
  public int val;
  public Node next;

  public Node(int x) {
      val = x;
      next = null;
  }
};*/
class Solution {

    public Node insertionSort(Node head) {

        // Dummy node makes insertion at beginning easy
        Node dummy = new Node(0);

        Node current = head;

        while (current != null) {

            // Save next node before changing current.next
            Node next = current.next;

            // Find correct position in sorted list
            Node prev = dummy;

            while (prev.next != null &&
                   prev.next.val <= current.val) {

                prev = prev.next;
            }

            // Insert current between prev and prev.next
            current.next = prev.next;
            prev.next = current;

            // Move to next original node
            current = next;
        }

        return dummy.next;
    }
}