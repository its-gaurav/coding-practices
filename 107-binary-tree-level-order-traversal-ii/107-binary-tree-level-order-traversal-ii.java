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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) return new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        queue.add(root);
        result.add(new ArrayList<>());
        result.get(0).add(root.val);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> nextLvlNodes = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    nextLvlNodes.add(node.left.val);
                    queue.add(node.left);
                }
                if(node.right!=null){
                    nextLvlNodes.add(node.right.val);
                    queue.add(node.right);
                }
            }
            
            if(!nextLvlNodes.isEmpty()){
                result.add(nextLvlNodes);
            }
        }
        
        List<List<Integer>> revResult = new ArrayList<>();
        
        for(int i=result.size()-1; i>=0; i--){
            revResult.add(result.get(i));
        }
        
        return revResult;
        
    }
}