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
    public ListNode rotateRight(ListNode head, int k) {
        //edge cases
        if (head == null || head.next == null || k == 0) return head;
        //use a temp node for traversal
        ListNode temp = head;
        //setup the length of ll
        int n = 0;
        //to keep track of last element
        ListNode prev=null;
        while(temp!=null){
            n++;
            prev= temp;
            temp=temp.next;
        } 
        k=k%n;
        //create a cycle
        prev.next = head;
        prev = head;
        //loop n-k-1 times
        for(int i = 0;i<n-k-1;i++){
            prev = prev.next;
        }
        //set temp to the head node
        temp = prev.next;
        //set last node n-k to null
        prev.next = null;
        return temp;
    }
}
