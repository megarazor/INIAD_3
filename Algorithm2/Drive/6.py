import networkx as nx


def my_Bellman_Ford(G, source):
  n = nx.number_of_nodes(G)
  D = [float('inf')] * n
  D[source] = 0
  
  for i in range(1, n):
    D_new = D[:]
    
    for u, v in G.edges():
      new_distance = D[u] + G.edges[u, v]['weight']
      if D_new[v] > new_distance:
        D_new[v] = new_distance
    D = D_new
  
  for u, v in G.edges():
    if D[v] > D[u] + G.edges[u, v]['weight']:
      return (False, D)
  
  return (True, D)
