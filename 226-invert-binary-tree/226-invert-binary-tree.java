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
    public TreeNode invertTree(TreeNode root) {
        // BASE CONDITION
        if(root==null) {
            return null;
        }
        // HYPOTHESIS
        /*
        invertTree(root.left) would return head node after inverting subtree having head as root.left.
        invertTree(root.right) would return head node after inverting subtree having head as root.right.
        
        INDUCTION
        Once left-subtree and right-subtree are inverted, swap the heads of the two 
        */
        TreeNode headOfLeftInverted = invertTree(root.left);
        TreeNode headOfRightInverted = invertTree(root.right);
        
        root.left = headOfRightInverted;
        root.right=headOfLeftInverted;
        
        return root;
    }
}