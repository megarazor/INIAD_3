import networkx as nx
import numpy as np


def HITS_update(G, h0, k): 
  n = nx.number_of_nodes(G)
  A = nx.adjacency_matrix(G, weight=None)
  A = A.todense()
  A = A.astype(float)
  AT = A.transpose()
  
  hk = h0
  for _ in range(k):
    ak = AT * hk
    hk = A * ak
    
    ak = ak/ak.sum(axis=0)
    hk = hk/hk.sum(axis=0)
  return ak, hk

