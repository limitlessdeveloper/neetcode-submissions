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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode resultHead = null;
        ListNode resultCurr = null;
        int carry = 0;
        while(curr1!=null && curr2!=null){
            int fs = curr1.val;
            int sec = curr2.val;
            int currSum = fs + sec + carry;
            int fl = currSum % 10;
            int cil = currSum / 10;
            carry = cil;
            ListNode newNode = new ListNode(fl);            
            if(resultHead == null){
                resultHead = newNode;
                resultCurr = newNode;
            }
            else{
                resultCurr.next = newNode;
                resultCurr = resultCurr.next;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while(curr1 != null){
            int fs = curr1.val;
            int currSum = fs + carry;
            int fl = currSum % 10;
            int cil = currSum / 10;
            carry = cil;
            ListNode newNode = new ListNode(fl);            
            if(resultHead == null){
                resultHead = newNode;
                resultCurr = newNode;
            }
            else{
                resultCurr.next = newNode;
                resultCurr = resultCurr.next;
            }
            curr1 = curr1.next;
        }

        while(curr2 != null){
            int fs = curr2.val;
            int currSum = fs + carry;
            int fl = currSum % 10;
            int cil = currSum / 10;
            carry = cil;
            ListNode newNode = new ListNode(fl);            
            if(resultHead == null){
                resultHead = newNode;
                resultCurr = newNode;
            }
            else{
                resultCurr.next = newNode;
                resultCurr = resultCurr.next;
            }
            curr2 = curr2.next;
        }

        if(carry != 0){
            ListNode newNode = new ListNode(carry);            
            resultCurr.next = newNode;
            resultCurr = resultCurr.next;
        }
    
        return resultHead;
    }
}