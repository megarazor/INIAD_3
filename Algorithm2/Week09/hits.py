import networkx as nx
import numpy as np

def HITS_update(G, h0, k):
    n= nx.number_of_nodes(G)
    A= nx.adjacency_matrix(G, nodelist=range(n), weight=None)
    A= A.todense()
    A= A.astype(float)
    At= A.transpose()

    hub_score= h0
    aut_score= np.ones((n, 0))

    for _ in range(k):
        # Update auth score
        aut_score= At * hub_score
        # Update hub score
        hub_score= A * aut_score
        # Normalization
        aut_sum= aut_score.sum(axis=0)
        hub_sum= hub_score.sum(axis=0)
        aut_score= aut_score / aut_sum
        hub_score= hub_score / hub_sum
        
    return aut_score, hub_score


G= nx.read_edgelist('pr.edgelist', create_using=nx.DiGraph(), nodetype=int)
n= nx.number_of_nodes(G)
h0= np.ones((n, 1))

aut_score, hub_score= HITS_update(G, h0, 215)

print("My HITS: \n", aut_score, "\n\n", hub_score)

nstart= {0: 1, 1: 1, 2: 1, 3: 1, 4: 1, 5: 1, 6: 1, 7: 1, 8: 1, 9: 1, 10: 1, 11: 1}

nx_hub, nx_aut= nx.hits(G, nstart=nstart)

print("NetworkX's HITS: \n",nx_aut, "\n\n", nx_hub)