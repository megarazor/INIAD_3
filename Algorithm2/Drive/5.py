import networkx as nx

def my_extract_min2(D, X):
  arg_min = -1
  min_value = float('inf')
  
  for i in X:
    if D[i] < min_value:
        arg_min = i
        min_value = D[i]
  
  return arg_min

def my_Prim(G, source):
  X = set(G.nodes)
  D = [float('inf')] * nx.number_of_nodes(G)
  D[source] = 0
  P = [0] * nx.number_of_nodes(G)
  A = []
  while X:
    u = my_extract_min2(D, X)
    X.remove(u)
    if u != source:
      A.append((P[u], u))
    for v in G.neighbors(u):
      if v in X:
        new_distance = G.edges[u, v]['weight']
        if D[v] > new_distance:
          D[v] = new_distance
          P[v] = u
  return A

