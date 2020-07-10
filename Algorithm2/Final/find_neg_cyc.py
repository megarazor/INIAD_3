# For undirected graphs
# Find cycles with negative total weight

import networkx as nx
import itertools
import finalexam

def is_cycle(comb):
    for edge in comb:
        app1= 1
        app2= 1
        for e in comb:
            if e != edge:
                if edge[0] == e[0] or edge[0] == e[1]:
                    app1+= 1
                if edge[1] == e[1] or edge[1] == e[0]:
                    app2+= 1
        if app1 % 2 != 0 or app2 % 2 != 0:
            return False
    return True
        
def is_negative(G, comb):
    sum= 0
    for edge in comb:
        u= edge[0]
        v= edge[1]
        sum+= G[u][v]['weight']
    if sum < 0:
        return True
    return False


def find_neg_cyc(G):
    edges= list(G.edges())
    cycles= []
    for L in range(3, len(edges)+1):
        for comb in itertools.combinations(edges, L):
            if is_cycle(comb) and is_negative(G, comb):
                cycles.append(comb)
    return cycles 

G= nx.read_weighted_edgelist('find_neg_cyc.edgelist', nodetype=int)
print(find_neg_cyc(G))