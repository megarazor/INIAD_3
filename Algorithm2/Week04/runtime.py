import networkx as nx
import random
import time

def get_min(D, X):
    arg_min= -1
    min_value= float('inf')

    for i in range(len(D)):
        if D[i] < min_value:
            if i in X:
                arg_min= i
                min_value= D[i]
    return arg_min

def dijkstra(src, G):
    D= [float('inf')] * nx.number_of_nodes(G)
    D[src]= 0.0
    X= set(G.nodes)
    while X:
        u= get_min(D, X)
        X.remove(u)
        neighbors= G.neighbors(u)
        for v in neighbors:
            if v in X:
                if (D[u] + G.edges[u, v]['weight'] < D[v]):
                    D[v]= D[u] + G.edges[u, v]['weight']
    return D

p= 0.01

# for i in range(1, 11):
#     print("With n=", i*1000, ", p=", p, ", creating graph ", i, "...", sep="")
#     #Create graph
#     G= nx.fast_gnp_random_graph(i*1000, p)
#     for (u, v) in G.edges():
#         G.edges[u, v]['weight']= random.randint(1, 100)
#     nx.write_weighted_edgelist(G, "random_" + str(i*1000) +  ".edgelist")

for i in range(1, 11):
    #Read & run Dijkstra
    G= nx.read_weighted_edgelist("random_" + str(i*1000) +  ".edgelist", nodetype=int)
    start= time.time()
    D= dijkstra(0, G)
    elapsed_time= time.time() - start
    print("Graph", i, ": ", elapsed_time, sep="")
