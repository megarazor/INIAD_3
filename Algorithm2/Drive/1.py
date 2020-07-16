import networkx as nx
import queue

def my_dfs(G, source):
  visited = set()
  stack = queue.LifoQueue()
  stack.put(source)
  
  while not stack.empty():
    v = stack.get()
    
    if not v in visited:
      visited.add(v)
      print(v)
      for w in G.neighbors(v):
        if not w in visited:
          stack.put(w)
