/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // if(head == null) return null;
        // HashMap<Node, Node> map = new HashMap<>();
        // Node curr = head;
        // while(curr != null){
        //     map.put(curr, new Node(curr.val));
        //     curr = curr.next;
        // }
        // curr = head;
        // while(curr!=null){
        //     map.get(curr).next = map.get(curr.next);
        //     map.get(curr).random = map.get(curr.random);
        //     curr = curr.next;
        // }
        // return map.get(head);
        if(head == null) return null;
        Node curr = head;
        while(curr!=null){
            Node newNode = new Node(curr.val, curr.next);
            curr.next = newNode;
            curr = newNode.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next!=null? curr.next.next:null;
        }
        Node old = head;
        Node newh = head.next;
        Node co = old;
        Node cn = newh;
        while(co != null){
            co.next = co.next.next;
            cn.next = cn.next!=null?cn.next.next:null;
            co = co.next;
            cn = cn.next;
        }
        return newh;
    }
}
