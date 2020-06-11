import networkx as nx
import matplotlib.pyplot as plt

def cycle_check(G):
    try:
       nx.find_cycle(G, source=None, orientation='original')
    except:
        return False
    return True


def kruskal(G):
    H= nx.Graph()
    H.add_nodes_from(G)
    edges= sorted(G.edges(data=True), key=lambda t: t[2].get('weight', 1))
    for e in edges:
        # print(e[2]['weight'])
        H.add_edge(e[0], e[1], weight=e[2]['weight'])
        if cycle_check(H) == True:
            H.remove_edge(e[0], e[1])
    return H

G= nx.read_weighted_edgelist('kru.edgelist', nodetype=int)

H= kruskal(G)

print(H.edges)

nx.draw_networkx(G)

plt.show()
