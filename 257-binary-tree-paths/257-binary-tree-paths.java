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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        solve(root, "",res);
        
        return res;
    }
    
    void solve(TreeNode root, String path, List<String> res){
        if(root==null){
            return;
        }
        // if last node, just add to the path
        if(root.left==null && root.right==null){
            res.add(path + root.val);
        }
        // if left child is there, path will be current path + current node + "->"
        if(root.left!=null){
            solve(root.left, path + root.val + "->", res);
        }
        // if right child is there, path will be current path + current node + "->"
        if(root.right!=null){
            solve(root.right, path + root.val + "->", res);
        }
    }
}