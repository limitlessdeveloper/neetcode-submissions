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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }

        ListNode llr= lists[0];
        int i=1;
        while(lists.length > i){
            ListNode llt = lists[i];
            ListNode lltr = mergeTwoLL(llr, llt);
            llr = lltr;
            i++;
        }
        return llr;
    }

    public ListNode mergeTwoLL(ListNode h1, ListNode h2){
        ListNode temphead = null;
        ListNode tempcurr = null;
        while(h1!=null && h2!=null){
            
            if(h1.val<h2.val){
                if(temphead==null){
                    temphead = h1;
                    tempcurr = h1;
                }
                else{
                    tempcurr.next = h1;
                    tempcurr = tempcurr.next; 
                }
                h1 = h1.next;
            }
            else{
                if(temphead==null){
                    temphead = h2;
                    tempcurr = h2;
                }
                else{
                    tempcurr.next = h2;
                    tempcurr = tempcurr.next; 
                }
                h2 = h2.next;
            }
        }

        if(h1!=null){
            if(temphead==null){
                temphead = h1;
                tempcurr = h1;
            }
            else{
                tempcurr.next = h1;
            }
        }

        if(h2!=null){
            if(temphead==null){
                temphead = h2;
                tempcurr = h2;
            }
            else{
                tempcurr.next = h2;
            }
        }
        return temphead;
    }
}