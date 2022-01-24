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
Approach:
1.Using Breadth First Search, we will visit each nodes of current level and add that to our sum
2. Also while visiting node at current level, we will check for left and right child of the node
3. If left and/or right child exists, we will add them to our queue
4. Left and/or right child added to our queue will be visited in next iteration
*/
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size(); // numbr of nodes at current level
            double sum = 0;
            for(int i=0; i<size; i++){ // visiting each node of current level
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            
            result.add(sum / size); // size says number of nodes at current level
        }
        
        return result;
         
    }
}