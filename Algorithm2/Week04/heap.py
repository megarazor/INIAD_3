import networkx as nx
import random, time
import heapq

def dijkstra(src, G):
    X= set(G.nodes)
    D= [float('inf')] * nx.number_of_nodes(G)
    D[src]= 0.0
    Q= []
    heapq.heappush(Q, (0, src))

    while X:
        _, u= heapq.heappop(Q)
        if u not in X:
            continue
        X.remove(u)

        neighbors= G.neighbors(u)
        for v in neighbors:
            if v in X:
                if (D[u] + G.edges[u, v]['weight'] < D[v]):
                    D[v]= D[u] + G.edges[u, v]['weight']
                    heapq.heappush(Q, (D[u] + G.edges[u, v]['weight'] , v))
    return D

p= 0.01

for i in range(1, 11):
    #Read & run Dijkstra
    G= nx.read_weighted_edgelist("random_" + str(i*1000) +  ".edgelist", nodetype=int)
    start= time.time()
    D= dijkstra(0, G)
    elapsed_time= time.time() - start
    print("Graph", i, ": ", elapsed_time, sep="")
