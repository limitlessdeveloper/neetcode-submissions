/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: find the middle. After the loop, `slow` is the last node
        // of the first half (for even length) or the exact middle (for odd).
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: reverse everything strictly after `slow`, then sever the
        // link so the first half is a properly terminated list.
        ListNode second = reverse(slow.next);
        slow.next = null;
        ListNode first = head;

        // Step 3: weave `second` into `first`, one node at a time.
        // first :  a -> b -> c
        // second:  z -> y
        // result:  a -> z -> b -> y -> c
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    /**
     * Iterative in-place reversal of a singly linked list. Returns the new
     * head (which is the previous tail). Used by {@link #reorderList} to
     * flip the second half before the interleaving step.
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /** Build a linked list from an int array; returns null for empty input. */
    public ListNode build(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int v : vals) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    /** Render a linked list as "[a, b, c]" for quick visual verification. */
    public String toString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        boolean first = true;
        for (ListNode n = head; n != null; n = n.next) {
            if (!first) sb.append(", ");
            sb.append(n.val);
            first = false;
        }
        return sb.append("]").toString();
    }
}
