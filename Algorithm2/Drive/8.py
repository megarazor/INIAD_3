import networkx as nx
import numpy as np

def transition_matrix(G): 
  n = nx.number_of_nodes(G)
  A = nx.adjacency_matrix(G, nodelist=range(n), weight=None)
  A = A.todense()
  A = A.astype(float)
  A = A.transpose()
  cols_sum = A.sum(axis=0)
  
  for i in range(n):
    s = cols_sum[0, i]
    if s != 0:
      A[:,i] = A[:,i]/s
    else:
      A[:,i] = 1/n
  return A

def update(G, v, d, k):
  A = transition_matrix(G)
  n = nx.number_of_nodes(G)
  J = np.ones((n, n))/n
  Mg = d * A  + (1-d) * J
  
  for _ in range(k):
    v = Mg * v
  
  return v


