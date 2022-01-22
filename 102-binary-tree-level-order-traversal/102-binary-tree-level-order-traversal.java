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
Level Order Traversal can be achieved using BFS approach
Create a class that will have node and level of that node
Here we can use queue data structure. We will first add root with level to the queue
1. Now remove node from queue and check for left & right child of the node.
2. If left is available, add that to our answer and add left node to queue with (currentLevel + 1) as well.
3. Similarly if right is available, add that to our answer and add right node to queue with (currentLevel + 1) as well.
4. If level of the node we are pushing to queue is being reached for the first time, then we have to add new list of values to our result.
5. If level of the node  we are pushing to queue is already visited, then the node.val will be pushed to the existing list available in our result.
4. Again repeat from step 1

*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(new Node(root, 0));
        
        result.add(new ArrayList<>());
        result.get(0).add(root.val);
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            TreeNode currNode = node.node;
            // System.out.println("val: "+node.node.val+" level: "+node.level);
            List<Integer> adjacentNodes = new ArrayList<>();
            if(currNode.left!=null){
                adjacentNodes.add(currNode.left.val);
                queue.add(new Node(currNode.left, node.level+1));
                if(result.size()>node.level+1){ // if the level (node.level+1) was already visited
                    result.get(node.level+1).add(currNode.left.val);
                }
            }
            if(currNode.right!=null){
                adjacentNodes.add(currNode.right.val);
                queue.add(new Node(currNode.right, node.level+1));
                if(result.size()>node.level+1){ // if the level (node.level+1) was already visited
                    result.get(node.level+1).add(currNode.right.val);
                }
            }
            
            if(result.size()<=node.level+1 && !adjacentNodes.isEmpty()){ // if the level (node.level+1) is being visited first time
                result.add(adjacentNodes);
            }
            
        }
        
        return result;
    }
    
    /*
    Time Complexity: O(n) where n is number of nodes
    Space Complexity: O(n) where n is number of nodes
    */
}

class Node{
    TreeNode node;
    int level;
    
    Node(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}