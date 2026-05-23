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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            head = null;
            return head;
        }
        int count = 0;
        ListNode current = head;
        while(current!=null && count!=n){
            current = current.next;
            count++;
        }
       
        ListNode prev = head;
        
        if(current == null){
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }

        while(current!=null){
            current = current.next;
            if(current==null){
                ListNode temp = prev.next;
                prev.next = prev.next.next;
                temp.next = null;
                return head;
            }
            prev = prev.next;
        }

        return head;
    }
}