import networkx as nx

def my_euler_test(G):
  for v in G.nodes:
    d = G.degree[v]
    if d % 2 == 1:
      return False
  return True

