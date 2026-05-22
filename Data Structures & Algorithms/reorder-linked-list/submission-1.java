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
        if(head == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;

        ListNode reverseHalf = secondHalf;
        ListNode prevHalf = null;
        while(reverseHalf != null){
            ListNode temp = reverseHalf.next;
            reverseHalf.next = prevHalf;
            prevHalf = reverseHalf;
            reverseHalf = temp;
        }
        // now I have two LL start from first and splice it with second;
        ListNode first = head;
        ListNode second = prevHalf;
        while(first != null && second != null){
            ListNode firstNext = first.next;
            first.next = second;
            first = firstNext;
            
            ListNode secondNext = second.next;
            second.next = first;
            second = secondNext;
        }
    }
}
//
