import java.util.*;

class Solution {

    Node flatten(Node root) {

        if (root == null) {
            return null;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.data, b.data)
        );

        // Put the head of every list into the heap
        Node current = root;

        while (current != null) {
            pq.add(current);
            current = current.next;
        }

        Node dummy = new Node(-1);
        Node tail = dummy;

        // Extract smallest node each time
        while (!pq.isEmpty()) {

            Node node = pq.poll();

            // Save next bottom node
            if (node.bottom != null) {
                pq.add(node.bottom);
            }

            // Add node to flattened list
            tail.bottom = node;
            tail = node;

            // Remove next pointer
            node.next = null;
        }

        // End of flattened list
        tail.bottom = null;

        return dummy.bottom;
    }
}