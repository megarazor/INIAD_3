import networkx as nx
import finalexam

G = nx.read_weighted_edgelist('dij.edgelist', nodetype=int)

def my_shortestpaths(G, s):
    nodes= list(G.nodes())
    paths= [[]] * len(nodes)
    paths_iter= 0
    _, P = finalexam.my_Dijkstra(G, 0)
    for node in nodes:
        paths[paths_iter]= finalexam.restore_shortestpath(s, node, P)
        paths_iter+= 1
    return paths

paths= my_shortestpaths(G, 0)
for p in paths:
    print(p)