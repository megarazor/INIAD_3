import networkx as nx
import finalexam

G = nx.read_weighted_edgelist('dij.edgelist', nodetype=int)
D, P = finalexam.my_Dijkstra(G, 0)
print(D)
print(P)