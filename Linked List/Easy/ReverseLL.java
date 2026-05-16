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
    public ListNode reverseList(ListNode head) {
        //Store previous node
        ListNode prev = null;
        //Store current node
        ListNode curr = head;
        //Store Next
        ListNode next;
        //till current exists
        while(curr!=null){
            //Store next for later
            next = curr.next;
            //Store prev in next location 
            curr.next = prev;
            //save the current as previous
            prev=curr;
            //move to next node
            curr = next;
        }
        //return last node of unreversed list
        return prev;
    }
}
