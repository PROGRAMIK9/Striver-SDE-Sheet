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
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        return curr;
    }
    private ListNode getkth(ListNode curr, int k){
        while(curr!=null && k>0){
            curr = curr.next;
            k--;
        }
        return curr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        //create a dummy node for traversing
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //to track the prev group tail
        ListNode grpPrev = dummy;
        //run till true
        while(true){
            //get the kth node
            ListNode kth = getkth(grpPrev, k);
            //if at any point k is null stop
            if(kth == null) break;
            //store kth.next to connect the array
            ListNode kthnext = kth.next;
            //change prev to element kth next cause thats how we connect
            ListNode prev = kthnext;
            //store the curr node as the next node (first time will be first node)
            ListNode curr = grpPrev.next;
            for(int i=0;i<k;i++){
                //store the next value in temp
                ListNode temp = curr.next;
                //point curr to prev node(next group here not null)
                curr.next = prev;
                //change curr nd prev
                prev = curr;
                curr = temp;
            }
            //shift grp prev to point to the tail
            ListNode temp = grpPrev.next;
            grpPrev.next = kth;
            grpPrev = temp;
        }
        //return the head of the list
        return dummy.next;
    }
}
