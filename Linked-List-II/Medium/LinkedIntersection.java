/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // //Create a hashset to keep track of nodes in 1l
        // HashSet<ListNode> map = new HashSet<>();
        // ListNode l1 = headA;
        // while(l1!=null){
        //     //push all nodes to l1
        //     map.add(l1);
        //     l1 = l1.next;
        // }
        // //start traversing l2
        // ListNode l2 = headB;
        // if l2 is present in set then return that node
        // while(l2!=null){
        //     if(map.contains(l2)) return l2;
        //     l2 = l2.next;
        // }
        // //if not present return null
        // return null;
        //Create 2 dummy lists
        ListNode d1 = headA;
        ListNode d2 = headB;
        //until they collide keep going
        while(d1!=d2){
            //if reached null reset to the other list
            d1 = d1==null?headB:d1.next;
            d2 = d2==null?headA:d2.next;
        }
        //return d1, it will be null if not collided
        return d1;
    }
}
