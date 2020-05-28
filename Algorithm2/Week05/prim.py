import networkx as nx
import heapq

def prim(G, src):
    A= []
    X= set(G.nodes)
    D= [float('inf')] * nx.number_of_nodes(G)
    D[src]= 0.0
    pi= [0] * nx.number_of_nodes(G)
    Q= []
    heapq.heappush(Q, (0, src))

    while X:
        _, u= heapq.heappop(Q)
        if u not in X:
            continue
        X.remove(u)
        # print("Removed", u)
        if u != src:
            A.append((pi[u], u))
        neighbors= G.neighbors(u)
        for v in neighbors:
            if v in X:
                if (G.edges[u, v]['weight'] < D[v]):
                    D[v]= G.edges[u, v]['weight']
                    pi[v]= u
                    heapq.heappush(Q, (G.edges[u, v]['weight'] , v))
    return A

G= nx.read_weighted_edgelist('dij.edgelist', nodetype=int)

spn_tree= prim(G, 0)
print("Minimum spanning tree:", spn_tree)
