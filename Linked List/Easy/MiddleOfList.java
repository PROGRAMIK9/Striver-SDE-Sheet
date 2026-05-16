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
    public ListNode middleNode(ListNode head) {
        //Store the head in curr to iterate
        // ListNode curr = head;
        // find the number of nodes in the linked list
        // int c = 0;
        //iterate through curr and increment c
        // while(curr!=null){
        //     c++;
        //     curr = curr.next;
        // }
        //reset curr and c and set mid
        // curr=head;
        // int mid = c/2;
        // c = 1;
        //go till u visit half elements
        // while(c<=mid){
        //     c++;
        //     curr = curr.next;
        // }
        //return the rest
        // return curr;
        //Slow Pointer that goes one node at a  time
        ListNode slow = head;
        //Fast Pointer jumps 2 nodes at a time
        ListNode fast = head;
        while(fast!=null && fast.next != null){
            //Increment slow and fast
            slow = slow.next;
            fast = fast.next.next;
        }
        //return slow
        return slow;
    }
}
