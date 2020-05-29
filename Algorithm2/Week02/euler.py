import networkx as nx
import matplotlib.pyplot as plt

def has_euler(graph):
    degrees = [value for (vertex, value) in graph.degree()]
    for d in degrees:
        if d % 2 == 1:
            return False
    return True

G= nx.read_edgelist('test.edgelist', nodetype=int)

print(has_euler(G))

nx.draw_networkx(G)
plt.show()
