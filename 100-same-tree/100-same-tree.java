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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base condition
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        
        // hypothesis & induction
        if(p.val == q.val){
            // if values of current nodes are equal, then compare p.left with q.left and p.right with q.right
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);   
        }
        // if values are not equal then no need to check further
        return false;
    }
}