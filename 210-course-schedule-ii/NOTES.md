* Observation tells it is a case of BFS/DFS traversal of directed graph
*     BFS/DFS traversal would give required answer.
*     Also if cycle exists in our graph, then courses cannot be completed.
*     Hence we will find topological sort using DFS appraoch
*     Using stack we will store element having largest outdegree at the top
*     Then we will traverse stack from the top