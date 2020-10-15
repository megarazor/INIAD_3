import networkx as nx
import finalexam

G= nx.read_weighted_edgelist('maxflow.edgelist', create_using=nx.DiGraph(), nodetype=int)

def residual_network(G, f):
  N = G.copy()
  for (u, v), amount in f.items():
    N.edges[(u, v)]['weight'] -= amount
    if not G.has_edge(v, u):
      N.add_edge(v, u, weight=0)
    N.edges[(v, u)]['weight'] += amount
  return N

f = {(0, 1) : 5, (1, 2): 5, (2, 3) : 5}
N = residual_network(G, f)
print(N.edges(data=True))