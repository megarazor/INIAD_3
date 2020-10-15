import networkx as nx
import matplotlib.pyplot as plt

def get_min(D, X):
    arg_min= -1 # Set default min position to -1
    min_value= float('inf') # Set default min value to infinity
    for i in X: # for each vertex in set X
        if D[i] < min_value: # Perform basic finding min procedure
            arg_min= i
            min_value= D[i]
    return arg_min # Return the min vertex

def dijkstra(src, G):
    D= [float('inf')] * nx.number_of_nodes(G) # Set of Dijkstra value at each vertex, initialized to infiniy on every vertex execpt source
    D[src]= 0.0 # Except the source vertex
    X= set(G.nodes) # Vertices set of G
    while X: # Loop until X is empty
        u= get_min(D, X) # Get the vertex with minimum value among X
        X.remove(u) # Remove that vertex from X
        neighbors= G.neighbors(u) # Get all the neighbors of that vertex
        for v in neighbors: # For each neighbor of vertex u
            if v in X: # if v is in set X
                if (D[u] + G.edges[u, v]['weight'] < D[v]): # Compare the new distance to the current distance of that vertex in D
                    D[v]= D[u] + G.edges[u, v]['weight'] # If the new distance is shorter, assign it
    return D # Return the list of shortest distances

def set_shortestpath(G, Y):
    DD= [] # Output list of list
    for n in Y: # For each vertex in subset node Y
        DD.append(dijkstra(n, G)) # Perform Dijkstra to calcute shortest distances from that vertex to every vertex in G then append the list of shortest distances to the output list of list
    return DD # Return output list of list when done

G= nx.read_weighted_edgelist('dij.edgelist', nodetype=int)

# Y= set(G.nodes)
Y = set([0, 3, 5])
DD= set_shortestpath(G, Y)
print(DD)


nx.draw_networkx(G)

plt.show()
