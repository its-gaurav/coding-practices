class Solution {
    /*
    The problem can be solved by finding if topological sort is possible for given graph.
    If topological sort is possible then all problems can be solved.
    Else return false.
    
    Topological sort means that for all given vertices, vertices can be arranged in a order using its
    adjacency matrix such that vertix 'u' always comes before vertex 'v'
    
    Topological sort is possible only if given graph is Directed-Acyclic-Graph
    Hence if a cycle exists, topo sort won't be possible
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=1; i<=numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] prereq: prerequisites){
            int src = prereq[1];
            int dest = prereq[0];
            adj.get(src).add(dest);
        }
        
        return !isCyclic(numCourses, adj);
    }
    
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        boolean[] visDFS = new boolean[v];
        Arrays.fill(vis, false);
        Arrays.fill(visDFS, false);
        
        for(int i=0; i<v; i++){
            if(!vis[i]){
                if(checkCycleUsingDFS(i, adj, vis, visDFS)){ // if cycle is found at any vertex, then return true there itself
                    return true;
                }   
            }
        }
        // if all vertex are visited and there is no cycle
        return false;
    }
    
    boolean checkCycleUsingDFS(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] visDFS){
        vis[v] = true;
        visDFS[v] = true; // assuming v has cycle
        if(adj.size()>v){
            for(int it: adj.get(v)){
                if(!vis[it]){
                    if(checkCycleUsingDFS(it, adj, vis, visDFS)){ // if cycle is found at any vertex, then return true there itself
                        return true;
                    }
                }else{ // if node already visited and visited in the same dfs recursion call, then it is a cycle
                    if(vis[it] && visDFS[it]){
                        return true;
                    }
                }
            }
        }
        
        
        visDFS[v] = false; // it tells there is no cycle having vertex v
        return false;
        
    }
}