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

G= nx.read_edgelist('pr.edgelist', create_using=nx.DiGraph(), nodetype=int)

A= graph_to_matrix(G)
print(A)
