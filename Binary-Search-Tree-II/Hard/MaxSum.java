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
   private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return maxSum;
    }

    // Returns an array of 4 integers:
    // [0] -> 1 if it's a BST, 0 if it's not
    // [1] -> Minimum value in the subtree
    // [2] -> Maximum value in the subtree
    // [3] -> Sum of the subtree
    private int[] postOrder(TreeNode node) {
        // Base case: An empty tree is a valid BST.
        // Min is MAX_VALUE and Max is MIN_VALUE so any leaf node can easily attach to it.
        if (node == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        // 1. Traverse left and right subtrees
        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);

        // 2. Check if the current subtree is a valid BST
        // Condition: left is BST, right is BST, node.val > left max, node.val < right min
        if (left[0] == 1 && right[0] == 1 && node.val > left[2] && node.val < right[1]) {
            
            // It is a valid BST. Calculate the current sum.
            int currentSum = node.val + left[3] + right[3];
            
            // Update the global maximum sum.
            maxSum = Math.max(maxSum, currentSum);
            
            // Return the updated state to the parent.
            // Note: Use Math.min and Math.max to handle leaf node cases where 
            // left[1] or right[2] might be the theoretical infinity bounds.
            return new int[]{
                1, 
                Math.min(node.val, left[1]), 
                Math.max(node.val, right[2]), 
                currentSum
            };
        }

        // 3. If it's not a valid BST, pass a failure state up the tree.
        // We only care about the first index being 0 (false). The other values don't matter anymore.
        return new int[]{0, 0, 0, 0};
    }
}
