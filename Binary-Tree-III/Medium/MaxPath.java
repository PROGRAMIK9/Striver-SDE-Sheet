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
    int sum = Integer.MIN_VALUE;
    public int solve(TreeNode root){
        if(root == null) return 0;
        // if(root.val < 0){
        //     if(root.left == null && root.right == null) return root.val;
        //     return Math.max(maxPathSum(root.left), maxPathSum(root.right));
        // }else{
        //     return maxPathSum(root.left)+maxPathSum(root.right)+root.val;
        // }
        int left = solve(root.left);
        int right = solve(root.right);
        if(left < 0) left = 0;
        if(right < 0) right = 0;
        int curr = root.val;
        sum = Math.max(sum, curr+left+right);
        sum = Math.max(sum, curr + Math.max(left, right));
        return curr + Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        solve(root);
        return sum;
    }
}
