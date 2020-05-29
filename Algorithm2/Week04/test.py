import networkx as nx
import matplotlib.pyplot as plt
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

G= nx.read_weighted_edgelist('dij.edgelist', nodetype=int)

print(dijkstra(0, G))

nx.draw_networkx(G)

plt.show()