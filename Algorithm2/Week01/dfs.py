import networkx as nx
import matplotlib.pyplot as plt

def dfs_inner(graph, visited, index):
    print(index)
    visited.add(index)
    # print("Visited:", visited)
    neighbors= graph.neighbors(index)
    for n in neighbors:
        if n not in visited:
            dfs_inner(graph, visited, n)

def dfs(graph, start):
    visited= set()
    dfs_inner(graph, visited, start)

G= nx.read_edgelist('test.edgelist', nodetype=int)

dfs(G, 2)

nx.draw_networkx(G)
plt.show()
