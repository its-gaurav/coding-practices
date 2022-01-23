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
Here we can use stack data structure. We will first add root with level to the stack

Reason being if we observe carefully, the node we are adding last to our data-structure in each level traversal needs to be popped first in next level traversal.

Also since we are following zig-zag fashion, nodes at even level (e.g 0,2,4,6,8....) are to be traversed from left to right. And nodes at odd level (e.g 1,3,5,7,9,...) are to be traversed from right to left.

1. All nodes of a certain level l1 added to a stack would be used to find result nodes of level l1+1
2. To ensure that stack contains nodes of current level only, we will be using two stacks. 1st stack will be containing nodes of current level l1 which we will be popping one by one. 2nd stack will be containing nodes of 
level l1+1.
3. Once we pop a node, we will see for left and right child which if exist then we will add to our list and to stack as well
4. Once we have popped all nodes of current level l1 which were available in 1st stack, Now we need to do the same operation for nodes available in 2nd stack as this stack contains all nodes of next level i.e l1+1
5. Once all nodes are popped, that means we have processed all nodes of current level hence we can add the list to our answer


*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        stack1.add(root);
        
        result.add(new ArrayList<>());
        result.get(0).add(root.val);
        int level = 0;
        while(!stack1.isEmpty()){
            int size = stack1.size();
            level = 1 - level; // new level type (odd / even)
            List<Integer> ans = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = stack1.pop();
                if(level%2 != 0){ // if newLevel is odd then we have to add right first
                    addRight(node, stack2, ans);
                    addLeft(node, stack2, ans);
                }else{ // if newLevel is even then we have to add left first
                    addLeft(node, stack2, ans);
                    addRight(node, stack2, ans);
                }
            }
            /*
            if all nodes of current level has been checked and we found an non-empty answer from this level,
            we can add the same to our result.
            */ 
            if(!ans.isEmpty()){
                result.add(ans);
                stack1 = stack2;
                stack2 = new Stack<>();
            }
        }
        return result;
    }
    
    static void addLeft(TreeNode currNode, Stack<TreeNode> stack, List<Integer> res){
        if(currNode.left!=null){
            stack.add(currNode.left);
            res.add(currNode.left.val);
        }
    }
    
    static void addRight(TreeNode currNode, Stack<TreeNode> stack, List<Integer> res){
        if(currNode.right!=null){
            stack.add(currNode.right);
            res.add(currNode.right.val);
        }
    }
}