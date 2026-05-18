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
        // //if linked list is empty return null
        // if(head == null) return null;
        // //copy the head to traverse
        // ListNode curr = head;
        // //maintain count of the length
        // int count=0;
        // while(curr!=null){
        //     //increment count
        //     count++;
        //     //movee to next node
        //     curr = curr.next;
        // }
        // // if the size of the linked list is the same as element to be deleted then just return from 2nd element
        // if(count == n) return head.next;
        // //calculate which element to delete from back
        // count = count - n;
        // //reset traversal
        // curr = head;
        // while(curr!=null){
        //     count--;
        //     if(count == 0) break;
        //     curr = curr.next;
        // }
        // //delete the node(just unlink it)
        // curr.next = curr.next.next;
        // //return head
        // return head;
        if(head == null) return
        ListNode dummy = head;
        ListNode slow = head;
        ListNode fast = head;
        for(int i=1;i<=n;i++){
            fast = fast.next;
        }
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy;
    }
}
