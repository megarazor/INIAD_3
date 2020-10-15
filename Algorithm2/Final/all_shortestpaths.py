import networkx as nx
import finalexam

G = nx.read_weighted_edgelist('all_shortestpaths.edgelist', nodetype=int)

def all_shortestpath(G):
  DD = []
  for i in sorted(G.nodes()):
    D, P = finalexam.my_Dijkstra(G, i)
    DD.append(D)
  return DD

DD = all_shortestpath(G)
print(DD[0])
print(DD[3])