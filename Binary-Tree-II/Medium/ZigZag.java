/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean swap = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> curr = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode c = q.poll();
                if(swap){
                    curr.add(c.val);
                }else{
                    curr.addFirst(c.val);
                }
                if(c.left!=null) q.offer(c.left);
                if(c.right!=null) q.offer(c.right);
            }
            res.add(curr);
            swap = !swap;
        }
        return res;
    }
}
