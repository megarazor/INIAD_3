import networkx as nx
import numpy as np

def graph_to_matrix(G):
    n= nx.number_of_nodes(G)
    A= nx.adjacency_matrix(G, nodelist=range(n), weight=None)
    A= A.todense()
    A= A.astype(float)

    A= A.transpose()
    cols_sum= A.sum(axis=0)
    
    for i in range(n):
        if cols_sum[0, i] != 0:
            A[:,i]= A[:,i] / cols_sum[0, i]
        else:
            A[:,i]= np.ones((n, 1))
            A[:,i]= A[:,i] / n
    return A

def update(G, v, d, k):
    n= nx.number_of_nodes(G)
    A= graph_to_matrix(G)
    J= np.copy(A)
    for i in range(n):
        J[:,i]= J[:,i] * 0 + 1/n
    Mg= d * A  + (1 - d) * J
    for i in range(k - 1):
        Mg= Mg * Mg
    Mg= Mg * v
    return Mg

G= nx.read_edgelist('pr.edgelist', create_using=nx.DiGraph(), nodetype=int)
n= nx.number_of_nodes(G)
v= np.ones((n, 1))/n

print("My PageRank: ", update(G, v, 0.85, 30))
print("Networkx PageRank: ", nx.pagerank(G, alpha=0.85))