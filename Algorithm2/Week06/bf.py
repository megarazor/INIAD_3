import networkx as nx

G= nx.read_weighted_edgelist('bf.edgelist', create_using=nx.DiGraph(), nodetype=int)

def bf(G, s):
    n= nx.number_of_nodes(G)
    D= [float('inf')] * n
    D[s]= 0
    D_new= []
    for _ in range (0, n-1):
        D_new= D[:]
        for u, v in G.edges():
            if D_new[v] > D[u] + G.edges[u, v]['weight']:
                D_new[v]= D[u] + G.edges[u, v]['weight']
        D= D_new
    for u, v in G.edges():
        if D[v] > D[u] + G.edges[u, v]['weight']:
            return False, D
    return True, D

flag, D= bf(G, 0)
print(flag)
print(D)
