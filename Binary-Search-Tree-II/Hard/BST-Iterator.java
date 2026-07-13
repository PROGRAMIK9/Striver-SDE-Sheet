/*
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
class BSTIterator {
    Stack<TreeNode> stk;
    TreeNode tree;
    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        tree = root;
        pushNodes(tree);
    }
    
    public int next() {
        TreeNode popped = stk.pop();
        pushNodes(popped.right);
        return popped.val;
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }

    private void pushNodes(TreeNode node){
        while(node!=null){
            stk.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
