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
    public void preorder(TreeNode root, List<Integer> result){
        if(root == null) return;
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        // List<Integer> result = new ArrayList<>();
        // preorder(root, result);
        // return result;
        //Morris
        List<Integer> preorder = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left == null){
                preorder.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    preorder.add(curr.val);
                    curr = curr.left;
                }else{
                    prev.right = null;
                    curr= curr.right;
                }
            }
        }
        return preorder;
    }
}
