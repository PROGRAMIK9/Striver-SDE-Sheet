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
       ListNode dummy = new ListNode();
       ListNode temp = dummy;
       int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            //if l1 is not null add the value to sum
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            //Repeat the same process for l2 as l1
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            //Carry gets added to sum in the node (carry=sum/10)
            sum += carry;
            carry = sum / 10;
            //create a new node holding the carry of the sum of last node
            ListNode node = new ListNode(sum % 10);
            //assign it as next node
            temp.next = node;
            //move to next
            temp = temp.next;
        }
        return dummy.next;
    }
}
