import networkx as nx
import matplotlib.pyplot as plt

G= nx.read_edgelist('test.edgelist', nodetype=int)

nx.graph_networkx(G)
plt.show()
