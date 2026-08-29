/*Linked List Node
class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d;
        next = null;
    }
}

//Tree Node
class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }

}*/

class Solution {
    public TNode sortedListToBST(LNode head) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Single node
        if (head.next == null) {
            return new TNode(head.data);
        }

        // Find middle node
        LNode slow = head;
        LNode fast = head;
        LNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect left half from middle
        prev.next = null;

        // slow is the middle node
        TNode root = new TNode(slow.data);

        // Left half
        root.left = sortedListToBST(head);

        // Right half
        root.right = sortedListToBST(slow.next);

        return root;
    }
}