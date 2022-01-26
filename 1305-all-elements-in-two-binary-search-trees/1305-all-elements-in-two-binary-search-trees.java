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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        if(root1!=null){
            traverse(root1, list1, queue);
        }
        
        if(root2!=null){
            traverse(root2, list2, queue);
        }
        
        list1.addAll(list2);
        Collections.sort(list1);
        return list1;
        
    }
    
    static void traverse(TreeNode root, List<Integer> list, Queue<TreeNode> queue){
        queue.add(root);
        list.add(root.val);
        while(!queue.isEmpty()){
            TreeNode currNode = queue.poll();
            if(currNode.left!=null){
                list.add(currNode.left.val);
                queue.add(currNode.left);
            }
            if(currNode.right!=null){
                list.add(currNode.right.val);
                queue.add(currNode.right);
            }
        }
    }
}