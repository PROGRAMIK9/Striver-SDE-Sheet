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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Create a new list to store the result
        ListNode res = new ListNode();
        //traversing list
        ListNode curr = res;
        //while both of them have a current node iterate
        while(list1!=null && list2!=null){
            //if 1st list value is greater add it to the list
            if(list1.val<list2.val){
                curr.next=list1;
                //move list1 to next node
                list1 = list1.next;
            }else{
                //move list 2 to next node
                curr.next=list2;
                list2 = list2.next;
            }
            //move current to next node
            curr=curr.next;
        }
        // fill any remaining elements from list 1 or 2
        curr.next = (list1!=null)?list1:list2;
        //return first node of res
        return res.next;
    }
}
