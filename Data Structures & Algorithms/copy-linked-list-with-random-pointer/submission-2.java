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
        if(head == null){
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node resultHead = null;
        while(curr != null){
            Node newNode = new Node(curr.val);
            if(resultHead == null){
                resultHead = newNode;
            }
            map.put(curr, newNode);
            curr = curr.next;
        }
        // System.out.println(map);
        curr = head;
        while(curr!=null){
            Node resCurr = map.get(curr);
            Node currRandom = curr.random==null? null: map.get(curr.random);
            resCurr.random = currRandom;
            resCurr.next = map.get(curr.next);
            curr = curr.next;
        }
        return resultHead;
    }
}