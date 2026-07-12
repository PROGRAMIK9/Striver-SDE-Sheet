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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length-1);
    }
    public TreeNode helper(int[] preorder, int left, int right){
        if(left>right) return null;
        TreeNode root = new TreeNode(preorder[left]);
        int end = right;
        while(end>left && preorder[end] > root.val){
            end--;
        }
        root.left = helper(preorder, left+1, end);
        root.right = helper(preorder, end+1, right);
        return root;
    }
}
