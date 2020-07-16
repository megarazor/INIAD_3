import networkx as nx
import heapq
import random

def my_heap_Dijkstra(G, source):
  X = set(G.nodes)
  D = [float('inf')] * nx.number_of_nodes(G) 
  D[source] = 0
  Q = []
  heapq.heappush(Q, (D[source], source))
  while Q:
    u_distance, u = heapq.heappop(Q)
    if D[u] < u_distance:
      continue    
    X.remove(u)  
    for v in G.neighbors(u):
      if v in X:
        new_distance = u_distance + G.edges[u, v]['weight']
        if D[v] > new_distance:
          D[v] = new_distance
          heapq.heappush(Q, (new_distance, v))
  return D



for i in range(1000,11000,1000):
  G = nx.fast_gnp_random_graph(i, 0.01)
  
  for (u, v) in G.edges():
    G.edges[u,v]['weight'] = random.randint(1,100)
  
  nx.write_weighted_edgelist(G, "r_" + str(i) + ".edgelist")


