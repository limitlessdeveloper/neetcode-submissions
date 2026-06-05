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
        if(head==null||head.next==null||k==1){
            return head;
        }
        int target = k;
        ListNode p = head;
        ListNode tempHead = head;
        ListNode previousHead = head;
        int count = 1;
        while(p != null && p.next!=null && count < target){
            count++;
            p = p.next;
            if(count == target){ 
                ListNode current = tempHead.next;
                ListNode previous = tempHead;
                int tempCount = 1;
                while(tempCount < k){
                    ListNode temp = current.next;
                    current.next = previous;
                    previous = current;
                    current = temp;
                    tempCount++;
                }
                if(tempCount==k){
                    tempHead.next = current;
                    if(tempCount == target){
                        head = previous;
                    }
                    else{
                        previousHead.next = previous;
                        previousHead = tempHead;
                    }
                    p = current;
                    tempHead = current;
                    target = target + k;
                    count++;
                }
            }
        }
        return head;
    }
}