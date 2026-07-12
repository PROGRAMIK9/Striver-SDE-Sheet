/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = Math.min(p.val, q.val);
        int large = Math.max(p.val, q.val);
        if(root == null)return null;


        if(root.val >= small && root.val <= large)return root;
        
        if(root.val > large){
            return lowestCommonAncestor(root.left,p,q);
        }

        return lowestCommonAncestor(root.right,p,q);
    }
}
