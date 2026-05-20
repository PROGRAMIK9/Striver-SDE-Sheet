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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stk = new Stack<>();
        ListNode temp = head;
        int c=0;
        while(temp!=null){
            c++;
            temp = temp.next;
        }
        temp = head;
        int i =0;
        while(i < c/2){
            stk.push(temp.val);
            System.out.println(temp.val+ " "+i );
            temp = temp.next;
            i++;
        }
        temp = c%2==0?temp:temp.next;
        i=0;
        while(i<c/2){
            if(stk.peek() == temp.val) stk.pop();
            System.out.println(temp.val+ " "+i);
            temp=temp.next;
            i++;
        }
        if(stk.isEmpty()) return true;
        return false;
    }
}
