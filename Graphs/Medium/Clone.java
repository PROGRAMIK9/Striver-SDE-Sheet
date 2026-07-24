/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void dfs(Node node, Node copy, HashMap<Integer, Node> map){
        map.put(node.val, copy);
        for(Node n: node.neighbors){
            if(!map.containsKey(n.val)){
                Node newNode = new Node(n.val);
                copy.neighbors.add(newNode);
                dfs(n, newNode, map);
            }else{
                copy.neighbors.add(map.get(n.val));
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node ==  null) return null;
        HashMap<Integer, Node> map = new HashMap<>();
        Node copy = new Node(node.val);
        dfs(node,copy,map);
        return copy;
    }
}
