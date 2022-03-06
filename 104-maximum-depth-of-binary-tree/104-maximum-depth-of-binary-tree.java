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

/**
Given root node of a binary tree,
(maximum of the depth of left-subtree and right-subtree) + 1 will be the maximum depth from root
*/
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);
        
        return Math.max(ldepth, rdepth) + 1;
    }
}