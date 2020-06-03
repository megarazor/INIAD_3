import networkx as nx
import matplotlib.pyplot as plt

def get_min(D, X):
    arg_min= -1
    min_value= float('inf')
    for i in X:
        if D[i] < min_value:
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

def djk_all(G):
    nds= list(G.nodes())
    DD= []
    for n in nds:
        DD.append(dijkstra(n, G))
    return DD

def short_grh(G):
    DD= djk_all(G)
    G2= nx.Graph()
    G2.add_nodes_from(list(G.nodes()))
    for u in G.nodes():
        for v in G.nodes():
            if u != v:
                G2.add_edge(u, v, weight=DD[u][v])
    return G2

G= nx.read_weighted_edgelist('dij.edgelist', nodetype=int)
G2= short_grh(G)

print(djk_all(G))

for u in G2.nodes():
    for v in G2.nodes():
        if u != v:
            print(u, "<->", v, ":", G2.get_edge_data(u, v)['weight'])

nx.draw_networkx(G2)
plt.show()
