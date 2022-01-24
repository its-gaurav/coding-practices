/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/*
If we observe given example carefully,
For left-child of currentNode, next(left-child) will be right-child of currentNode
For right-child of currentNode, next(right-child) will be:
a. If next(currentNode) exists, left(next(currentNode))
b. Else NULL
*/
class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.next = null;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node currNode = queue.poll();
                if(currNode.left!=null){
                    queue.add(currNode.left);
                    currNode.left.next = currNode.right;
                }
                if(currNode.right!=null){
                    queue.add(currNode.right);
                    if(currNode.next!=null){
                        currNode.right.next = currNode.next.left;
                    }else{
                        currNode.right.next = null;
                    }
                }
            }
            
        }
        
        return root;
    }
}