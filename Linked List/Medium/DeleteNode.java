/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //no access to previous so just make current one the next node as its not the last node hehe
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
