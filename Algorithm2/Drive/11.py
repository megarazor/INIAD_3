import networkx as nx
import queue

def mincut_dfs(G, source):
  visited = set()
  stack = queue.LifoQueue()
  stack.put(source)
  while not stack.empty():
    v = stack.get()
    if not v in visited:
      visited.add(v)
    for w in G.neighbors(v):
        if not w in visited and G.edges[v, w]['weight'] > 0:
          stack.put(w)
  return visited, set(G.nodes)-visited
