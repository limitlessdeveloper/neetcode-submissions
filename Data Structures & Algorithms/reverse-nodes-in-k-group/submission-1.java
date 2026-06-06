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
 // Theory about solution: first reach to the k distance then inside loop fron starting to k distance and reverse them, keep in mind about the very first condition of head and previous head.
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k == 1){
            return head;
        }
        int target = k;
        int count = 1;
        ListNode p = head;
        ListNode tempHead = head;
        ListNode prevHead = head;
        ListNode resultHead = null;
        while(p != null && p.next != null && count<target){
            count++;
            p = p.next;
            if(count==target){
                ListNode curr = tempHead.next;
                ListNode prev = tempHead;
                int tempCount = 1;
                while(curr!=null && tempCount<k){
                    ListNode temp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = temp;
                    tempCount++;
                }
                if(tempCount==target){
                    resultHead = prev;
                }
                else{
                    prevHead.next = prev;
                    prevHead = tempHead;
                }
                tempHead.next = curr;
                tempHead = curr;
                p = tempHead;
                count++;
                target += k;
            }
        }
        return resultHead;
    }
}