/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Pass 1: place each clone immediately after its original.
        for (Node cur = head; cur != null; cur = cur.next.next) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
        }

        // Pass 2: assign random pointers on the clones.
        for (Node cur = head; cur != null; cur = cur.next.next) {
            cur.next.random = (cur.random == null) ? null : cur.random.next;
        }

        // Pass 3: detach clones into their own list and restore the original.
        Node copyHead = head.next;
        for (Node cur = head; cur != null; cur = cur.next) {
            Node copy = cur.next;
            cur.next = copy.next;                       // restore original chain
            copy.next = (copy.next == null) ? null : copy.next.next; // copy chain
        }

        return copyHead;
    }
}