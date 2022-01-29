The problem can be solved by finding if topological sort is possible for given graph.
If topological sort is possible then all problems can be solved.
Else return false.
Topological sort means that for all given vertices, vertices can be arranged in a order using its adjacency matrix such that vertix 'u' always comes before vertex 'v'.
Topological sort is possible only if given graph is Directed-Acyclic-Graph.
Hence if a cycle exists, topo sort won't be possible.
