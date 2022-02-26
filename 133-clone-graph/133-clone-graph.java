/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
/*
Traverse through each node using BFS
On reaching each node, check if clone of the node already exists.
If NOT existing, then create a new clone and 
Once clone is found against a node, store that mapping
Also check clones for adjacent nodes
If clone of adjacent node does not exist, it tells that we are visiting the node 1st time
Hence we will create clone of adjacent nodes, and mark them visited using map
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        HashMap<Integer, Node> map = new HashMap<>();
        while(!queue.isEmpty()){
            Node curr = queue.remove();
            Node clone;
            if(map.containsKey(curr.val)){
                clone = map.get(curr.val);
            }else{
                clone = new Node(curr.val);
            }
            map.put(curr.val, clone);
            for(Node adj: curr.neighbors){
                Node adjClone;
                if(map.containsKey(adj.val)){
                    adjClone = map.get(adj.val);
                }else{ // if adj being visited 1st time
                    queue.add(adj);
                    adjClone = new Node(adj.val);    
                }
                clone.neighbors.add(adjClone);
                map.put(adj.val, adjClone);
            }
        }
        
        return map.get(node.val);
    }
}