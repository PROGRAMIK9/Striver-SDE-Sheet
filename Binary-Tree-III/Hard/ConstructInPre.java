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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i], i);
        }
        return builder(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }
    public TreeNode builder(int[] preorder, int pi, int pj, int[] inorder, int ii, int ij, HashMap<Integer, Integer> map){
        if(pi > pj || ii > ij) return null;
        TreeNode root = new TreeNode(preorder[pi]);
        int iroot = map.get(root.val);
        int leftvals  = iroot - ii;
        root.left = builder(preorder, pi + 1, pi + leftvals, inorder, ii, iroot-1, map);
        root.right = builder(preorder, pi + leftvals + 1 , pj , inorder, iroot + 1, ij, map);
        return root;
    }
}
