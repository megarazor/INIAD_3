import networkx as nx
import numpy as np
import matplotlib.pyplot as plt
import finalexam

def construct_network(G, A, B):
    n= nx.number_of_nodes(G)
    s= n
    t= n + 1
    G.add_nodes_from([s, t])
    for v in A:
        G.add_edge(s, v, weight=1)
    for v in B:
        G.add_edge(v, t, weight=1)
    return s, t

def extract_middle_edges(f, s, t):
    flowing_edges= set()
    for edge, flow in f.items():
        if flow > 0 and edge[0] != s and edge[1] != t:
            flowing_edges.add(edge)
    return flowing_edges

def my_bipartite_matching(G, A, B):
    s, t= construct_network(G, A, B)
    _, f= finalexam.my_Ford_Fulkerson(G, s, t)
    f_m= extract_middle_edges(f, s, t)
    return f_m


G= nx.read_weighted_edgelist('bipartite.edgelist', create_using=nx.DiGraph(), nodetype=int)
A= {0, 1, 2, 3, 4}
B= {5, 6, 7, 8, 9}
flowing_edges= my_bipartite_matching(G, A, B)
print(flowing_edges)

# nx.draw_networkx(N)
# plt.show()