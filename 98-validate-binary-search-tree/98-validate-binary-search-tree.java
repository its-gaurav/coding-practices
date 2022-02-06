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
/*
Approach: We will do an in-order traversal going for left subtree then right subtree.
While going for left subtree from root, all nodes of left subtree must be lesser than root.
While going for right subtree from root, all nodes of right subtree must be greater than root.
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        return test(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    boolean test(TreeNode root, long min, long max){
        // base case
        if(root==null){ 
            return true;
        }
        if(root.val<=min || root.val>=max){
            return false;
        }
        // hypothesis: test(root.left) would tell if left subtree is BST
        // induction
        boolean lft = test(root.left, min, root.val); // in root.left subtree, if BST thn all nodes must be lesser than root.val
        boolean right = test(root.right, root.val, max); // in root.right subtree, if BST thn all nodes must be greater than root.val
        
        return lft && right; // if both subtrees are BST
    }
}