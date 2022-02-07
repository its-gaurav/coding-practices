class Solution {
    /*
    Observation tells it is a case of BFS/DFS traversal of directed graph
    BFS/DFS traversal would give required answer.
    Also if cycle exists in our graph, then courses cannot be completed.
    Hence we will find topological sort using DFS appraoch
    Using stack we will store element having largest outdegree at the top 
    Then we will traverse stack from the top
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        // preparing adjacency matrix
        for(int[] edge: prerequisites){
            int src = edge[1];
            int destn = edge[0];
            
            adj.get(src).add(destn);
        }
        
        boolean[] vis = new boolean[numCourses];
        boolean[] visDFS = new boolean[numCourses];
        Arrays.fill(vis, false);
        Arrays.fill(visDFS, false);
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<numCourses; i++){
            if(!vis[i]){
                boolean isCycle = findTopo(i, adj, vis, visDFS, stack);
                if(isCycle){
                    return new int[0];
                }
            }
        }
        
        int[] res = new int[stack.size()];
        int k=0;
        while(!stack.isEmpty()){
            res[k++] = stack.pop();
        }
        
        return res;
    }
    
    /*
    It stores all elements in topo order in a stack
    Also if a cycle exists it returns true;
    */
    boolean findTopo(int v, List<List<Integer>> adj, boolean[] vis, boolean[] visDFS, Stack<Integer> stack){
        vis[v] = true;
        visDFS[v] = true;
        for(int it: adj.get(v)){
            if(vis[it] && visDFS[it]){ // if true that means node `it` being reached second time in same DFS recursion tree 
                return true;
            }else if(!vis[it]){
                if(findTopo(it, adj, vis, visDFS, stack)){
                    return true;
                } 
            }
        }
        // once all adjacent elements of vertex v are processed, then add v into the stack
        stack.push(v);
        visDFS[v] = false;
        
        return false;
    }
}